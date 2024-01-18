package com.liftOff.LiftOff.command;

public class FlightDto {

    private Integer id;
    private String flightNumber;
    private String origin;
    private String destiny;
    private String departureHour;
    private String arrivalHour;
    private String date;
    private String duration;
    private String price;
    private Integer eCapacity;
    private Integer bCapacity;
    private Integer fCapacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
    }

    public String getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(String arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getECapacity() {
        return eCapacity;
    }

    public void setECapacity(Integer eCapacity) {
        this.eCapacity = eCapacity;
    }

    public Integer getBCapacity() {
        return bCapacity;
    }

    public void setBCapacity(Integer bCapacity) {
        this.bCapacity = bCapacity;
    }

    public Integer getFCapacity() {
        return fCapacity;
    }

    public void setFCapacity(Integer fCapacity) {
        this.fCapacity = fCapacity;
    }
}
