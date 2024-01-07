package com.liftOff.model;

import com.liftOff.model.enums.ReservationState;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation extends AbstractModel {

    /*private Integer flight_id;
    private Integer passenger_id;*/
    private Integer assigned_seat_id;
    private String date;
    private String hour;
    private ReservationState state;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flight;

    @OneToOne(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "reservation"
    )
    private AssignedSeat assignedSeat;

    /*public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public Integer getPassenger_id() {
        return passenger_id;
    }*/

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

    /*public void setPassenger_id(Integer passenger_id) {
        this.passenger_id = passenger_id;
    }*/

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

    public AssignedSeat getAssignedSeat() {
        return assignedSeat;
    }

    public void setAssignedSeat(AssignedSeat assignedSeat) {
        this.assignedSeat = assignedSeat;
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
