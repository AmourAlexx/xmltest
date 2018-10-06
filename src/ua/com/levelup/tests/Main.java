package ua.com.levelup.tests;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = f.newDocumentBuilder();

        Document doc = builder.parse(new File("test.xml"));
        NodeList lst = doc.getDocumentElement().getElementsByTagName("contact");

        for (int i = 0; i < lst.getLength(); i++) {
            Node n = lst.item(i);
            NamedNodeMap at = n.getAttributes();

            Contact c = new Contact();
            c.setType(at.getNamedItem("type").getNodeValue());
            c.setFirstName(at.getNamedItem("firstName").getNodeValue());
            c.setLastName(at.getNamedItem("lastName").getNodeValue());
            c.setEmail(at.getNamedItem("email").getNodeValue());

            if (n instanceof Element) {
                Element en = (Element) n;
                NodeList addrLst = en.getElementsByTagName("address");
                if (addrLst.getLength() > 0) {
                    Element addr = (Element) addrLst.item(0);
                    Address ad = new Address();
                    ad.setCity(addr.getAttribute("city"));
                    ad.setPostIndex(addr.getAttribute("postIndex"));
                    NodeList phoneLst = addr.getElementsByTagName("phoneNumber");
                    for (int j = 0; j < phoneLst.getLength(); j++) {
                        ad.getNumbers().add(((Element)phoneLst.item(j)).getAttribute("value"));
                    }
                    c.setAddress(ad);
                }

            }
            contacts.add(c);
        }

        for (Contact c: contacts)
            System.out.println(c);
    }



}
