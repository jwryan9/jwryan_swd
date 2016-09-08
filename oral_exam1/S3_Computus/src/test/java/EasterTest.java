package test.java;

import main.java.Easter;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

/**
 * Created by jasonryan on 9/6/16.
 */
public class EasterTest {
    Easter e = new Easter(2016);

    @Test
    public void getMonth() throws Exception {
        Assert.assertEquals(e.getMonth(), 3);
    }

    @Test
    public void getDay() throws Exception {
        Assert.assertEquals(e.getDay(), 27);
    }

}