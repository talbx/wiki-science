package org.unihh.basecamp.g4.wiki.jobs.json.JSONArticleLength;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.io.IOException;

/**
 * Reads a list of json-formatted wiki articles
 * and counts the length of text for each article
 */
public class JSONArticleLengthJob implements WikiJob {

    private JobConf conf;

    public JSONArticleLengthJob() {
        ConfGenerator generator = new ConfGenerator();
        conf = generator.generateTextIntConf("article-length-json", JSONArticleLengthJob.class, JSONArticleLengthMapper.class);
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
