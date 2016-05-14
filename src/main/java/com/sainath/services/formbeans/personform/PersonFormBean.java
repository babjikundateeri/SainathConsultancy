package com.sainath.services.formbeans.personform;

/**
 * Created by babjik on 23/4/16.
 */
public class PersonFormBean {
//
//    @NotNull
    private String firstName;
//
//    @NotNull
    private String lastName;
//
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


    @Override
    public String toString() {
        return "PersonFormBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
