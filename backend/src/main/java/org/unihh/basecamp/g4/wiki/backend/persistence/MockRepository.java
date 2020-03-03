package org.unihh.basecamp.g4.wiki.backend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.unihh.basecamp.g4.wiki.backend.entity.ArticleEditsEntity;
import org.unihh.basecamp.g4.wiki.backend.entity.ArticleEntity;
import org.unihh.basecamp.g4.wiki.backend.entity.CategoryEntity;
import org.unihh.basecamp.g4.wiki.backend.functions.FindLocationForIp;
import org.unihh.basecamp.g4.wiki.backend.functions.GeoLocation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class MockRepository {

    @Autowired
    FindLocationForIp geoFetch;

    public List<CategoryEntity> categoryCount() {

        return Arrays.asList(
                new CategoryEntity("Fussball", 121),
                new CategoryEntity("Prominente in Deutschland", 89),
                new CategoryEntity("Essen", 50),
                new CategoryEntity("Kriege", 21),
                new CategoryEntity("US-Präsidenten", 20),
                new CategoryEntity("Zahnarzt", 1));
    }

    public Long contributorCount() {
        return 222L;
    }

    public Long getTotalArticleCount() {
        return 2134L;
    }

    public List<ArticleEntity> getShortestArticles() {
        return Arrays.asList(
                new ArticleEntity("ABC", 203),
                new ArticleEntity("Some Random Article", 15),
                new ArticleEntity("Deutschland", 6));
    }

    public List<ArticleEntity> getLongestArticles() {
        return Arrays.asList(
                new ArticleEntity("The History of Germany", 21231232),
                new ArticleEntity("Kim Jong-Un", 9123334),
                new ArticleEntity("Penis", 112221));
    }

    public List<ArticleEditsEntity> getMostEditedArticles() {
        return Arrays.asList(
                new ArticleEditsEntity("Corona Virus", 51234),
                new ArticleEditsEntity("Why Donald Trump sucks", 12929),
                new ArticleEditsEntity("This is speculation", 92828));
    }
}
