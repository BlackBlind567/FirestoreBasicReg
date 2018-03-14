package com.blackblind.firestorebasicreg;

/**
 * Created by BlackBlind on 3/14/2018.
 */

public class users {

    String name, email;

    public users(){

    }

    public users(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
