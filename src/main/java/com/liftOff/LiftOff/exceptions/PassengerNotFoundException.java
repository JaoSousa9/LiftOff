package com.liftOff.LiftOff.exceptions;

import com.liftOff.LiftOff.errors.ErrorMessage;

public class PassengerNotFoundException extends ApplicationException {
    public PassengerNotFoundException() {
        super(ErrorMessage.PASSENGER_NOT_FOUND);
    }
}
