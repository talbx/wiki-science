package org.unihh.basecamp.g4.wiki.jobs.premiumContributors;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.unihh.basecamp.g4.wiki.jobs.StandardReducer;
import org.unihh.basecamp.g4.wiki.jobs.TextReducer;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;
import org.unihh.basecamp.g4.wiki.jobs.contributors.ContributorCountJob;

import java.io.IOException;
import java.util.logging.Logger;

public class PremiumContributorJob implements WikiJob {
    private JobConf conf;

    private final Logger LOGGER = Logger.getLogger(ContributorCountJob.class.getName());

    public PremiumContributorJob() {
        conf = new JobConf(PremiumContributorJob.class);
        conf.setJobName("premium-contributor");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        conf.setMapperClass(PremiumContributorMapper.class);
        conf.setCombinerClass(TextReducer.class);
        conf.setReducerClass(TextReducer.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        conf.set("mapreduce.output.textoutputformat.separator", ";");
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