package org.unihh.basecamp.g4.wiki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
public class JobExecutor implements Consumer<Arguments> {

    private final static Logger LOGGER = Logger.getLogger(JobExecutor.class.getName());
    private final JobFactory jobFactory;

    @Autowired
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
        var job = Optional.ofNullable(jobFactory.apply(args.getJob()));
        job.ifPresentOrElse(j -> runJob.accept(j, args), () -> LOGGER.log(Level.INFO, "No job found with name {0}", args.getJob()));
    }

}
