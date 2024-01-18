package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.PassengerNotFoundException;
import com.liftOff.LiftOff.persistence.model.Passenger;

import java.util.List;

public interface PassengerService {

    Passenger get(Integer id);
    List<Passenger> getAllPassengers();

    Passenger saveOrUpdate (Passenger passenger);

    void deletePassenger(Integer id) throws PassengerNotFoundException;

    Passenger getPassengerByUsername(String username) throws PassengerNotFoundException;
}
