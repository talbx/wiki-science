package org.unihh.basecamp.g4.wiki.backend.functions;

import org.springframework.stereotype.Component;
import org.unihh.basecamp.g4.wiki.backend.entity.CountryCount;
import org.unihh.basecamp.g4.wiki.backend.entity.LatestContributorsEntity;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Component
public class ContributionsPerCountry implements BiFunction<Supplier<Map<String, GeoLocation>>, Supplier<List<LatestContributorsEntity>>, List<CountryCount>> {

    @Override
    public List<CountryCount> apply(final Supplier<Map<String, GeoLocation>> geolocationSupplier, final Supplier<List<LatestContributorsEntity>> ipSupplier) {
        List<CountryCount> countryCounts = new ArrayList<>() ;
        Map<String, Integer> map = new HashMap<>();
        for (LatestContributorsEntity ip : ipSupplier.get()) {
            for (Map.Entry<String, GeoLocation> entry : geolocationSupplier.get().entrySet()) {
                if (ip.getUsername().equals(entry.getKey())) {
                    String country = entry.getValue().getName();
                    map.put(country, map.getOrDefault(country, 0) + ip.getContributions());
                }
            }
        }
        map.forEach((key, value) -> {
            CountryCount countryCount = CountryCount.builder().country(key).count(value).build();
            countryCounts.add(countryCount);
        });
        return countryCounts;
    }
}
