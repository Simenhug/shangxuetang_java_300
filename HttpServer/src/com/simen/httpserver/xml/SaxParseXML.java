package com.simen.httpserver.xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxParseXML {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.从解析工厂获取解析器
		SAXParser parser = factory.newSAXParser();
		//3.加载文档Document 注册处理器
		PersonHandler ph = new PersonHandler();
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/simen/httpserver/xml/person.xml"), ph);
		List<Person> persons = ph.getPersons();
		for(Person person:persons) {
			System.out.println("name: "+person.getName()+ " age: "+person.getAge());
		}
	}

}
