package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.AssignedSeatNotFoundException;
import com.liftOff.LiftOff.persistence.model.AssignedSeat;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.persistence.model.Reservation;

import java.util.List;

public interface AssignedSeatService {

    AssignedSeat get(Integer id);

    List<AssignedSeat> findAllAssignedSeats();

    // save or saveOrUpdate?
    AssignedSeat save(AssignedSeat assignedSeat);

    void delete(Integer id) throws AssignedSeatNotFoundException;

    List<AssignedSeat> findByFlight(Flight flight);

    List<AssignedSeat>findAssignedSeatsByFlightAndPassenger(Flight flight, Passenger passenger);

    List <AssignedSeat>findAssignedSeatByReservation(Reservation reservation);

    List<AssignedSeat> findByPassenger(Passenger passenger);

    Integer countAssignedSeatsByFlight(Flight flight);

    Integer countAssignedSeatsByPassenger(Passenger passenger);
}