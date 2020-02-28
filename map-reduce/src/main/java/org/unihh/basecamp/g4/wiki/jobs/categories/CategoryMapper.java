package org.unihh.basecamp.g4.wiki.jobs.categories;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CategoryMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
      //  value = value.substring(value.findFirst("<tag>"), value.findLast("</tag>);
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
                if (currentNode.getNodeName().equals("ns0:text")) {
                    String textContent = currentNode.getTextContent();
                    Pattern pattern = Pattern.compile("\\[\\[(Category:.+?)\\]\\]");
                    Matcher matcher = pattern.matcher(textContent);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        String[] split = group.split(":");
                        output.collect(new Text(split[1]), new IntWritable(1));
                    }
                } else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                    processNode(currentNode, output);
                }
            }
        }
    }
}
