package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordTest {
    Password pf;

    public  PasswordTest()
    {
        pf=new Password();
    }
    @Test
    public void setPassword() {
        pf.setPassword("sf12");
        assertEquals(pf.getPassword(),"sf12");

    }

    @Test
    public void setEmail() {
        pf.setEmail("sf@ufb.com");
        assertEquals(pf.getEmail(),"sf@ufb.com");
    }

    @Test
    public void getPassword() {
        pf.setPassword("sf12");
        assertEquals(pf.getPassword(),"sf12");
    }

    @Test
    public void getEmail() {
        pf.setEmail("sf@ufb.com");
        assertEquals(pf.getEmail(),"sf@ufb.com");
    }

    @Test
    public void authenticatePassword() {
        pf.setEmail("sf@ufb.com");
        pf.setPassword("sf12");
        boolean value=pf.authenticatePassword("sf@ufb.com","sf12");
        assertEquals(value,true);
    }

    @Test
    public void passwordConditions()
    {
        pf.setEmail("sf@ufb.com");
        pf.setPassword("sf12");
        boolean value=Password.passwordConditions(pf.password);
        assertEquals(value,true);
    }

    @Test
    public void emailConditions() {
        pf.setEmail("sf@ufb.com");
        pf.setPassword("sf12");
        boolean value=Password.emailConditions("sf@ufb.com","s","f");
        assertEquals(value,true);
    }
}