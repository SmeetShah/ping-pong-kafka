package com.example.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class controllerTest {

    private myController c = new myController();

    @Test
    public void testForAdditionEqual5(){
        int s = c.doAddition(5,4);

        Assertions.assertEquals(5,s);
    }

    @Test
    public void testForAdditionNotEqual10(){
        int s = c.doAddition(5,4);

        Assertions.assertNotEquals(10,s);

    }

}
