package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.FlightNotFoundException;
import com.liftOff.LiftOff.exceptions.PassengerNotFoundException;
import com.liftOff.LiftOff.persistence.dao.PassengerDao;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Passenger;

import java.util.List;
import java.util.Optional;

public class PassengerServiceImpl implements  PassengerService {

    PassengerDao passengerDao;

    // @Autowired

    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Override
    public Passenger get(Integer id) {
        return passengerDao.findById(id);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerDao.findAll();
    }

    @Override
    public Passenger saveOrUpdate(Passenger passenger) {
        return passengerDao.saveOrUpdate(passenger);
    }

    @Override
    public void deletePassenger(Integer id) throws PassengerNotFoundException {
        Passenger passenger = Optional.ofNullable(passengerDao.findById(id))
                .orElseThrow(PassengerNotFoundException::new);

        passengerDao.delete(id);
    }
}
