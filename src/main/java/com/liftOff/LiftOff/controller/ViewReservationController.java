package com.liftOff.LiftOff.controller;

import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.persistence.model.Reservation;
import com.liftOff.LiftOff.services.ReservationService;

import java.util.List;

public class ViewReservationController extends AbstractController {

    private ReservationService reservationService;
    private Controller nextController;
    private Passenger passenger;


    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public List<Reservation> getPassengerReservations() {
        return reservationService.getPassengerReservations();
    }

    public Passenger getPassenger() {
        passenger = new Passenger();

    }
}
