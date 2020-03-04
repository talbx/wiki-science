package org.unihh.basecamp.g4.wiki.backend.api;

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
import java.util.function.Supplier;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:50361")
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
    public Long findByMoment(@PathVariable("year") String year){
        List<PremiumContributorsEntity> entities = premiumContributorsRepository.findByYear(year);
        return countUsernames(entities);

    }

    @RequestMapping(path = "/findByMoment/{year}/{month}", method = RequestMethod.GET)
    public Long findByMoment(@PathVariable("year") String year, @PathVariable("month") String month){
        List<PremiumContributorsEntity> entities = premiumContributorsRepository.findByYearMonth(year, month);
        return countUsernames(entities);

    }

    @RequestMapping(path = "/findByMoment/{year}/{month}/{day}", method = RequestMethod.GET)
    public Long findByMoment(@PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("day") String day){
        List<PremiumContributorsEntity> entities =  premiumContributorsRepository.findByYearMonthDay(year, month, day);
        return countUsernames(entities);
    }

    @RequestMapping(path = "/findByTime/{time}", method = RequestMethod.GET)
    public Long findByTime(@PathVariable("time") String time){
        List<PremiumContributorsEntity> entities = premiumContributorsRepository.findByTime(time);
        return countUsernames(entities);
    }

    private Long countUsernames(List<PremiumContributorsEntity> entities){
        return entities.stream().map(PremiumContributorsEntity::getUsername).distinct().count();
    }

    public List<LatestContributorsEntity> top100Ips() {
        return ips(latestContributorsRepository::top100Ips);
    }

    public List<LatestContributorsEntity> top10000Ips() {
        return ips(latestContributorsRepository::top10000Ips);
    }

    private List<LatestContributorsEntity> ips(Supplier<List<LatestContributorsEntity>> function){
        return function.get().stream()
                .filter(Objects::nonNull)
                .filter(x -> ipFilter.test(x.getUsername()))
                .collect(Collectors.toList());
    }


    @RequestMapping(path = "/geolocation1", method = RequestMethod.GET)
    public Map<String, GeoLocation> getGeolocation() {
        return locationFinder.apply(top100Ips());
    }

    @RequestMapping(path = "/geolocation3", method = RequestMethod.GET)
    public Map<String, GeoLocation> getGeolocation3() {
        return locationFinder.apply(top10000Ips());
    }

    @RequestMapping(path = "/contributorsPerCountry", method = RequestMethod.GET)
    public List<CountryCount> contributorsPerCountry() {
        Map<String, GeoLocation> geolocation = getGeolocation();
        List<LatestContributorsEntity> top100Ips = top100Ips();

        List<CountryCount> countryCounts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, GeoLocation> entry : geolocation.entrySet()) {
            for (LatestContributorsEntity ip : top100Ips) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + 1);
                }
            }
        }

        map.forEach((key, value) -> {
            CountryCount countryCount = CountryCount.builder().country(key).count(value).build();
            countryCounts.add(countryCount);
        });

        return countryCounts;
    }

    @RequestMapping(path = "/contributorsPerCountry10K", method = RequestMethod.GET)
    public List<CountryCount> contributorsPerCountry10K() {
        Map<String, GeoLocation> geolocation = getGeolocation3();
        List<LatestContributorsEntity> top100Ips = top10000Ips();

        List<CountryCount> countryCounts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, GeoLocation> entry : geolocation.entrySet()) {
            for (LatestContributorsEntity ip : top100Ips) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + 1);
                }
            }
        }

        map.forEach((key, value) -> {
            CountryCount countryCount = CountryCount.builder().country(key).count(value).build();
            countryCounts.add(countryCount);
        });

        return countryCounts;
    }


    @RequestMapping(path = "/contributionsPerCountry", method = RequestMethod.GET)
    public List<CountryCount> contributionsPerCountry() {
        Map<String, GeoLocation> geolocation = getGeolocation();
        List<LatestContributorsEntity> top100Ips = top100Ips();

        List<CountryCount> countryCounts = new ArrayList<>() ;
        Map<String, Integer> map = new HashMap<>();
        for (LatestContributorsEntity ip : top100Ips) {
            for (Map.Entry<String, GeoLocation> entry : geolocation.entrySet()) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + ip.getContributions());
                }
            }
        }
        map.entrySet().forEach(e -> {
            CountryCount countryCount = CountryCount.builder().country(e.getKey()).count(e.getValue()).build();
            countryCounts.add(countryCount);
        });
        return countryCounts;
    }

    @RequestMapping(path = "/contributionsPerCountry10K", method = RequestMethod.GET)
    public List<CountryCount> contributionsPerCountry10K() {
        Map<String, GeoLocation> geolocation = getGeolocation3();
        List<LatestContributorsEntity> top100Ips = top10000Ips();

        List<CountryCount> countryCounts = new ArrayList<>() ;
        Map<String, Integer> map = new HashMap<>();
        for (LatestContributorsEntity ip : top100Ips) {
            for (Map.Entry<String, GeoLocation> entry : geolocation.entrySet()) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + ip.getContributions());
                }
            }
        }
        map.entrySet().forEach(e -> {
            CountryCount countryCount = CountryCount.builder().country(e.getKey()).count(e.getValue()).build();
            countryCounts.add(countryCount);
        });
        return countryCounts;
    }
}
