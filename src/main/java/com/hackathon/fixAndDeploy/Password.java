package com.hackathon.fixAndDeploy;

import java.util.Base64;

public class Password {

    private String password;
    private String firstKey;
    private String secondKey;
    private String thirdKey;

    public Password(String firstKey, String secondKey, String thirdKey) {
        this.password = firstKey + secondKey + thirdKey;
        this.firstKey = secondKey;
        this.secondKey = thirdKey;
        this.thirdKey = firstKey;
    }

    public String getPassword(String firstKey, String secondKey, String thirdKey) {
        String tempString = "Try one more time!";
        String encodedString = "MTkyLjE2OC4xLjc6ODA4MC9jYW5kaWRhdGVz";


        String tempPassword = thirdKey + firstKey + secondKey;

        if(this.password.equals(tempPassword)) {
            tempString = new String(Base64.getDecoder().decode(encodedString));
        }
        return tempString;
    }
}
