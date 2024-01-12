package com.liftOff.LiftOff.exceptions;

import com.liftOff.LiftOff.errors.ErrorMessage;

public class ReservationNotFoundException extends ApplicationException {
    public ReservationNotFoundException() {
        super(ErrorMessage.RESERVATION_NOT_FOUND);
    }
}
