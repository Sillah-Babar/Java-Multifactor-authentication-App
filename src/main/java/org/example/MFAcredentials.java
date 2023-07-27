package org.example;

public class MFAcredentials {
    private String qrcode;

    private String secret_key;


    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public String getQrcode() {
        return qrcode;
    }

    public String getSecret_key() {
        return secret_key;
    }


}
