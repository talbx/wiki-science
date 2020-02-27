package org.unihh.basecamp.g4.wiki.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class Api {

    private final MockRepository mockRepository;

    @Autowired
    public Api(final MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    @RequestMapping(path = "/cats", method = RequestMethod.GET)
    public List<CategoryEntity> getTopCategories() {
        return mockRepository.findTop50OrOrderByAmount();
    }
}
