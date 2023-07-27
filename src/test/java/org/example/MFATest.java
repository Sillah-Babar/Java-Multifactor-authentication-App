package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MFATest {

    MFA mf;

    @Test
    public void getInstance() {
        //intra class testing
        mf=MFA.getInstance();
        assertEquals(mf!=null,true);
    }

    @Test
    public void generateSecretKey() {
        //intra class testing
        mf=MFA.getInstance();
        String secret_key=mf.generateSecretKey();
        assertEquals(32,secret_key.length());
    }

    @Test
    public void getTOTPCode() {
        mf=MFA.getInstance();
        String secret_key=mf.generateSecretKey(); //inter method testing
        String otp=mf.getTOTPCode(secret_key);
        assertEquals(6,otp.length());

    }
}