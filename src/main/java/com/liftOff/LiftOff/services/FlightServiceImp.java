package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.FlightNotFoundException;
import com.liftOff.LiftOff.persistence.dao.FlightDao;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImp implements FlightService {

    FlightDao flightDao;

    @Autowired
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }
    @Override
    public Flight get(Integer id) {
        return flightDao.findById(id);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.findAll();
    }

    @Override
    public Flight save(Flight flight) {
        return flightDao.saveOrUpdate(flight);
    }

    @Override
    public void delete(Integer id) throws FlightNotFoundException {
        Flight flight = Optional.ofNullable(flightDao.findById(id))
                .orElseThrow(FlightNotFoundException::new);

        flightDao.delete(id);
    }


}
