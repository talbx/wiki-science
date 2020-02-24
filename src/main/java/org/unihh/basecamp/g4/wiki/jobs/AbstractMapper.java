package org.unihh.basecamp.g4.wiki.jobs;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.List;

public abstract class AbstractMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    public void map(List<String> params, LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        XmlMatcher matcher = new XmlMatcher(key, value, output, reporter);
        matcher.apply(params);
    }
}
