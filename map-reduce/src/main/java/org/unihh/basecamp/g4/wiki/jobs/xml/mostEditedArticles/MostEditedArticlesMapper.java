package org.unihh.basecamp.g4.wiki.jobs.xml.mostEditedArticles;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.unihh.basecamp.g4.wiki.jobs.Article;
import org.unihh.basecamp.g4.wiki.jobs.ImmutableArticle;
import org.unihh.basecamp.g4.wiki.jobs.NodeBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MostEditedArticlesMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    private Text article = new Text();

    Logger LOGGER = Logger.getLogger(MostEditedArticlesMapper.class.getName());

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        NodeBuilder nodeBuilder = new NodeBuilder();
        Node node = nodeBuilder.apply(value);
        processNode(node, output);
    }

    public void processNode(Node node, OutputCollector<Text, IntWritable> output) throws IOException {
        Optional<Node> optionalNode = Optional.ofNullable(node);
        if (optionalNode.isPresent()) {
            NodeList nodeList = optionalNode.get().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node currentNode = nodeList.item(i);
                if (currentNode.getNodeName().equals("ns0:page")) {
                    processRevision(currentNode, output);
                } else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                    processNode(currentNode, output);
                }
            }
        }
    }

    public void processRevision(Node node, OutputCollector<Text, IntWritable> output) throws IOException {
        ImmutableArticle.Builder articleBuilder = ImmutableArticle.builder();
        NodeList nodeList = node.getChildNodes();
        int sum = 0;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeName().equals("ns0:title")) {
                articleBuilder.title(currentNode.getTextContent());
            }
            if (currentNode.getNodeName().equals("ns0:revision")) {
                sum = sum + 1;
            }
        }
        Article art = articleBuilder.build();
        String title = art.getTitle();
        String string = title != null ? title : "no-title";
        article.set(string);
        LOGGER.log(Level.INFO, "Collecting article: {} with {} revisions", new Object[]{string, sum});
        output.collect(article, new IntWritable(sum));
    }
}

