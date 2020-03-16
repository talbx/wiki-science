package org.unihh.basecamp.g4.wiki.backend.api;

import io.vavr.Function3;
import org.apache.logging.log4j.util.TriConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unihh.basecamp.g4.wiki.backend.entity.CountryCount;
import org.unihh.basecamp.g4.wiki.backend.entity.LatestContributorsEntity;
import org.unihh.basecamp.g4.wiki.backend.entity.PremiumContributorsEntity;
import org.unihh.basecamp.g4.wiki.backend.functions.FindLocationForIp;
import org.unihh.basecamp.g4.wiki.backend.functions.GeoLocation;
import org.unihh.basecamp.g4.wiki.backend.functions.IPFilter;
import org.unihh.basecamp.g4.wiki.backend.persistence.LatestContributorsRepository;
import org.unihh.basecamp.g4.wiki.backend.persistence.PremiumContributorsRepository;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:50361", "http://localhost:8080", "https://uguri.github.io/wikiScience/"})
@RestController
@RequestMapping(path = "/api/contributors")
public class ContributorApi {

    private final LatestContributorsRepository latestContributorsRepository;
    private final PremiumContributorsRepository premiumContributorsRepository;
    private final FindLocationForIp locationFinder;
    private final IPFilter ipFilter;

    @Autowired
    public ContributorApi(final LatestContributorsRepository latestContributorsRepository, final PremiumContributorsRepository premiumContributorsRepository, final FindLocationForIp locationFinder, final IPFilter ipFilter) {
        this.latestContributorsRepository = latestContributorsRepository;
        this.premiumContributorsRepository = premiumContributorsRepository;
        this.locationFinder = locationFinder;
        this.ipFilter = ipFilter;
    }

    @RequestMapping(path = "/contributorCount", method = RequestMethod.GET)
    public Long getContributorCount() {
        return latestContributorsRepository.count();
    }

    @RequestMapping(path = "/top100", method = RequestMethod.GET)
    public List<LatestContributorsEntity> top100LatestContributors() {
        return latestContributorsRepository.findTop100ByOrderByContributionsDesc();
    }

    @RequestMapping(path = "/findByMoment/{year}", method = RequestMethod.GET)
    public Long findByMoment(@PathVariable("year") String year) {
        List<PremiumContributorsEntity> entities = premiumContributorsRepository.findByYear(year);
        return countUsernames(entities);

    }

    @RequestMapping(path = "/findByMoment/{year}/{month}", method = RequestMethod.GET)
    public Long findByMoment(@PathVariable("year") String year, @PathVariable("month") String month) {
        List<PremiumContributorsEntity> entities = premiumContributorsRepository.findByYearMonth(year, month);
        return countUsernames(entities);

    }

    @RequestMapping(path = "/findByMoment/{year}/{month}/{day}", method = RequestMethod.GET)
    public Long findByMoment(@PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("day") String day) {
        List<PremiumContributorsEntity> entities = premiumContributorsRepository.findByYearMonthDay(year, month, day);
        return countUsernames(entities);
    }

    @RequestMapping(path = "/findByTime/{time}", method = RequestMethod.GET)
    public Long findByTime(@PathVariable("time") String time) {
        List<PremiumContributorsEntity> entities = premiumContributorsRepository.findByTime(time);
        return countUsernames(entities);
    }

    private BiFunction<String, Integer, CountryCount> buildCountryCount = (k, v) -> CountryCount.builder().country(k).count(v).build();
    private BiConsumer<List<CountryCount>, CountryCount> addToList = List::add;

    @RequestMapping(path = "/contributorsPerCountry", method = RequestMethod.GET)
    public List<CountryCount> contributorsPerCountry() {
        List<LatestContributorsEntity> top100Ips = top100Ips();
        Map<String, GeoLocation> locations = locationFinder.apply(top100Ips);

        List<CountryCount> countryCounts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        buildContributorMap(top100Ips, locations, map);

        map.forEach((key, value) -> {
            CountryCount countryCount = CountryCount.builder().country(key).count(value).build();
            countryCounts.add(countryCount);
        });

        return countryCounts;
    }

    @RequestMapping(path = "/contributorsPerCountry10K", method = RequestMethod.GET)
    public List<CountryCount> contributorsPerCountry10K() {
        List<LatestContributorsEntity> topIps = top10000Ips();
        Map<String, GeoLocation> locations = locationFinder.apply(topIps);

        List<CountryCount> countryCounts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        buildContributorMap(topIps, locations, map);

        map.forEach((k, v) -> addToList(countryCounts, k,v));
        return countryCounts;
    }

    @RequestMapping(path = "/contributionsPerCountry", method = RequestMethod.GET)
    public List<CountryCount> contributionsPerCountry() {
        List<LatestContributorsEntity> top100Ips = top100Ips();
        Map<String, GeoLocation> locations = locationFinder.apply(top100Ips);

        List<CountryCount> countryCounts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        return getCountryCounts(top100Ips, locations, countryCounts, map);
    }

    @RequestMapping(path = "/contributionsPerCountry10K", method = RequestMethod.GET)
    public List<CountryCount> contributionsPerCountry10K() {
        List<LatestContributorsEntity> topIps = top10000Ips();

        Map<String, GeoLocation> locations = locationFinder.apply(topIps);
        List<CountryCount> countryCounts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        return getCountryCounts(topIps, locations, countryCounts, map);
    }

    private void buildContributorMap(final List<LatestContributorsEntity> topIps, final Map<String, GeoLocation> locations, final Map<String, Integer> map) {
        for (Map.Entry<String, GeoLocation> entry : locations.entrySet()) {
            for (LatestContributorsEntity ip : topIps) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + 1);
                }
            }
        }
    }

    private void addToList(List<CountryCount> countryCounts, String key, Integer value) {
        countryCounts.add(CountryCount.builder().country(key).count(value).build());
    }



    private List<CountryCount> getCountryCounts(final List<LatestContributorsEntity> ips, final Map<String, GeoLocation> locations, final List<CountryCount> countryCounts, final Map<String, Integer> map) {
        for (LatestContributorsEntity ip : ips) {
            for (Map.Entry<String, GeoLocation> entry : locations.entrySet()) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + ip.getContributions());
                }
            }
        }
        map.forEach((k, v) -> addToList(countryCounts, k,v));

        return countryCounts;
    }



    private Long countUsernames(List<PremiumContributorsEntity> entities) {
        return entities.stream().map(PremiumContributorsEntity::getUsername).distinct().count();
    }

    private List<LatestContributorsEntity> top100Ips() {
        return ips(latestContributorsRepository::top100Ips);
    }

    private List<LatestContributorsEntity> top10000Ips() {
        return ips(latestContributorsRepository::top10000Ips);
    }

    private List<LatestContributorsEntity> ips(Supplier<List<LatestContributorsEntity>> function) {
        return function.get().stream()
                .filter(Objects::nonNull)
                .filter(x -> ipFilter.test(x.getUsername()))
                .collect(Collectors.toList());
    }
}
