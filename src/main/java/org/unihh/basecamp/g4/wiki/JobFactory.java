package org.unihh.basecamp.g4.wiki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.unihh.basecamp.g4.wiki.jobs.SampleJob;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.util.function.Function;
import java.util.logging.Logger;

/**
 * returns the corresponding wikijob,
 * based on the provided argument
 */
@Component
public class JobFactory implements Function<String, WikiJob> {

    private final static Logger LOGGER = Logger.getLogger(JobFactory.class.getName());
    private final WikiJob wordCountJob;
    private final WikiJob sampleJob;

    @Autowired
    public JobFactory(final WikiJob wordCountJob, WikiJob sampleJob) {
        this.wordCountJob = wordCountJob;
        this.sampleJob = sampleJob;
    }

    @Override
    public WikiJob apply(final String job) {
        LOGGER.info(this.sampleJob.toString());
        if ("--word-count-job".equals(job)) {
            return wordCountJob;
        } else {
            printOptions();
        }
        return null;
    }

    public static void printOptions() {
        LOGGER.info("arg missmatch, choose one pattern from below:");
        LOGGER.info("--word-count-job input output");
    }
}
