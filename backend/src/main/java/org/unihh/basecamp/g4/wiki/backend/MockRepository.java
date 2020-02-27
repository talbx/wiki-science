package org.unihh.basecamp.g4.wiki.backend;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MockRepository {

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

    public List<ContributorEntity> premiumContributors() {
        return Arrays.asList(
                new ContributorEntity("Ugur", 121),
                new ContributorEntity("Tom", 89),
                new ContributorEntity("T.O", 50),
                new ContributorEntity("Alex", 21),
                new ContributorEntity("Thanos", 20));
    }

    public Long getTotalArticleCount() {
        return 2134L;
    }

    public List<ArticleEntity> getShortestArticles() {
        return Arrays.asList(
                new ArticleEntity("ABC", 17234),
                new ArticleEntity("Some Random Article", 1827312),
                new ArticleEntity("Deutschland", 99383));
    }

    public List<ArticleEntity> getLongestArticles() {
        return Arrays.asList(
                new ArticleEntity("Ni idea", 2),
                new ArticleEntity("short", 9),
                new ArticleEntity("Very short article wtf", 111));
    }

    public List<ArticleEditsEntity> getMostEditedArticles() {
        return Arrays.asList(
                new ArticleEditsEntity("Corona Virus", 51234),
                new ArticleEditsEntity("Why Donald Trump sucks", 12929),
                new ArticleEditsEntity("This is speculation", 92828));
    }
}
