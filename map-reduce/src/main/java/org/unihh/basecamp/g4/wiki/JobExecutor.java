package org.unihh.basecamp.g4.wiki;

import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Receives Program Arguments and
 * starts the desired job with the attached
 * input / output dirs.
 */
public class JobExecutor implements Consumer<Arguments> {

    private final static Logger LOGGER = Logger.getLogger(JobExecutor.class.getName());
    private final JobFactory jobFactory;

    public JobExecutor(final JobFactory jobFactory) {
        this.jobFactory = jobFactory;
    }

    private BiConsumer<WikiJob, Arguments> runJob = (job, args) -> {
        LOGGER.log(Level.INFO, "Running {0} with input {1} and output {2}", new Object[]{args.getJob(), args.getInput(), args.getOutput()});
        job.start(args.getInput(), args.getOutput());
    };

    @Override
    public void accept(final Arguments args) {
        LOGGER.log(Level.INFO, "Looking for {0} to execute", args.getJob());
        Optional<WikiJob> job = Optional.ofNullable(jobFactory.apply(args.getJob()));
        job.ifPresent(j -> runJob.accept(j, args));
    }
}
