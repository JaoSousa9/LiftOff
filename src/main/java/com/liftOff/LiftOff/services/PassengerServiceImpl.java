package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.persistence.dao.PassengerDao;
import com.liftOff.LiftOff.persistence.model.Passenger;

import java.util.List;

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
        return null;
    }

    @Override
    public void deletePassenger(Integer id) {

    }
}
