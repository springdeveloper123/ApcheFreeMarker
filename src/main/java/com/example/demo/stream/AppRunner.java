package com.example.demo.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class AppRunner implements CommandLineRunner{

	@Autowired
	private Configuration markerConfig;
	@Override
	public void run(String... args) throws Exception {
		fileBasedMarker();
		stringBasedMarker();
		fileBasedMarker1();
	}
	private void stringBasedMarker() throws TemplateException, IOException {
		String htmlftl = "<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<body>\r\n" + 
				"    <h2>Hello ${name}!</h2>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		StringReader reader = new StringReader(htmlftl);
		Template template = new Template("hello", reader, markerConfig);
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("name", "World");
		StringWriter writer = new StringWriter();
		template.process(dataMap, writer);
		System.out.println("output :: "+ writer.toString() );
	}
	private void fileBasedMarker() throws IOException, TemplateException {
		FileReader reader = new FileReader(new File("C:\\Apps\\hello.ftl"));
		Template template = new Template("hello", reader, markerConfig);
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("name", "World");
		template.process(dataMap, new FileWriter(new File("C:\\Apps\\test.html")));
	}

	private void fileBasedMarker1() throws IOException, TemplateException {
		FileReader reader = new FileReader(new File("C:\\Apps\\vegetables.ftl"));
		Template template = new Template("hello", reader, markerConfig);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("title", "Vegetables");
		List<Map<String,Object>> vegList = new ArrayList<>();
		Map<String, Object> vegMap = new HashMap<>();
		vegMap.put("name", "tomoto");
		vegMap.put("price", 25);
		vegList.add(vegMap);
		vegMap = new HashMap<>();
		vegMap.put("name", "potato");
		vegMap.put("price", 50);
		vegList.add(vegMap);
		vegMap = new HashMap<>();
		vegMap.put("name", "drumstick");
		vegMap.put("price", null);
		vegList.add(vegMap);
		dataMap.put("vals", vegList);
		template.process(dataMap, new FileWriter(new File("C:\\Apps\\vegetable.html")));
	}
}
