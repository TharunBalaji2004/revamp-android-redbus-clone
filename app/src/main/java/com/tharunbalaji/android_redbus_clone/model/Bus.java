package com.tharunbalaji.android_redbus_clone.model;

public class Bus {
    private String busName, busType, startingTime, endingTime, ticketPrice, totalSeats,startingLocation,destination;

    public Bus(String busName, String busType, String startingTime, String endingTime, String ticketPrice, String totalSeats, String startingLocation, String destination) {
        this.busName = busName;
        this.busType = busType;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.ticketPrice = ticketPrice;
        this.totalSeats = totalSeats;
        this.startingLocation = startingLocation;
        this.destination = destination;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
