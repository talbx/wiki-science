package org.unihh.basecamp.g4.wiki.jobs.json.JSONWordCount;

import com.google.gson.Gson;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.unihh.basecamp.g4.wiki.jobs.xml.categories.WikiArticle;

import java.io.IOException;
import java.util.StringTokenizer;

public class JSONWordCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    private final IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        Gson gson = new Gson();
        WikiArticle wikiArticle = gson.fromJson(value.toString(), WikiArticle.class);
        StringTokenizer tokenizer = new StringTokenizer(wikiArticle.getText());
        while (tokenizer.hasMoreTokens()) {
            word.set(tokenizer.nextToken());
            output.collect(word, one);
        }
    }
}
