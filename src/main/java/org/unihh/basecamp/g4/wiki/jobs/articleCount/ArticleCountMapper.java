package org.unihh.basecamp.g4.wiki.jobs.articleCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.unihh.basecamp.g4.wiki.jobs.NodeBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.Optional;

public class ArticleCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    private Text article = new Text();

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        NodeBuilder nodeBuilder = new NodeBuilder();
        Node node = nodeBuilder.apply(value);
        processNode(node, output);
    }

    private void processNode(Node node, OutputCollector<Text, IntWritable> output) throws IOException {
        Optional<Node> optionalNode = Optional.ofNullable(node);
        if (optionalNode.isPresent()) {
            NodeList nodeList = optionalNode.get().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node currentNode = nodeList.item(i);
                if (currentNode.getNodeName().equals("ns0:page")) {
                    output.collect(new Text("articles"), new IntWritable(1));
                }
            }
        }
    }
}

