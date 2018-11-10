package ua.com.levelup.tests;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) throws JAXBException {

        /*Contact cc = new Contact();
        cc.setType("friend");
        cc.setFirstName("Oleh");
        cc.setLastName("Gromov");
        cc.setEmail("ddd@ddd.fg");
        Address adr = new Address();
        adr.setPostIndex("45999");
        adr.setCity("Dnipro");
        adr.getNumbers().add("323-562");
        adr.getNumbers().add("333-888");
        cc.setAddress(adr);

        Contacts clst = new Contacts();
        clst.setContacts(new ArrayList<>());
        clst.getContacts().add(cc);

        PhoneBook pb = new PhoneBook();
        pb.setAuthor("A.M.");
        pb.setContacts(clst);*/

        StringWriter sw = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(PhoneBook.class);
        Unmarshaller m = context.createUnmarshaller();
        PhoneBook pb = (PhoneBook)m.unmarshal(new File("resources//test2.xml"));

        System.out.println(pb.toString());
    }



}
