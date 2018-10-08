package ua.com.levelup.tests;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;

public class XMLController {

    public PhoneBook read(File f) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PhoneBook.class);
        Unmarshaller m = context.createUnmarshaller();
        return (PhoneBook)m.unmarshal(f);
    }

    public void write(PhoneBook pb, File f) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PhoneBook.class);
        Marshaller m = context.createMarshaller();
        m.marshal(pb,f);
    }
}
