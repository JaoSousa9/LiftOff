package com.liftOff.LiftOff.persistence.model;

import com.liftOff.LiftOff.persistence.model.enums.SeatAvailability;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "assigned_seat")
public class AssignedSeat extends AbstractModel {

    private Integer flight_id;
    private Integer seat_id;
    private SeatAvailability availability;
    private String seat_number;


    @OneToOne
    private Reservation reservation;


    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
    }

    public SeatAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(SeatAvailability availability) {
        this.availability = availability;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
