package org.unihh.basecamp.g4.wiki;

import org.unihh.basecamp.g4.wiki.jobs.WikiJob;
import org.unihh.basecamp.g4.wiki.jobs.contributors.ContributorCountJob;
import org.unihh.basecamp.g4.wiki.jobs.wordcount.WordCountJob;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.logging.Logger;

/**
 * returns the corresponding wikijob,
 * based on the provided argument
 */
public class JobFactory implements Function<String, WikiJob> {

    private final static Logger LOGGER = Logger.getLogger(JobFactory.class.getName());
    private final WikiJob wordCountJob;
    private final WikiJob contributorCountJob;
    private final List<WikiJob> jobs;

    public JobFactory() {
        this.wordCountJob = new WordCountJob();
        this.contributorCountJob = new ContributorCountJob();
        jobs = Arrays.asList(wordCountJob, contributorCountJob);
    }

    @Override
    public WikiJob apply(final String job) {
        return jobs.stream()
                .filter(wikiJob -> Objects.equals(job, wikiJob.getName()))
                .findAny()
                .orElse(null);
    }

    public static void printOptions() {
        LOGGER.info("arg missmatch, choose one pattern from below:");
        LOGGER.info("--word-count-job input output");
    }
}
