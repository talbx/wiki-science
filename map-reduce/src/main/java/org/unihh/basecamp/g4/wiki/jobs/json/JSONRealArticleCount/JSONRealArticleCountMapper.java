package org.unihh.basecamp.g4.wiki.jobs.json.JSONRealArticleCount;

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

public class JSONRealArticleCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        Gson gson = new Gson();
        WikiArticle wikiArticle = gson.fromJson(value.toString(), WikiArticle.class);
        if (!(wikiArticle.getText().contains("may refer to:") && wikiArticle.getText().length() < 100)) {
            output.collect(new Text("realArticles"), new IntWritable(1));
        }
    }
}
