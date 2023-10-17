package com.app.util;


import com.app.bcci.model.jaxb.books.BooksForm;
import com.app.bcci.model.jaxb.books.ObjectFactory;
import jakarta.xml.bind.*;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class XmlUtil {

    public static String objectToXmlString(BooksForm booksForm) {
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<BooksForm> books = objectFactory.createBooks(booksForm);

        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(books, stringWriter);

        return stringWriter.toString();
    }

    public static void xmlFileToObject(String fileName) {
//        String fileName = "books.xml";
        InputStream is = FileUtil.getFileFromResourceAsStream(fileName);
//        FileUtil.printInputStream(is);
//        BooksForm booksForm1 = JAXB.unmarshal(is, BooksForm.class);
//        System.out.println("booksForm1 = " + booksForm1);


    }

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

    public static void main(String[] args) {
//        String foo = objectToXmlString(new BooksForm());
        xmlFileToObject("books.xml");
    }


}