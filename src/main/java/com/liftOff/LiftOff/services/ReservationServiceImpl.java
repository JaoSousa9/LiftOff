package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.ReservationNotFoundException;
import com.liftOff.LiftOff.persistence.dao.ReservationDao;
import com.liftOff.LiftOff.persistence.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationServiceImpl implements ReservationService {

    ReservationDao reservationDao;

    @Autowired
    public void setReservationDao(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Override
    public Reservation get(Integer id) {
        return reservationDao.findById(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationDao.findAll();
    }

    @Override
    public Reservation saveOrUpdate(Reservation reservation) {
        return null;
    }

    @Override
    public void deleteReservation(Integer id) throws ReservationNotFoundException {

    }

    @Override
    public List<Reservation> getPassengerReservations() {
        return null;
    }
}
