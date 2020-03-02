package org.unihh.basecamp.g4.wiki.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.unihh.basecamp.g4.wiki.backend.ContributorEntity;
import org.unihh.basecamp.g4.wiki.backend.MockRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/contributors")
public class ContributorApi {

    private final MockRepository mockRepository;

    @Autowired
    public ContributorApi(final MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    @RequestMapping(path = "/contributors", method = RequestMethod.GET)
    public List<ContributorEntity> getPremiumContributors() {
        return mockRepository.premiumContributors();
    }

    @RequestMapping(path = "/contributorCount", method = RequestMethod.GET)
    public Long getContributorCount() {
        return mockRepository.contributorCount();
    }

    @RequestMapping(path = "/geolocation", method = RequestMethod.GET)
    public Map<String, GeoLocation> getGeolocation() {
        return mockRepository.geolocations();
    }

}
