package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.SeatNotFoundException;
import com.liftOff.LiftOff.persistence.model.Seat;

import java.util.List;

public interface SeatService {

    Seat get(Integer id);

    List<Seat> getAllSeats();

    Seat saveOrUpdate(Seat seat);

    void delete (Integer id) throws SeatNotFoundException;

}
