package org.unihh.basecamp.g4.wiki.jobs.json.JSONCategoryCount;

import io.vavr.control.Try;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseJob {

    private Logger LOGGER = Logger.getLogger(BaseJob.class.getName());
    protected JobConf conf;

    protected void start(String input, String output){
        FileInputFormat.setInputPaths(conf, new Path(input));
        FileOutputFormat.setOutputPath(conf, new Path(output));
        Try.of(() -> JobClient.runJob(conf))
                .onSuccess(ignore -> LOGGER.log(Level.INFO, "job {} started!", new Object[]{conf.getJobName()}))
                .onFailure(err -> LOGGER.log(Level.WARNING, "job {} could not be started",  new Object[]{conf.getJobName()}));
    }
}
