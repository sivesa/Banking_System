package com.hexsoftwares.banking_system.terminal_api;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLUtil {

    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            // Load and parse the XML file
            File xmlFile = new File("src/main/resources/database-config.xml"); // Adjust path if necessary
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Normalize XML structure
            doc.getDocumentElement().normalize();

            // Get the root element
            Element root = doc.getDocumentElement();

            // Retrieve values from the XML file
            url = root.getElementsByTagName("url").item(0).getTextContent();
            username = root.getElementsByTagName("username").item(0).getTextContent();
            password = root.getElementsByTagName("password").item(0).getTextContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}

