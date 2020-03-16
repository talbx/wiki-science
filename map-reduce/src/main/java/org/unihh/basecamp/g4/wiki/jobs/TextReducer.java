package org.unihh.basecamp.g4.wiki.jobs;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

/**
 * The StandardReducer but does map Text -> Text.
 */
public class TextReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        String val = "";
        while (values.hasNext()) {
            val = values.next().toString();
        }
        output.collect(key, new Text(val));
    }
}
