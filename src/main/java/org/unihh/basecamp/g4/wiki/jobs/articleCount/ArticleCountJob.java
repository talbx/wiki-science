package org.unihh.basecamp.g4.wiki.jobs.articleCount;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.unihh.basecamp.g4.wiki.jobs.StandardReducer;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;
import org.unihh.basecamp.g4.wiki.jobs.articleLength.ArticleLengthMapper;

import java.io.IOException;
import java.util.logging.Logger;

public class ArticleCountJob implements WikiJob {
    private JobConf conf;

    private final Logger LOGGER = Logger.getLogger(ArticleCountJob.class.getName());

    public ArticleCountJob() {
        conf = new JobConf(ArticleCountJob.class);
        conf.setJobName("article-count");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setMapperClass(ArticleLengthMapper.class);
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