package org.unihh.basecamp.g4.wiki.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.unihh.basecamp.g4.wiki.backend.persistence.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping(path = "/api/articles")
public class ArticleApi {

    private final MockRepository mockRepository;

    private final RedirectsRepository redirectsRepository;

    @Autowired
    public ArticleApi(final MockRepository mockRepository, final RedirectsRepository redirectsRepository) {
        this.mockRepository = mockRepository;
        this.redirectsRepository = redirectsRepository;
    }

    @RequestMapping(path = "/longest", method = RequestMethod.GET)
    public List<ArticleEntity> getLongestArticles() {
        return mockRepository.getLongestArticles();
    }

    @RequestMapping(path = "/shortest", method = RequestMethod.GET)
    public List<ArticleEntity> getShortestArticles() {
        return mockRepository.getShortestArticles();
    }

    @RequestMapping(path = "/totalCount", method = RequestMethod.GET)
    public Long getTotalArticleCount() {
        return mockRepository.getTotalArticleCount();
    }

    @RequestMapping(path = "/mostEdited", method = RequestMethod.GET)
    public List<ArticleEditsEntity> getMostEditedArticles() {
        return mockRepository.getMostEditedArticles();
    }

    @RequestMapping(path = "/redirects", method = RequestMethod.GET)
    public RedirectsEntity getRedirects() {
        return redirectsRepository.findAll().get(0);
    }
}
