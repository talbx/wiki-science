package org.unihh.basecamp.g4.wiki.jobs;

import org.apache.hadoop.io.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.function.Function;

/**
 * Transforms a hadoop Text to a XML Node document
 */
public class NodeBuilder implements Function<Text, Node> {

    @Override
    public Node apply(final Text text) {
        String line = text.toString();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(line)));
            return doc.getDocumentElement();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}