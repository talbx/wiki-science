package org.unihh.basecamp.g4.wiki.jobs.xml.contributors;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.*;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.io.IOException;
import java.util.logging.Logger;

public class ContributorCountJob implements WikiJob {
    private JobConf conf;

    private final Logger LOGGER = Logger.getLogger(ContributorCountJob.class.getName());

    public ContributorCountJob() {
        ConfGenerator confGenerator = new ConfGenerator();
        conf = confGenerator.generateTextIntConf("contributor-count", ContributorCountJob.class, ContributorCountMapper.class);
    }

    public void start(String input, String output) {
        try {
            FileInputFormat.setInputPaths(conf, new Path(input));
            FileOutputFormat.setOutputPath(conf, new Path(output));
            JobClient.runJob(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return conf.getJobName();
    }
}
