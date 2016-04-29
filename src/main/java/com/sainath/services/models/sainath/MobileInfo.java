package com.sainath.services.models.sainath;

import javax.persistence.*;

/**
 * Created by babjik on 22/4/16.
 */
@Entity
@Table(name = "mobile_info")
public class MobileInfo {
    private int Id;
    private String countryCode;
    private long mobileNumber;
    private short mobileType;
    private Person person;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Column(name = "mobile_number")
    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Column(name = "mobile_type")
    public short getMobileType() {
        return mobileType;
    }

    public void setMobileType(short mobileType) {
        this.mobileType = mobileType;
    }

    @Override
    public String toString() {
        return "MobileInfo{" +
                "Id=" + Id +
                ", countryCode='" + countryCode + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", mobileType=" + mobileType +
                '}';
    }
}
