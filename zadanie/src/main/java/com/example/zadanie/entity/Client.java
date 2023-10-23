package com.example.zadanie.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"sentSms", "receivedSms"})
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer mobileNumber;

    private Boolean isServiceUp;

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.MERGE)
    private List<Sms> receivedSms = new ArrayList<>();

    @OneToMany(mappedBy = "sender", cascade = CascadeType.MERGE)
    private List<Sms> sentSms = new ArrayList<>();


    public void setServiceUp(Boolean serviceUp) {
        isServiceUp = serviceUp;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getServiceUp() {
        return isServiceUp;
    }

    public void setIsServiceUp(Boolean serviceUp) {
        isServiceUp = serviceUp;
    }


    public void setReceivedSms(List<Sms> receivedSms) {
        this.receivedSms = receivedSms;
    }

    public void setSentSms(List<Sms> sentSms) {
        this.sentSms = sentSms;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public Boolean getIsServiceUp() {
        return isServiceUp;
    }

    public Integer getId() {
        return id;
    }

    public List<Sms> getReceivedSms() {
        return receivedSms;
    }

    public List<Sms> getSentSms() {
        return sentSms;
    }

    public void insertNewReceivedSms(Sms sms) {
        if (!this.receivedSms.contains(sms)) {
            this.receivedSms.add(sms);
            sms.setRecipient(this); // setting the relationship on the Sms entity
        }
    }

    public void insertNewSentSms(Sms sms) {
        if (!this.sentSms.contains(sms)) {
            this.sentSms.add(sms);
            sms.setSender(this); // setting the relationship on the Sms entity
        }
    }

}
