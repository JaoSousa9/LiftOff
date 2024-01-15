package com.liftOff.LiftOff.persistence.model;

import com.liftOff.LiftOff.persistence.model.enums.ReservationState;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservation")
@IdClass(ReservationId.class)
public class Reservation extends AbstractModel {

    @Id
    private Integer assigned_seat_id;
    private String date;
    private String hour;
    private ReservationState state;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flight;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "reservation"
    )
    private List<AssignedSeat> assignedSeats = new ArrayList<>();


    public void setAssignedSeats(List<AssignedSeat> assignedSeats) {
        this.assignedSeats = assignedSeats;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public ReservationState getState() {
        return state;
    }

    public void setState(ReservationState state) {
        this.state = state;
    }


    public Integer getAssigned_seat_id() {
        return assigned_seat_id;
    }

    public void setAssigned_seat_id(Integer assigned_seat_id) {
        this.assigned_seat_id = assigned_seat_id;
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

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public List<AssignedSeat> getAssignedSeats() {
        return assignedSeats;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                ", assigned_seat_id=" + assigned_seat_id +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", passenger=" + passenger +
                ", flight=" + flight +
                '}';
    }
}
