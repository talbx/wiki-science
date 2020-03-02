package org.unihh.basecamp.g4.wiki.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class GeoFetch implements Function<List<String>, Map<String, GeoLocation>> {

    private final RestTemplateBuilder templateBuilder;

    @Autowired
    public GeoFetch(final RestTemplateBuilder templateBuilder) {
        this.templateBuilder = templateBuilder;
    }

    @Override
    public Map<String, GeoLocation> apply(final List<String> strings) {
        Map<String, GeoLocation> obj = new HashMap<>();
        for (String s : strings) {
            try {
                GeoLocation forObject = templateBuilder.build().getForObject(new URI("https://api.ipgeolocationapi.com/geolocate/" + s), GeoLocation.class);
                obj.put(s, forObject);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}