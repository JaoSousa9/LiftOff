package com.liftOff.LiftOff.persistence.dao;

import com.liftOff.LiftOff.persistence.model.Flight;

import java.util.List;

public interface FlightDao extends Dao<Flight> {

    public List<Flight> searchFlightOriginDestinyDate(String origin, String destiny, String date);

    public List<Flight> searchFlightOriginDestinyPrice(String origin, String destiny, Integer price);
}
