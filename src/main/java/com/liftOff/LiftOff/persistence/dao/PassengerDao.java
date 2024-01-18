package com.liftOff.LiftOff.persistence.dao;

import com.liftOff.LiftOff.exceptions.PassengerNotFoundException;
import com.liftOff.LiftOff.persistence.model.Passenger;

public interface PassengerDao extends Dao<Passenger> {
    Passenger findByUsername(String username) throws PassengerNotFoundException;
}
