package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.AssignedSeatNotFoundException;
import com.liftOff.LiftOff.persistence.dao.AssignedSeatDao;
import com.liftOff.LiftOff.persistence.dao.FlightDao;
import com.liftOff.LiftOff.persistence.dao.PassengerDao;
import com.liftOff.LiftOff.persistence.dao.SeatDao;
import com.liftOff.LiftOff.persistence.model.AssignedSeat;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.persistence.model.Seat;
import com.liftOff.LiftOff.persistence.model.enums.SeatAvailability;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AssignedSeatServiceImpl implements AssignedSeatService {

    AssignedSeatDao assignedSeatDao;
    FlightDao flightDao;
    PassengerDao passengerDao;

    SeatDao seatDao;

    // falta o @Autowired
    public void setAssignedSeatDao(AssignedSeatDao assignedSeatDao) {
        this.assignedSeatDao = assignedSeatDao;
    }

    // @Autowired
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    // @Autowired
    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    // @Autowired
    public void setSeatDao(SeatDao seatDao) {
        this.seatDao = seatDao;
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
    public AssignedSeat findByFlightAndSeat(Flight flight, Seat seat) {
        return null;
    }

    @Override
    public List<AssignedSeat> findByFlight(Flight flight) {
        List<AssignedSeat> assignedSeatList = assignedSeatDao.findAll();
        List<AssignedSeat> availableSeats = new ArrayList<>();

        for (AssignedSeat seat : assignedSeatList) {
            if (seat.getFlight_id().equals(flight.getId())) {
                availableSeats.add(seat);
            }
        }

        return availableSeats;
    }


    @Override
    public List<AssignedSeat> findAssignedSeatsByFlightAndPassenger(Flight flight, Passenger passenger) {
      return null;
    }

    @Override
    public List<AssignedSeat> findByPassenger(Passenger passenger) {
        return null;
    }

    @Override
    public void updateAvailability(Integer id, SeatAvailability seatAvailability) {
        AssignedSeat assignedSeat = assignedSeatDao.findById(id);
        if(assignedSeat != null){
            assignedSeat.setAvailability(seatAvailability);
            assignedSeatDao.saveOrUpdate(assignedSeat);
        }
    }

    @Override
    public Integer countAssignedSeatsByFlight(Flight flight) {
        List<AssignedSeat> allAssignedSeats = assignedSeatDao.findAll();
        Integer countSeats = 0;
        for (AssignedSeat assignedSeat : allAssignedSeats) {
            if (assignedSeat.getFlight_id().equals(flight)) {
                countSeats++;
            }
        }
        return countSeats;
    }

    @Override
    public Integer countAssignedSeatsByPassenger(Passenger passenger) {
        return null;
    }
}
