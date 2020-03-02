package org.unihh.basecamp.g4.wiki.jobs.json.JSONArticleLength;

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


public class JSONArticleLengthMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        Gson gson = new Gson();
        WikiArticle wikiArticle = gson.fromJson(value.toString(), WikiArticle.class);
        output.collect(new Text(wikiArticle.getTitle()), new IntWritable(wikiArticle.getText().length()));
    }
}
