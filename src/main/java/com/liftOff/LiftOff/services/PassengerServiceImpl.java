package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.AssignedSeatNotFoundException;
import com.liftOff.LiftOff.exceptions.PassengerNotFoundException;
import com.liftOff.LiftOff.persistence.dao.PassengerDao;
import com.liftOff.LiftOff.persistence.model.AssignedSeat;
import com.liftOff.LiftOff.persistence.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PassengerServiceImpl implements  PassengerService {

    PassengerDao passengerDao;

     @Autowired

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
    public void deletePassenger(Integer id) {
        passengerDao.delete(id);
    }

    @Override
    public Passenger getPassengerByUsername(String username) throws PassengerNotFoundException {
        return passengerDao.findByUsername(username);
    }
}
