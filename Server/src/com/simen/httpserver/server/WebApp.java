package com.simen.httpserver.server;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.simen.httpserver.servlet.Servlet;

public class WebApp {
	private static ServletMapping context;
	
	static {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		WebHandler web = new WebHandler();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("com/simen/httpserver/WEB_INFO/web.xml"), web);
			List<NameToServlet> nameMap = web.getNameMap();
			List<UrlPattern> urlMap = web.getUrlMap();
			
			context = new ServletMapping();
			Map<String,String> servlets = context.getServlets();
			Map<String,String> mapping = context.getMapping();
			for(UrlPattern up: urlMap) {
				List<String> urls = up.getUrls();
				for(String url: urls) {
					mapping.put(url, up.getName());
				}
			}
			for(NameToServlet nts: nameMap) {
				servlets.put(nts.getName(), nts.getClassPath());
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(url==null||url.trim()=="") {
			return null;
		}
		String function = context.getMapping().get(url);
		String className = context.getServlets().get(function);
		//动态创建对象
		return (Servlet) Class.forName(className).newInstance();
	}

}
