package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.ReservationNotFoundException;
import com.liftOff.LiftOff.persistence.model.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation get(Integer id);
    List<Reservation> getAllReservations();

    Reservation saveOrUpdate (Reservation reservation);

    void deleteReservation(Integer id) throws ReservationNotFoundException;

    List<Reservation> getPassengerReservations();
}
