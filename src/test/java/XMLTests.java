import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.levelup.tests.Calculator;

import static junit.framework.Assert.*;
import java.util.Random;

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

}
