package org.unihh.basecamp.g4.wiki.jobs.json.JSONCategoryCount;

import io.vavr.control.Try;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONCategoryCountJob implements WikiJob {

    private Logger LOGGER = Logger.getLogger(JSONCategoryCountJob.class.getName());
    private JobConf conf;


    public JSONCategoryCountJob() {
        ConfGenerator generator = new ConfGenerator();
        conf = generator.generateTextIntConf("category-count-json", JSONCategoryCountJob.class, JSONCategoryCountMapper.class);
    }

    public void start(String input, String output) {
            FileInputFormat.setInputPaths(conf, new Path(input));
            FileOutputFormat.setOutputPath(conf, new Path(output));
            Try.of(() -> JobClient.runJob(conf))
                    .onSuccess(ignore -> LOGGER.log(Level.INFO, "job started!"))
                    .onFailure(err -> LOGGER.log(Level.WARNING, "job could not be started"));
    }

    @Override
    public String getName() {
        return conf.getJobName();
    }
}
