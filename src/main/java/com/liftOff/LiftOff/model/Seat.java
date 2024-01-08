package com.liftOff.LiftOff.model;


import com.liftOff.LiftOff.model.enums.SeatClass;
import jakarta.persistence.*;

@Entity
@Table(name = "seat")
public class Seat extends AbstractModel {

    private SeatClass seatClass;
    private double price;

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
