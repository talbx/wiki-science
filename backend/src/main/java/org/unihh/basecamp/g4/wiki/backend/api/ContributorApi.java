package org.unihh.basecamp.g4.wiki.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(path = "/2019ers", method = RequestMethod.GET)
    public List<PremiumContributorsEntity> find2019ers() {
        return premiumContributorsRepository.findByYear("2019");
    }

    @RequestMapping(path = "/findByMoment/{year}", method = RequestMethod.GET)
    public List<PremiumContributorsEntity> findByMoment(@PathVariable("year") String year){
        return premiumContributorsRepository.findByYear(year);
    }

    @RequestMapping(path = "/findByMoment/{year}/{month}", method = RequestMethod.GET)
    public List<PremiumContributorsEntity> findByMoment(@PathVariable("year") String year, @PathVariable("month") String month){
        return premiumContributorsRepository.findByYearMonth(year, month);
    }

    @RequestMapping(path = "/findByMoment/{year}/{month}/{day}", method = RequestMethod.GET)
    public List<PremiumContributorsEntity> findByMoment(@PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("day") String day){
        return premiumContributorsRepository.findByYearMonthDay(year, month, day);
    }

    @RequestMapping(path = "/findByTime/{time}", method = RequestMethod.GET)
    public List<PremiumContributorsEntity> findByTime(@PathVariable("time") String time){
        return premiumContributorsRepository.findByTime(time);
    }

    public List<LatestContributorsEntity> top100Ips() {
        return ips(latestContributorsRepository::top100Ips);
    }

    private List<LatestContributorsEntity> ips(Supplier<List<LatestContributorsEntity>> function){
        return function.get().stream()
                .filter(Objects::nonNull)
                .filter(x -> ipFilter.test(x.getUsername()))
                .collect(Collectors.toList());
    }


    @RequestMapping(path = "/geolocation", method = RequestMethod.GET)
    public Map<String, GeoLocation> getGeolocation() {
        return locationFinder.apply(top100Ips());
    }

    @RequestMapping(path = "/contributorsPerCountry", method = RequestMethod.GET)
    public Map<String, Integer> contributorsPerCountry() {
        Map<String, GeoLocation> geolocation = getGeolocation();
        List<LatestContributorsEntity> top100Ips = top100Ips();

        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, GeoLocation> entry : geolocation.entrySet()) {
            for (LatestContributorsEntity ip : top100Ips) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + 1);
                }
            }
        }
        return map;
    }


    @RequestMapping(path = "/contributionsPerCountry", method = RequestMethod.GET)
    public Map<String, Integer> contributionsPerCountry() {
        Map<String, GeoLocation> geolocation = getGeolocation();
        List<LatestContributorsEntity> top100Ips = top100Ips();

        Map<String, Integer> map = new HashMap<>();
        for (LatestContributorsEntity ip : top100Ips) {
            for (Map.Entry<String, GeoLocation> entry : geolocation.entrySet()) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + ip.getContributions());
                }
            }
        }
        return map;
    }
}
