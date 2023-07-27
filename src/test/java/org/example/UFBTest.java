package org.example;

import com.google.zxing.WriterException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class UFBTest {
     UFB uf;
     @Before
     public void UFBTest() throws IOException {
         uf=UFB.getInstance();
         uf.readObservers();
     }
    @Test
    public void getInstance() throws IOException {
    uf= UFB.getInstance();
    boolean check=false;
    if(uf!=null)
        check=true;
    assertEquals(check,true);
    }

    @Test
    public void authenticateUser() {
         StudentListener st=uf.authenticateUser("emmawilson@ufb.com","Emma22!");
         boolean check=false;
         if(st!=null)
         {
             check=true;
         }
         assertEquals(check,true);
    }


    @Test
    public void setSignupDetails() {
         String email="emmawilson@ufb.com";
         String fn="emma";
         String ln="wilson";
         boolean check=uf.setSignupDetails(email,fn,ln);
         assertEquals(check,true);
         email="emerawilson@ufb.com";
        fn="emma";
         ln="wilson";
        check=uf.setSignupDetails(email,fn,ln);
        assertEquals(check,false);
    }

    @Test
    public void registerSt() throws IOException, WriterException {
         StudentListener observer=new StudentListener();
         boolean check=uf.registerSt(observer);
         assertEquals(check,true);
    }


}