package com.liftOff.LiftOff.exceptions;

import com.liftOff.LiftOff.errors.ErrorMessage;

public class AssignedSeatNotFoundException extends ApplicationException {
    public AssignedSeatNotFoundException () {super(ErrorMessage.ASSIGNED_SEAT_NOT_FOUND);}
}
