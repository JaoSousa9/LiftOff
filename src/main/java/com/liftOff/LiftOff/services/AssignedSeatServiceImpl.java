package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.AssignedSeatNotFoundException;
import com.liftOff.LiftOff.persistence.dao.AssignedSeatDao;
import com.liftOff.LiftOff.persistence.dao.FlightDao;
import com.liftOff.LiftOff.persistence.dao.PassengerDao;
import com.liftOff.LiftOff.persistence.model.AssignedSeat;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.persistence.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class AssignedSeatServiceImpl implements AssignedSeatService {

    AssignedSeatDao assignedSeatDao;
    FlightDao flightDao;
    PassengerDao passengerDao;

   @Autowired
    public void setAssignedSeatDao(AssignedSeatDao assignedSeatDao) {
        this.assignedSeatDao = assignedSeatDao;
    }

    @Autowired
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Autowired
    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }


    @Override
    public AssignedSeat get(Integer id) {
        return assignedSeatDao.findById(id);
    }

    @Override
    public List<AssignedSeat> findAllAssignedSeats() {
        return assignedSeatDao.findAll();
    }

    @Override
    public AssignedSeat save(AssignedSeat assignedSeat) {
        return assignedSeatDao.saveOrUpdate(assignedSeat);
    }

    @Override
    public void delete(Integer id) throws AssignedSeatNotFoundException {
        AssignedSeat assignedSeat = Optional.ofNullable(assignedSeatDao.findById(id))
                .orElseThrow(AssignedSeatNotFoundException::new);

        assignedSeatDao.delete(id);
    }


    @Override
    public List<AssignedSeat> findByFlight(Flight flight) {
        List<AssignedSeat> assignedSeatList = assignedSeatDao.findAll();
        List<AssignedSeat> seatsByFlightList = new ArrayList<>();

        for (AssignedSeat seat : assignedSeatList) {
            if (seat.getReservation().getFlight().getId().equals(flight.getId())) {
                seatsByFlightList.add(seat);
            }
        }

        return seatsByFlightList;
    }


    @Override
    public List<AssignedSeat> findAssignedSeatsByFlightAndPassenger(Flight flight, Passenger passenger) {
        List<AssignedSeat> assignedSeatList = assignedSeatDao.findAll();
        List<AssignedSeat> seatsByFlightAndPassenger = new ArrayList<>();

        for(AssignedSeat seat : assignedSeatList){
            if(seat.getReservation().getFlight().getId().equals(flight.getId()) && seat.getReservation().getPassenger().getId().equals(passenger.getId())) {
                seatsByFlightAndPassenger.add(seat);
            }
        }

        return seatsByFlightAndPassenger;

    }


    @Override
    public List<AssignedSeat> findAssignedSeatByReservation(Reservation reservation) {
        List<AssignedSeat> assignedSeatList = assignedSeatDao.findAll();
        List<AssignedSeat> seatsByReservation = new ArrayList<>();

        for (AssignedSeat seat : assignedSeatList) {
            if(seat.getReservation().getId().equals(reservation.getId())) {
                seatsByReservation.add(seat);
            }
        }

        return seatsByReservation;
    }

    @Override
    public List<AssignedSeat> findByPassenger(Passenger passenger) {
       List<AssignedSeat> assignedSeatList = assignedSeatDao.findAll();
       List<AssignedSeat> seatsByPassenger = new ArrayList<>();

       for(AssignedSeat seat : assignedSeatList) {
           if(seat.getReservation().getPassenger().getId().equals(passenger.getId())) {
               seatsByPassenger.add(seat);
           }
       }
        return seatsByPassenger;
    }


    @Override
    public Integer countAssignedSeatsByFlight(Flight flight) {
        List<AssignedSeat> allAssignedSeats = assignedSeatDao.findAll();
        Integer countAssignedSeatsByFlight = 0;
        for (AssignedSeat assignedSeat : allAssignedSeats) {
            if (assignedSeat.getReservation().getFlight().getId().equals(flight.getId())) {
                countAssignedSeatsByFlight++;
            }
        }
        return countAssignedSeatsByFlight;
    }

    @Override
    public Integer countAssignedSeatsByPassenger(Passenger passenger) {
        List<AssignedSeat> allAssignedSeats = assignedSeatDao.findAll();
        Integer countAssignedSeatsByPassenger = 0;

        for(AssignedSeat assignedSeat : allAssignedSeats) {
            if(assignedSeat.getReservation().getPassenger().getId().equals(passenger.getId())) {
                countAssignedSeatsByPassenger++;
            }
        }
        return countAssignedSeatsByPassenger;
    }
}
