package org.unihh.basecamp.g4.wiki.jobs.articles;

import org.apache.commons.lang3.StringUtils;
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

public class ArticleLengthMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    private Text word = new Text();

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        NodeBuilder nodeBuilder = new NodeBuilder();
        Node node = nodeBuilder.apply(value);
        processNode(node, output);
    }

    private void processNode(Node node, OutputCollector<Text, IntWritable> output) throws IOException {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeName().equals("ns0:text")) {
                String substringBefore = StringUtils.substringBefore(currentNode.getTextContent(), "==References==");
                String clean = substringBefore.replaceAll("[^.,a-zA-Z ]", " ");
                word.set(clean);
                output.collect(word, new IntWritable(clean.length()));
            } else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                processNode(currentNode, output);
            }
        }
    }
}

