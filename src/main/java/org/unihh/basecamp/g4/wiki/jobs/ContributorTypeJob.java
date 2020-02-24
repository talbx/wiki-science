package org.unihh.basecamp.g4.wiki.jobs;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.unihh.basecamp.g4.wiki.jobs.contributors.ContributorCountJob;
import org.unihh.basecamp.g4.wiki.jobs.contributors.ContributorCountMapper;
import org.unihh.basecamp.g4.wiki.jobs.contributors.ContributorTypeMapper;

import java.io.IOException;

public class ContributorTypeJob  implements WikiJob {
    private JobConf conf;

    public ContributorTypeJob() {
        conf = new JobConf(ContributorTypeJob.class);
        conf.setJobName("ContributorTypeJob");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setMapperClass(ContributorTypeMapper.class);
        conf.setCombinerClass(StandardReducer.class);
        conf.setReducerClass(StandardReducer.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
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
}
