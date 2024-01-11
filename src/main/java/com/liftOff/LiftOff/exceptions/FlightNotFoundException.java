package com.liftOff.LiftOff.exceptions;

import com.liftOff.LiftOff.errors.ErrorMessage;

public class FlightNotFoundException extends ApplicationException {
    public FlightNotFoundException() {
        super(ErrorMessage.FLIGHT_NOT_FOUND);
    }
}
