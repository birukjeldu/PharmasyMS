package com.pharmacy;

public class Users {
    private String userName;
    private String fullName;
    private String email;
    private char sex;
    private String password;


    public Users(String userName, String fullName, String email, char sex, String password){
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.sex = sex;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public char getSex(){
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
