package com.liftOff.LiftOff.exceptions;

import com.liftOff.LiftOff.errors.ErrorMessage;

public class SeatNotFoundException extends ApplicationException {
    public SeatNotFoundException() {
        super(ErrorMessage.SEAT_NOT_FOUND);
    }
}
