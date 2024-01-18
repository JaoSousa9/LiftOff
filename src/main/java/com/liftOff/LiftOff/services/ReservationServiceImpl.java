package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.persistence.dao.ReservationDao;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.persistence.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return reservationDao.saveOrUpdate(reservation);
    }

    @Override
    public void deleteReservation(Integer id){
        reservationDao.delete(id);
    }

    @Override
    public List<Reservation> getPassengerReservations(Passenger passenger) {
        List <Reservation> allReservationsList = reservationDao.findAll();
        List <Reservation> passengerReservations = new ArrayList<>();

        for (Reservation reservation : allReservationsList) {
            if(reservation.getPassenger().getId().equals(passenger.getId())) {
                passengerReservations.add(reservation);
            }
        }
        return passengerReservations;
    }

    @Override
    public List<Reservation> getFlightReservations(Flight flight) {
        List<Reservation> allReservationsList = reservationDao.findAll();
        List<Reservation> flightReservations = new ArrayList<>();

        for(Reservation reservation : allReservationsList) {
            if(reservation.getPassenger().getId().equals(flight.getId())) {
                flightReservations.add(reservation);
            }
        }
        return flightReservations;
    }

}
