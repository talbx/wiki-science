package org.unihh.basecamp.g4.wiki.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unihh.basecamp.g4.wiki.backend.entity.FunFactsEntity;
import org.unihh.basecamp.g4.wiki.backend.persistence.FunFactsRepository;

import javax.transaction.Transactional;

@CrossOrigin(origins = {"http://localhost:50361", "http://localhost:8080", "https://uguri.github.io/wikiScience/#/"})
@RestController
@Transactional
@RequestMapping(path = "/api/articles")
public class ArticleApi {

    private final FunFactsRepository funFactsRepository;

    @Autowired
    public ArticleApi(final FunFactsRepository funFactsRepository) {
        this.funFactsRepository = funFactsRepository;
    }

    @RequestMapping(path = "/get/{title}", method = RequestMethod.GET)
    public FunFactsEntity getRedirects(@PathVariable("title") String title) {
        return funFactsRepository.findByTitle(title);
    }

    @RequestMapping(path = "/redirects", method = RequestMethod.GET)
    public FunFactsEntity getRedirects() {
        return funFactsRepository.findByTitle("redirects");
    }

    @RequestMapping(path = "/wordCount", method = RequestMethod.GET)
    public FunFactsEntity getTotalWordCount() {
        return funFactsRepository.findByTitle("word-count");
    }

    @RequestMapping(path = "/totalArticleCount", method = RequestMethod.GET)
    public FunFactsEntity getTotalArticleCount() {
        return funFactsRepository.findByTitle("total-article-count");
    }

    @RequestMapping(path = "/realArticleCount", method = RequestMethod.GET)
    public FunFactsEntity getRealArticleCount() {
        return funFactsRepository.findByTitle("real-article-count");
    }
}
