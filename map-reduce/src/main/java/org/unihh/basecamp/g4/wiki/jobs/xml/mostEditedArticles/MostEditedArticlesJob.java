package org.unihh.basecamp.g4.wiki.jobs.xml.mostEditedArticles;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.*;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.io.IOException;
import java.util.logging.Logger;

public class MostEditedArticlesJob implements WikiJob {
    private JobConf conf;

    private final Logger LOGGER = Logger.getLogger(MostEditedArticlesJob.class.getName());

    public MostEditedArticlesJob() {
        ConfGenerator confGenerator = new ConfGenerator();
        conf = confGenerator.generateTextIntConf("most-edited-articles", MostEditedArticlesJob.class, MostEditedArticlesMapper.class);
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