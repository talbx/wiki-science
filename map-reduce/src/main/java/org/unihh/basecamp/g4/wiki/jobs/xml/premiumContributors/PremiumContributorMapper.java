package org.unihh.basecamp.g4.wiki.jobs.xml.premiumContributors;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.unihh.basecamp.g4.wiki.ImmutableContributor;
import org.unihh.basecamp.g4.wiki.jobs.NodeBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.Optional;

public class PremiumContributorMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
    private Text word = new Text();

    public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        NodeBuilder nodeBuilder = new NodeBuilder();
        Node node = nodeBuilder.apply(value);
        processNode(node, output);
    }

    private void processNode(Node node, OutputCollector<Text, Text> output) throws IOException {
        Optional<Node> optionalNode = Optional.ofNullable(node);
        if (optionalNode.isPresent()) {
            NodeList nodeList = optionalNode.get().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node currentNode = nodeList.item(i);
                if (currentNode.getNodeName().equals("ns0:revision")) {
                    processRevision(currentNode, output);
                } else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                    processNode(currentNode, output);
                }
            }
        }
    }

    private void processRevision(Node node, OutputCollector<Text, Text> output) throws IOException {
        ImmutableContributor.Builder contributorBuilder = ImmutableContributor.builder();
        Optional<Node> optionalNode = Optional.ofNullable(node);
        if (optionalNode.isPresent()) {
            NodeList nodeList = optionalNode.get().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node currentNode = nodeList.item(i);
                if (currentNode.getNodeName().equals("ns0:timestamp")) {
                    contributorBuilder.timestamp(currentNode.getTextContent());
                }
                if (currentNode.getNodeName().equals("ns0:contributor")) {
                    for (int o = 0; o < currentNode.getChildNodes().getLength(); o++) {
                        Node item = currentNode.getChildNodes().item(o);
                        if (item.getNodeName().equals("ns0:username") || item.getNodeName().equals("ns0:ip")) {
                            if(item.getTextContent() != null){
                                contributorBuilder.username(item.getTextContent().toLowerCase());
                            }
                        }
                    }
                }
            }
        }
        ImmutableContributor contributor = contributorBuilder.build();
        word.set(contributor.getAccount());
        String timestamp = contributor.getTimestamp() != null ? contributor.getTimestamp() : "no-timestamp";
        output.collect(word, new Text(timestamp));
    }
}