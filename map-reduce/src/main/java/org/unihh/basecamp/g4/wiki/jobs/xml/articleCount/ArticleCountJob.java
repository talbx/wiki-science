package org.unihh.basecamp.g4.wiki.jobs.xml.articleCount;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.*;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.io.IOException;
import java.util.logging.Logger;

public class ArticleCountJob implements WikiJob {
    private JobConf conf;

    private final Logger LOGGER = Logger.getLogger(ArticleCountJob.class.getName());

    public ArticleCountJob() {
        ConfGenerator generator = new ConfGenerator();
        conf = generator.generateTextIntConf("article-count", ArticleCountJob.class, ArticleCountMapper.class);
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