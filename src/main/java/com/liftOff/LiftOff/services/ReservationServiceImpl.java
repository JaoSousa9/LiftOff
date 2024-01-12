package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.ReservationNotFoundException;
import com.liftOff.LiftOff.persistence.dao.ReservationDao;
import com.liftOff.LiftOff.persistence.model.Reservation;

import java.util.List;
import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {

    ReservationDao reservationDao;

    // @Autowired
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
        return reservationDao.saveOrUpdate(reservation);
    }

    @Override
    public void deleteReservation(Integer id) throws ReservationNotFoundException {
        Reservation reservation = Optional.ofNullable(reservationDao.findById(id))
                .orElseThrow(ReservationNotFoundException::new);

        reservationDao.delete(id);

    }
}
