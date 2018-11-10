import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.levelup.tests.Address;
import ua.com.levelup.tests.Calculator;
import ua.com.levelup.tests.Contact;

import java.io.*;
import java.util.Date;
import java.util.Random;

import static junit.framework.Assert.assertEquals;

public class XMLTests {

    static double a;
    static double b;


    @Test
    public void testMult() {
        double res = Calculator.mult(a,b);
        System.out.println(res);
    }

    @Test
    public void testMultBD() {
        double res = Calculator.multBD(a,b);
        System.out.println(res);
    }

    @Test
    public void testEq() {
        assertEquals(Calculator.multBD(a,b),Calculator.mult(a,b)+1,0.9);
    }

    @BeforeClass
    public static void genData() {
        a = (double)(new Random().nextInt(100000))/1000;
        b = (double)(new Random().nextInt(100000))/1000;
    }

    @Test
    public void testSerCreate() {
        try {
            Contact cc = new Contact();
            cc.setType("friend");
            cc.setFirstName("Oleh");
            cc.setLastName("Gromov");
            cc.setEmail("oleh.gromov@gmail.com");
            Address adr = new Address();
            adr.setPostIndex("45999");
            adr.setCity("Dnipro");
            adr.getNumbers().add("323-562");
            adr.getNumbers().add("333-888");
            cc.setAddress(adr);

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contact.dat"));
            Date now = new Date();
            out.writeObject(now);
            out.writeObject(cc);
            out.close();
            System.out.println("write: "+now+" "+cc.toString());
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testSerRead() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("contact.dat"));
            Date now = (Date)in.readObject();
            Contact c = (Contact)in.readObject();
            in.close();
            System.out.println("read: "+ now+" "+c.toString());
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testSerStream() {
        try {
            Contact cc = new Contact();
            cc.setType("friend");
            cc.setFirstName("Oleh");
            cc.setLastName("Gromov");
            cc.setEmail("oleh.gromov@gmail.com");
            Address adr = new Address();
            adr.setPostIndex("45999");
            adr.setCity("Dnipro");
            adr.getNumbers().add("323-562");
            adr.getNumbers().add("333-888");
            cc.setAddress(adr);

            ObjectOutputStream out = new ObjectOutputStream(new ByteArrayOutputStream());
            Date now = new Date();
            out.writeObject(now);
            out.writeObject(cc);
            out.close();

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
