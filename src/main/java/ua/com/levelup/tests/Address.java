package ua.com.levelup.tests;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Address {

    private String city;
    private String postIndex;
    private List<String> numbers = new ArrayList<>();

    public List<String> getNumbers() {
        return numbers;
    }

    @XmlElement(name="phoneNumber")
    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        String res = postIndex+", "+city+", tel: ";
        for (String n: numbers) {
            res += n+", ";
        }
        return res;
    }
}
