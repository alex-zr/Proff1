package ua.com.prog.jdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.kiev.prog.refrash.Main;

import static org.junit.Assert.*;

public class MainTest {

    public Main main;

    @Before
    public void setUp() {
        main = new Main();
    }

    @Test
    public void testAddSuccess() {
        int expected = 4;
        int actual = main.add(2,2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddNull() {
        int expected = 0;
        int actual = main.add(null,null);

        Assert.assertEquals(expected, actual);
    }

}