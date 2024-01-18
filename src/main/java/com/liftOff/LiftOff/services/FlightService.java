package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.FlightNotFoundException;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Reservation;

import java.util.List;

public interface FlightService {

    Flight get(Integer id);
    List<Flight> getAllFlights();

    // save or saveOrUpdate?
    Flight save(Flight flight);

    void delete(Integer id) throws FlightNotFoundException;



}
