package org.unihh.basecamp.g4.wiki.jobs.articleLength;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.StandardReducer;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.io.IOException;
import java.util.logging.Logger;

public class ArticleLengthJob implements WikiJob {
    private JobConf conf;

    private final Logger LOGGER = Logger.getLogger(ArticleLengthJob.class.getName());

    public ArticleLengthJob() {
        ConfGenerator confGenerator = new ConfGenerator();
        conf = confGenerator.generateTextIntConf("article-length", ArticleLengthJob.class, ArticleLengthMapper.class);
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