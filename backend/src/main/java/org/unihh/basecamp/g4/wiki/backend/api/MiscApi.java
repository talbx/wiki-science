package org.unihh.basecamp.g4.wiki.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.unihh.basecamp.g4.wiki.backend.CategoryEntity;
import org.unihh.basecamp.g4.wiki.backend.MockRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api/misc")
public class MiscApi {

    private final MockRepository mockRepository;

    @Autowired
    public MiscApi(final MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    @RequestMapping(path = "/topCategories", method = RequestMethod.GET)
    public List<CategoryEntity> getTopCategories() {
        return mockRepository.categoryCount();
    }
}
