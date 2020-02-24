package org.unihh.basecamp.g4.wiki.jobs;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
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
import java.util.List;
import java.util.Objects;

public class XmlMatcher {

    private final IntWritable one = new IntWritable(1);
    private final LongWritable key;
    private final Text value;
    private final OutputCollector<Text, IntWritable> output;
    private final Reporter reporter;
    private Text word = new Text();

    public XmlMatcher(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter){
        this.key = key;
        this.value = value;
        this.output = output;
        this.reporter = reporter;
    }

    public void apply(List<String> args) throws IOException {
        String line = value.toString();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            Document doc = Objects.requireNonNull(dBuilder).parse(new InputSource(new StringReader(line)));
            Node node = doc.getDocumentElement();
            processNode(args, node);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private void processNode(List<String> args, Node node) throws IOException {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (args.contains(currentNode.getNodeName())) {
                String textContent = currentNode.getTextContent();
                textContent = textContent.replaceAll("[^a-zA-Z0-9]", "");
                word.set(textContent);
                output.collect(word, one);
            } else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                processNode(args, currentNode);
            }
        }
    }
}
