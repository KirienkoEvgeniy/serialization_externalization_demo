package org.demo;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SaxParserAppl {
    public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        InputStream xmlInputStream = SaxParserAppl.class.getResourceAsStream("test.xml");
        SsxParsDemo handler = new SsxParsDemo();
        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlInputStream, handler);

        List<Worker> workers = handler.getWorList();
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }
}
