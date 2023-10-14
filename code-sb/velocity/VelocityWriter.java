package com.app.velocity.velocity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;


public class VelocityWriter {
 
    static String modelName = "User";
    static String packageName = "com.app";
    static String outputFile = "src/main/java/com/app/"+modelName + ".java";
    static String outputFile2 = "src/main/java/com/app/"+modelName + "2.java";

 
    public static void main(String[] args) throws IOException {
        Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
      

        VelocityContext context = new VelocityContext();

        if(packageName != null) {
            context.put("packagename", packageName);
        }
  
        List<Field> properties = new ArrayList<>();
        properties.add(new Field("id", "int"));
        properties.add(new Field("firstName", "String"));
        properties.add(new Field("lastName", "String"));
        properties.add(new Field("dob", "LocalDate"));
        context.put("className", modelName);
        context.put("properties", properties);

        Writer writer = new FileWriter(outputFile);
        Velocity.mergeTemplate("class.vm", "UTF-8", context, writer);

        writer.flush();
        writer.close();

        //
        // Student=i=id,s=fn,s=ln, loo=Address
        // json
//        loc



    }
}
