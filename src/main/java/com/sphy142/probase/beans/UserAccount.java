
package com.sphy142.probase.beans;


public class UserAccount {
    private String userName;
    private String password;
    private String gender;
    // edo tha xreiastei kai user role....
    // gia tin dikia mou efarmogi
    public UserAccount() {
    
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}
