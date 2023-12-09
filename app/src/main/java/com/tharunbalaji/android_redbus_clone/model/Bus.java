package com.tharunbalaji.android_redbus_clone.model;

public class Bus {
    private String etBusName, etBusType, etStartingTime, etEndingTime, etTicketPrice, etTotalSeats;

    public String getEtBusName() {
        return etBusName;
    }

    public void setEtBusName(String etBusName) {
        this.etBusName = etBusName;
    }

    public String getEtBusType() {
        return etBusType;
    }

    public void setEtBusType(String etBusType) {
        this.etBusType = etBusType;
    }

    public String getEtStartingTime() {
        return etStartingTime;
    }

    public void setEtStartingTime(String etStartingTime) {
        this.etStartingTime = etStartingTime;
    }

    public String getEtEndingTime() {
        return etEndingTime;
    }

    public void setEtEndingTime(String etEndingTime) {
        this.etEndingTime = etEndingTime;
    }

    public String getEtTicketPrice() {
        return etTicketPrice;
    }

    public void setEtTicketPrice(String etTicketPrice) {
        this.etTicketPrice = etTicketPrice;
    }

    public String getEtTotalSeats() {
        return etTotalSeats;
    }

    public void setEtTotalSeats(String etTotalSeats) {
        this.etTotalSeats = etTotalSeats;
    }

    public Bus(String etBusName, String etBusType, String etStartingTime, String etEndingTime, String etTicketPrice, String etTotalSeats) {
        this.etBusName = etBusName;
        this.etBusType = etBusType;
        this.etStartingTime = etStartingTime;
        this.etEndingTime = etEndingTime;
        this.etTicketPrice = etTicketPrice;
        this.etTotalSeats = etTotalSeats;


    }
}
