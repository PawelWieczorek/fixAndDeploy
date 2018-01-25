package com.hackathon.fixAndDeploy;

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
        String tempString = "";

        String tempPassword = firstKey + secondKey + thirdKey;

        if(this.password.equals(tempPassword)) {
            //TODO: change localhost to your server
            tempString = "localhost:8080/candidates";
        }
        return tempString;
    }
}
