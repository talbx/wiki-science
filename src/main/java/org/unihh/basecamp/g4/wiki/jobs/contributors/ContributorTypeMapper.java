package org.unihh.basecamp.g4.wiki.jobs.contributors;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
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

public class ContributorTypeMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    private final IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        String line = value.toString();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            Document doc = dBuilder.parse(new InputSource(new StringReader(line)));
            Node node =  doc.getDocumentElement();

            processNode(node, output);

        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    private void processNode(Node node,OutputCollector<Text, IntWritable>  output) throws IOException {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeName() == "ns0:ip" || currentNode.getNodeName() == "ns0:username") {
                word.set(currentNode.getNodeName());
                output.collect(word, one);
            } else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                processNode(currentNode, output);
            }
        }
    }
}
