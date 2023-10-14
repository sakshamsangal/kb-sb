package com.app.velocity.velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.*;

public class HtmlGuideWriter {
	static String className = "Work";
	static String outputFile = "src/main/java/"+className + ".java";
	static String message = "Hello World!";
	public static void main(String[] args) throws IOException {
		Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		Velocity.init();

		VelocityContext context = new VelocityContext();
		context.put("className", className);
		context.put("message", message);

		Writer writer = new FileWriter(outputFile);
		Velocity.mergeTemplate("java_example.vm", "UTF-8", context, writer);

		writer.flush();
		writer.close();
	}
}