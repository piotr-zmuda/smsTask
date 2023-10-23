package com.example.zadanie.Dtos;

public class SmsDTO {
    private Integer id;
    private Integer senderId;
    private Integer recipientId;
    private String message;

    public SmsDTO(Integer id, Integer senderId, Integer recipientId, String message){
        this.id=id;
        this.senderId=senderId;
        this.recipientId=recipientId;
        this.message=message;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }
}
