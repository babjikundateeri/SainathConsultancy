package com.sainath.services.models.sainath;

import javax.persistence.*;

/**
 * Created by babjik on 22/4/16.
 */

@Entity
@Table(name = "email_info")
public class EmailInfo {
    private int id;
    private String emailId;
    private Short emailType;
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "email_id")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "email_type")
    public Short getEmailType() {
        return emailType;
    }

    public void setEmailType(Short emailType) {
        this.emailType = emailType;
    }

    @Override
    public String toString() {
        return "EmailInfo{" +
                "id=" + id +
                ", emailId='" + emailId + '\'' +
                ", emailType=" + emailType +
                '}';
    }
}


