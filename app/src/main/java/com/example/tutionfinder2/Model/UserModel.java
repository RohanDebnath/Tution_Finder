package com.example.tutionfinder2.Model;

public class UserModel {
    String Firstname, Lastname, ID, email, Password;

    public UserModel() {
    }

    public UserModel(String firstname, String lastname, String ID, String email, String password) {
        Firstname = firstname;
        Lastname = lastname;
        this.ID = ID;
        this.email = email;
        Password = password;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
