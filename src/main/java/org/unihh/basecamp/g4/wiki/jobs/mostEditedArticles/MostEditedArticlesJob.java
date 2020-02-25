package org.unihh.basecamp.g4.wiki.jobs.mostEditedArticles;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.unihh.basecamp.g4.wiki.jobs.StandardReducer;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.io.IOException;
import java.util.logging.Logger;

public class MostEditedArticlesJob implements WikiJob {
    private JobConf conf;

    private final Logger LOGGER = Logger.getLogger(MostEditedArticlesJob.class.getName());

    public MostEditedArticlesJob() {
        conf = new JobConf(MostEditedArticlesJob.class);
        conf.setJobName("most-edited-articles");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setMapperClass(MostEditedArticlesMapper.class);
        conf.setCombinerClass(StandardReducer.class);
        conf.setReducerClass(StandardReducer.class);

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