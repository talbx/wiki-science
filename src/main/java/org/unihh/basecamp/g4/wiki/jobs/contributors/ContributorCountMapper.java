package org.unihh.basecamp.g4.wiki.jobs.contributors;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.unihh.basecamp.g4.wiki.jobs.NodeBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class ContributorCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    private final IntWritable one = new IntWritable(1);
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
            if (currentNode.getNodeName().equals("ns0:ip") || currentNode.getNodeName().equals("ns0:username")) {
                word.set(currentNode.getTextContent());
                output.collect(word, one);
            } else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                processNode(currentNode, output);
            }
        }
    }
}

