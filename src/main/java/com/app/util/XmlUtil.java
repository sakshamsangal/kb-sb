package com.app.util;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlUtil {

    static void validateXmlFileAgainstXsd(String xsdPath, String xmlFilePath) throws IOException, SAXException {
        XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(xsdPath);
        Schema schema = factory.newSchema(schemaFile);

        Validator validator = schema.newValidator();
        validator.setErrorHandler(xmlErrorHandler);
        validator.validate(new StreamSource(xmlFilePath));

        List<String> msg = new ArrayList<>();

        xmlErrorHandler.getExceptions().forEach(e -> {
            msg.add(e.getMessage());
        });

        if (!msg.isEmpty()) {
            throw new RuntimeException();
        }
    }

    static void validateXmlStringAgainstXsd(String xsdPath, String xmlString) throws IOException, SAXException {
        XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(xsdPath);
        Schema schema = factory.newSchema(schemaFile);

        Validator validator = schema.newValidator();
        validator.setErrorHandler(xmlErrorHandler);
        validator.validate(new StreamSource(new StringReader(xmlString)));

        List<String> msg = new ArrayList<>();

        xmlErrorHandler.getExceptions().forEach(e -> {
            msg.add(e.getMessage());
        });

        if (!msg.isEmpty()) {
            throw new RuntimeException();
        }
    }


}