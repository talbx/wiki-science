package org.unihh.basecamp.g4.wiki.jobs.json.JSONRealArticleCount;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;
import org.unihh.basecamp.g4.wiki.jobs.json.JSONTopics.JSONTopicsJob;
import org.unihh.basecamp.g4.wiki.jobs.json.JSONTopics.JSONTopicsMapper;

import java.io.IOException;

public class JSONRealArticleCountJob implements WikiJob {

    private JobConf conf;

    public JSONRealArticleCountJob() {
        ConfGenerator generator = new ConfGenerator();
        conf = generator.generateTextIntConf("real-article-count-json", JSONRealArticleCountJob.class, JSONRealArticleCountMapper.class);
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
