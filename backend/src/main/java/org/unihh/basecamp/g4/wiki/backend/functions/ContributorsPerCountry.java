package org.unihh.basecamp.g4.wiki.backend.functions;

import org.springframework.stereotype.Component;
import org.unihh.basecamp.g4.wiki.backend.entity.CountryCount;
import org.unihh.basecamp.g4.wiki.backend.entity.LatestContributorsEntity;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Component
public class ContributorsPerCountry implements BiFunction<Supplier<Map<String, GeoLocation>>, Supplier<List<LatestContributorsEntity>>, List<CountryCount>> {

    @Override
    public List<CountryCount> apply(final Supplier<Map<String, GeoLocation>> geolocationSupplier, final Supplier<List<LatestContributorsEntity>> ipSupplier) {
        List<CountryCount> countryCounts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, GeoLocation> entry : geolocationSupplier.get().entrySet()) {
            ipSupplier.get().stream()
                    .filter(e -> Objects.equals(e.getUsername(), entry.getKey()))
                    .map(e -> entry.getValue().getName())
                    .forEach(t -> map.put(t, map.getOrDefault(t, 0) + 1));
        }

        map.forEach((key, value) -> {
            CountryCount countryCount = CountryCount.builder().country(key).count(value).build();
            countryCounts.add(countryCount);
        });

        return countryCounts;
    }
}
