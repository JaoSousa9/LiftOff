package com.liftOff.LiftOff.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "passenger")
public class Passenger extends AbstractModel {

    private String firstNname;
    private String lastName;
    private String email;
    private String password;
    private String username;


    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "passenger",
            fetch = FetchType.EAGER
    )
    private List<Reservation> reservations;


    public String getFirstNname() {
        return firstNname;
    }

    public void setFirstNname(String firstNname) {
        this.firstNname = firstNname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setPassenger(this);
    }



}