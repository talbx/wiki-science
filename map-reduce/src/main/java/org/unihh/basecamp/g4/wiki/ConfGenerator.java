package org.unihh.basecamp.g4.wiki;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.unihh.basecamp.g4.wiki.jobs.StandardReducer;
import org.unihh.basecamp.g4.wiki.jobs.TextReducer;

public class ConfGenerator {

    public <X extends Mapper> JobConf generateTextIntConf(String name, Class<?> job, Class<X> mapper) {
        JobConf conf = new JobConf(job);
        conf.setJobName(name);

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        conf.setMemoryForMapTask(64000L);
        conf.setMemoryForReduceTask(64000L);

        conf.setMapperClass(mapper);
        conf.setCombinerClass(StandardReducer.class);
        conf.setReducerClass(StandardReducer.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        conf.set("mapreduce.output.textoutputformat.separator", ";");
        return conf;
    }

    public <X extends Mapper>JobConf generateTextText(String name, Class<?> job, Class<X> mapper) {
        JobConf conf = new JobConf(job);
        conf.setJobName(name);

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);
        conf.setMemoryForMapTask(64000L);
        conf.setMemoryForReduceTask(64000L);

        conf.setMapperClass(mapper);
        conf.setCombinerClass(TextReducer.class);
        conf.setReducerClass(TextReducer.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        conf.set("mapreduce.output.textoutputformat.separator", ";");
        return conf;
    }

}
