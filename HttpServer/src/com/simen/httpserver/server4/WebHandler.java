package com.simen.httpserver.server4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WebHandler extends DefaultHandler{
	private List<NameToServlet> nameMap;
	private List<UrlPattern> urlMap;
	private NameToServlet nts;
	private UrlPattern up;
	private boolean isMapping = false;
	private String tag;

	public List<NameToServlet> getNameMap() {
		return nameMap;
	}

	public void setNameMap(List<NameToServlet> nameMap) {
		this.nameMap = nameMap;
	}

	public List<UrlPattern> getUrlMap() {
		return urlMap;
	}

	public void setUrlMap(List<UrlPattern> urlMap) {
		this.urlMap = urlMap;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		this.nameMap = new ArrayList<NameToServlet>();
		this.urlMap = new ArrayList<UrlPattern>();
		this.tag = "";
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if(qName!=null||qName.trim()!="") {
			tag = qName;
			if(tag.equals("servlet-mapping")) {
				isMapping = true;
				up = new UrlPattern();
			} else if (tag.equals("servlet")) {
				nts = new NameToServlet();
				isMapping = false;
			}
		}
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String data = new String(ch, start, length);
		// block is for servlet-name mapping
		if (tag != null) {
			if (!isMapping && nts != null) {
				if (tag == "servlet-name") {
					nts.setName(data);
				} else if (tag == "servlet-class") {
					nts.setClassPath(data);
				}
			} else if (isMapping && up != null) {
				if (tag == "servlet-name") {
					up.setName(data);
				} else if (tag == "url-pattern") {
					up.getUrls().add(data);
				}
			}
		}
		super.characters(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if(qName!=null||qName.trim()!="") {
			if(qName.equals("servlet-mapping")) {
				isMapping = false;
				urlMap.add(up);
				up = null;
			} else if (qName=="servlet") {
				nameMap.add(nts);
				nts = null;
			}
		}
		tag = null;
		super.endElement(uri, localName, qName);
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
	
}
