package com.liftOff.LiftOff.persistence.model;

import com.liftOff.LiftOff.persistence.model.enums.ReservationState;
import com.liftOff.LiftOff.persistence.model.enums.SeatClass;
import jakarta.persistence.*;

@Entity
@Table(name = "assigned_seat")
public class AssignedSeat extends AbstractModel {

    private SeatClass seatClass;
    private String seatNumber;
    private String price;
    private ReservationState reservationState;
    private String firstName;
    private String lastName;
    private Integer cc;
    @ManyToOne
    private Reservation reservation;

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ReservationState getReservationState() {
        return reservationState;
    }

    public void setReservationState(ReservationState reservationState) {
        this.reservationState = reservationState;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
