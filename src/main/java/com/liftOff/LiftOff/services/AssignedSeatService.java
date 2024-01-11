package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.AssignedSeatNotFoundException;
import com.liftOff.LiftOff.persistence.model.AssignedSeat;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.persistence.model.Seat;
import com.liftOff.LiftOff.persistence.model.enums.SeatAvailability;

import java.util.List;

public interface AssignedSeatService {

    AssignedSeat get(Integer id);

    List<AssignedSeat> findAllAssignedSeats();

    // save or saveOrUpdate?
    AssignedSeat save(AssignedSeat assignedSeat);

    void delete(Integer id) throws AssignedSeatNotFoundException;

    AssignedSeat findByFlightAndSeat(Flight flight, Seat seat);

    List<AssignedSeat> findByFlight(Flight flight);

    List<AssignedSeat>findAssignedSeatsByFlightAndPassenger(Flight flight, Passenger passenger);

    List<AssignedSeat> findByPassenger(Passenger passenger);
    void updateAvailability(Integer id, SeatAvailability seatAvailability);

    Integer countAssignedSeatsByFlight(Flight flight);

    Integer countAssignedSeatsByPassenger(Passenger passenger);
}