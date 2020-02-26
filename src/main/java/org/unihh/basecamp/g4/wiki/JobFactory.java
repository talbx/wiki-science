package org.unihh.basecamp.g4.wiki;

import org.unihh.basecamp.g4.wiki.jobs.WikiJob;
import org.unihh.basecamp.g4.wiki.jobs.articleCount.ArticleCountJob;
import org.unihh.basecamp.g4.wiki.jobs.articleLength.ArticleLengthJob;
import org.unihh.basecamp.g4.wiki.jobs.categories.CategoryJob;
import org.unihh.basecamp.g4.wiki.jobs.contributors.ContributorCountJob;
import org.unihh.basecamp.g4.wiki.jobs.mostEditedArticles.MostEditedArticlesJob;
import org.unihh.basecamp.g4.wiki.jobs.premiumContributors.PremiumContributorJob;
import org.unihh.basecamp.g4.wiki.jobs.wordcount.WordCountJob;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * returns the corresponding wikijob,
 * based on the provided argument
 */
public class JobFactory implements Function<String, WikiJob> {

    private final static Logger LOGGER = Logger.getLogger(JobFactory.class.getName());
    private List<WikiJob> jobs;

    public JobFactory() {
        jobs = Arrays.asList(new WordCountJob(), new ContributorCountJob(), new ArticleLengthJob(), new ArticleCountJob(), new CategoryJob(), new PremiumContributorJob(), new MostEditedArticlesJob());
    }

    @Override
    public WikiJob apply(final String job) {
        return jobs.stream()
                .filter(wikiJob -> Objects.equals(job, wikiJob.getName()))
                .findAny()
                .orElseThrow(illegalArgumentException);
    }

    private Supplier<IllegalArgumentException> illegalArgumentException = () -> {
        String collect = jobs.stream().map(WikiJob::getName).collect(Collectors.joining(", "));
        return new IllegalArgumentException("job could not be found. please choose one of: " + collect);
    };
}
