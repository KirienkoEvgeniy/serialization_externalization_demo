package org.demo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SsxParsDemo extends DefaultHandler {

    private List<Worker> worList = null;
    private Worker worker = null;
    private StringBuilder data = null;
    boolean blogin = false;
    boolean bposition = false;

    public List<Worker> getWorList() {
        return worList;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }


    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("worker")) {
            worker = new Worker();
            if (worList == null)
                worList = new ArrayList();
        } else if (qName.equalsIgnoreCase("login")) {
            blogin = true;
        } else if (qName.equalsIgnoreCase("position")) {
            bposition = true;
        } else if (qName.equalsIgnoreCase("additionalInfo")) {
            String sinceYear = attributes.getValue("sinceYear");
            worker.setSinceYear(Integer.parseInt(sinceYear));
            String company = attributes.getValue("company");
            worker.setCompany(company);

        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (blogin) {
            worker.setLogin(data.toString());
            blogin = false;
        } else if (bposition) {
            worker.setPosition(data.toString());
            bposition = false;
        }
        if (qName.equalsIgnoreCase("worker")) {
            worList.add(worker);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

