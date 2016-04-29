package com.sainath.services.formbeans.personform;

import com.sun.istack.internal.NotNull;

/**
 * Created by babjik on 23/4/16.
 */
public class PersonFormBean {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
