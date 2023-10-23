package com.example.zadanie.Dtos;

public class ClientDTO {
    private Integer id;
    private Integer mobileNumber;
    private Boolean isServiceUp;

    ClientDTO(Integer id, Integer mobileNumber, Boolean isServiceUp){
        this.id=id;
        this.mobileNumber=mobileNumber;
        this.isServiceUp=isServiceUp;
    }

    public Boolean getServiceUp() {
        return isServiceUp;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setServiceUp(Boolean serviceUp) {
        isServiceUp = serviceUp;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
