package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MFAcredentialsTest {
    MFAcredentials mf;

    @Test
    public void QRcodeTest()
    {
        mf=new MFAcredentials();
        mf.setQrcode("hellp.png");
        assertEquals(mf.getQrcode(),"hellp.png");
        mf.setQrcode("jdsifjsdif.png");
        assertEquals(mf.getQrcode(),"jdsifjsdif.png");

    }
    public void scretKeyTest()
    {
        mf=new MFAcredentials();
        mf.setSecret_key("8293829");
        assertEquals(mf.getSecret_key(),"8293829");
        mf.setSecret_key("jsiadjisd");
        assertEquals(mf.getSecret_key(),"jsiadjisd");
    }

}