package com.liftOff.LiftOff.persistence.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight extends AbstractModel {

    private String flightNumber;
    private String origin;
    private String destiny;
    private Integer capacity;
    private String date;
    private String hour;
    private String duration;

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
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
