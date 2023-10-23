package com.example.zadanie.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="sms")
public class Sms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Client sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Client recipient;

    public void setRecipient(Client recipient) {
        this.recipient = recipient;
    }

    public Client getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public Client getRecipient() {
        return recipient;
    }

    public Boolean getCheckedForPhishing() {
        return checkedForPhishing;
    }

    public Integer getId() {
        return id;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    private String message;

    private Boolean checkedForPhishing;

    public void setCheckedForPhishing(Boolean checkedForPhishing) {
        this.checkedForPhishing = checkedForPhishing;
    }
}
