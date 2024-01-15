package com.liftOff.LiftOff.persistence.model;

import java.io.Serializable;

public class ReservationId implements Serializable {

    private Integer id;
    private Integer assigned_seat_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssigned_seat_id() {
        return assigned_seat_id;
    }

    public void setAssigned_seat_id(Integer assigned_seat_id) {
        this.assigned_seat_id = assigned_seat_id;
    }
}
