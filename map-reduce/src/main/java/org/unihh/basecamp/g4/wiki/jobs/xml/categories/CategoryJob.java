package org.unihh.basecamp.g4.wiki.jobs.xml.categories;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Reads a list of xml-based wiki articles
 * and performs a word-count for each category
 */
public class CategoryJob implements WikiJob {
    private JobConf conf;

    private final Logger LOGGER = Logger.getLogger(CategoryJob.class.getName());

    public CategoryJob() {
        ConfGenerator confGenerator = new ConfGenerator();
        conf = confGenerator.generateTextIntConf("category", CategoryJob.class, CategoryMapper.class);
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
