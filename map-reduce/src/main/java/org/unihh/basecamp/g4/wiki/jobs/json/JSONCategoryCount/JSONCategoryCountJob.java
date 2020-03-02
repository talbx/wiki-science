package org.unihh.basecamp.g4.wiki.jobs.json.JSONCategoryCount;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.io.IOException;

public class JSONCategoryCountJob implements WikiJob {

    private JobConf conf;

    public JSONCategoryCountJob() {
        ConfGenerator generator = new ConfGenerator();
        conf = generator.generateTextIntConf("category-count-json", JSONCategoryCountJob.class, JSONCategoryCountMapper.class);
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
