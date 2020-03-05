package org.unihh.basecamp.g4.wiki.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.unihh.basecamp.g4.wiki.backend.entity.RedirectsEntity;
import org.unihh.basecamp.g4.wiki.backend.persistence.RedirectsRepository;

import javax.transaction.Transactional;

@CrossOrigin(origins = {"http://localhost:50361","http://localhost:8080", "https://uguri.github.io/wikiScience/"})
@RestController
@Transactional
@RequestMapping(path = "/api/articles")
public class ArticleApi {

    private final RedirectsRepository redirectsRepository;

    @Autowired
    public ArticleApi(final RedirectsRepository redirectsRepository) {
        this.redirectsRepository = redirectsRepository;
    }

    @RequestMapping(path = "/redirects", method = RequestMethod.GET)
    public RedirectsEntity getRedirects() {
        return redirectsRepository.findAll().get(0);
    }
}
