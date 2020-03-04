package org.unihh.basecamp.g4.wiki.backend.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.unihh.basecamp.g4.wiki.backend.entity.LatestContributorsEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FindLocationForIp implements Function<List<LatestContributorsEntity>, Map<String, GeoLocation>> {

    private final RestTemplateBuilder templateBuilder;
    private Logger LOGGER = Logger.getLogger(FindLocationForIp.class.getName());

    @Autowired
    public FindLocationForIp(final RestTemplateBuilder templateBuilder) {
        this.templateBuilder = templateBuilder;
    }

    @Override
    public Map<String, GeoLocation> apply(final List<LatestContributorsEntity> strings) {
        Map<String, GeoLocation> obj = new HashMap<>();
        for (LatestContributorsEntity e : strings) {
            try {
                LOGGER.log(Level.INFO, "fetching geolocation for " + e.getUsername());
                GeoLocation geoLocation = templateBuilder.build()
                        .getForObject(new URI("https://api.ipgeolocationapi.com/geolocate/" + e.getUsername()), GeoLocation.class);
                obj.put(e.getUsername(), geoLocation);
            } catch (URISyntaxException | HttpServerErrorException ex) {
                LOGGER.log(Level.WARNING, "no location found for " + e, ex);
            }
        }
        return obj;
    }
}