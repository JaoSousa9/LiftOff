package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.FlightNotFoundException;
import com.liftOff.LiftOff.persistence.dao.FlightDao;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Reservation;

import java.util.List;
import java.util.Optional;

public class FlightServiceImp implements FlightService {

    FlightDao flightDao;

    // falta setters de todas as propriedades que usar, com @Autowired

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

    @Override
    public List<Reservation> getReservationsForFlight(Flight flight) {
        return flight.getReservations();
    }

    @Override
    public Integer getReservationsNumberForFlight(Flight flight) {
        return flight.getReservations().size();
    }
}
