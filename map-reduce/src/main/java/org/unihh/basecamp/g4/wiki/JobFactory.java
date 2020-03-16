package org.unihh.basecamp.g4.wiki;

import org.unihh.basecamp.g4.wiki.jobs.WikiJob;
import org.unihh.basecamp.g4.wiki.jobs.json.JSONArticleLength.JSONArticleLengthJob;
import org.unihh.basecamp.g4.wiki.jobs.json.JSONRealArticleCount.JSONRealArticleCountJob;
import org.unihh.basecamp.g4.wiki.jobs.json.JSONRedirects.JSONRedirectsJob;
import org.unihh.basecamp.g4.wiki.jobs.json.JSONTopics.JSONTopicsJob;
import org.unihh.basecamp.g4.wiki.jobs.json.JSONTotalArticleCount.JSONTotalArticleCountJob;
import org.unihh.basecamp.g4.wiki.jobs.json.JSONWordCount.JSONWordCountJob;
import org.unihh.basecamp.g4.wiki.jobs.misc.PlainArticleCountJob;
import org.unihh.basecamp.g4.wiki.jobs.xml.articleCount.ArticleCountJob;
import org.unihh.basecamp.g4.wiki.jobs.xml.articleLength.ArticleLengthJob;
import org.unihh.basecamp.g4.wiki.jobs.xml.categories.CategoryJob;
import org.unihh.basecamp.g4.wiki.jobs.xml.contributors.ContributorCountJob;
import org.unihh.basecamp.g4.wiki.jobs.xml.mostEditedArticles.MostEditedArticlesJob;
import org.unihh.basecamp.g4.wiki.jobs.xml.premiumContributors.PremiumContributorJob;
import org.unihh.basecamp.g4.wiki.jobs.xml.redirects.MostRedirectsJob;
import org.unihh.basecamp.g4.wiki.jobs.xml.wordcount.WordCountJob;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * returns the corresponding WikiJob,
 * based on the provided argument
 */
public class JobFactory implements Function<String, WikiJob> {

    private List<WikiJob> jobs;

    public JobFactory() {
        jobs = Arrays.asList(
                new WordCountJob(),
                new ContributorCountJob(),
                new MostRedirectsJob(),
                new ArticleLengthJob(),
                new ArticleCountJob(),
                new CategoryJob(),
                new JSONArticleLengthJob(),
                new JSONRedirectsJob(),
                new JSONRealArticleCountJob(),
                new JSONTopicsJob(),
                new JSONTotalArticleCountJob(),
                new JSONWordCountJob(),
                new PremiumContributorJob(),
                new PlainArticleCountJob(),
                new MostEditedArticlesJob());
    }

    @Override
    public WikiJob apply(final String job) {
        return jobs.stream()
                .filter(wikiJob -> Objects.equals(job, wikiJob.getName()))
                .findAny()
                .orElseThrow(illegalArgumentException);
    }

    private Supplier<IllegalArgumentException> illegalArgumentException = () -> {
        String collect = jobs.stream()
                .map(WikiJob::getName)
                .collect(Collectors.joining(", "));
        return new IllegalArgumentException("job could not be found. please choose one of: " + collect);
    };
}
