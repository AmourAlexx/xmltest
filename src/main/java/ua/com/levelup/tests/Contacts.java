package ua.com.levelup.tests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

public class Contacts {
    List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    @XmlElement(name="contact")
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }




}
