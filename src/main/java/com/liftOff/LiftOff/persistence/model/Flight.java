package com.liftOff.LiftOff.persistence.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight extends AbstractModel {

    private String flightNumber;
    private String origin;
    private String destiny;
    private String departureHour;
    private String arrivalHour;
    private String date;
    private String duration;
    private Integer eCapacity;
    private Integer bCapacity;
    private Integer fCapacity;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "flight",
            fetch = FetchType.EAGER
    )
    private List<Reservation> reservations;



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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Integer geteCapacity() {
        return eCapacity;
    }

    public void seteCapacity(Integer eCapacity) {
        this.eCapacity = eCapacity;
    }

    public Integer getbCapacity() {
        return bCapacity;
    }

    public void setbCapacity(Integer bCapacity) {
        this.bCapacity = bCapacity;
    }

    public Integer getfCapacity() {
        return fCapacity;
    }

    public void setfCapacity(Integer fCapacity) {
        this.fCapacity = fCapacity;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setFlight(this);
    }

    // remove reservation

    // add flight - empresas
    // remove flight
    //


}
