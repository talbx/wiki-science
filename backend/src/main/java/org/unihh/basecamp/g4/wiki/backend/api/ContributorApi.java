package org.unihh.basecamp.g4.wiki.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.unihh.basecamp.g4.wiki.backend.entity.LatestContributorsEntity;
import org.unihh.basecamp.g4.wiki.backend.functions.FindLocationForIp;
import org.unihh.basecamp.g4.wiki.backend.functions.GeoLocation;
import org.unihh.basecamp.g4.wiki.backend.functions.IPFilter;
import org.unihh.basecamp.g4.wiki.backend.persistence.LatestContributorsRepository;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/contributors")
public class ContributorApi {

    private final LatestContributorsRepository latestContributorsRepository;
    private final FindLocationForIp locationFinder;
    private final IPFilter ipFilter;

    @Autowired
    public ContributorApi(final LatestContributorsRepository latestContributorsRepository, final FindLocationForIp locationFinder, final IPFilter ipFilter) {
        this.latestContributorsRepository = latestContributorsRepository;
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

    public List<LatestContributorsEntity> top100Ips() {
        return latestContributorsRepository.top100Ips().stream()
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

        Set<Map.Entry<String, GeoLocation>> entries = geolocation.entrySet();

        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, GeoLocation> entry : entries) {
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

        Set<Map.Entry<String, GeoLocation>> entries = geolocation.entrySet();

        Map<String, Integer> map = new HashMap<>();
        for (LatestContributorsEntity ip : top100Ips) {
            for (Map.Entry<String, GeoLocation> entry : entries) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + ip.getContributions());
                }
            }
        }
        return map;
    }
}
