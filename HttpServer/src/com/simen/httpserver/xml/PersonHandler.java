package com.simen.httpserver.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersonHandler extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	private String tag; //记录当前tag
	
	public List<Person> getPersons(){
		return persons;
	}
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		persons = new ArrayList<Person>();
		System.out.println("xml file processing start");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("xml file processing finished");
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("element "+qName+" processing start");
		if(qName!=null) {
			tag = qName;
			if(qName.equals("person")) {
				person = new Person();
			}
		}
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if(qName=="person") {
			persons.add(person);
		}
		tag=null;
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String str = new String(ch, start, length);
		if(tag=="name") {
			person.setName(str);
		} else if(tag=="age") {
			person.setAge(Integer.valueOf(str));
		}
		System.out.println(new String(ch, start, length));
		super.characters(ch, start, length);
	}

	
}
