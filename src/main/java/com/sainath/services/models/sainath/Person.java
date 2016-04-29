package com.sainath.services.models.sainath;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by babjik on 21/4/16.
 */

@Entity
@Table(name = "person")
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;
    private Date createdOn;

    private Collection<EmailInfo> emailInfos = new ArrayList<EmailInfo>();
    private Collection<MobileInfo> mobileInfos = new ArrayList<MobileInfo>();

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "dob")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(name = "created_on")
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    @Fetch(value = FetchMode.SUBSELECT)
//    @JoinTable(name = "email_info", joinColumns = @JoinColumn(name = "person_id"))
    public Collection<EmailInfo> getEmailInfos() {
        return emailInfos;
    }

    public void setEmailInfos(Collection<EmailInfo> emailInfos) {
        this.emailInfos = emailInfos;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    @Fetch(value = FetchMode.SUBSELECT)
//    @JoinTable(name = "mobile_info", joinColumns = @JoinColumn(name = "person_id"))
    public Collection<MobileInfo> getMobileInfos() {
        return mobileInfos;
    }

    public void setMobileInfos(Collection<MobileInfo> mobileInfos) {
        this.mobileInfos = mobileInfos;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", createdOn=" + createdOn +
                ", emailInfos=" + emailInfos +
                ", mobileInfos=" + mobileInfos +
                '}';
    }
}
