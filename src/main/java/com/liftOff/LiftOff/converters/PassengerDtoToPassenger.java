package com.liftOff.LiftOff.converters;

import com.liftOff.LiftOff.command.PassengerDto;
import com.liftOff.LiftOff.persistence.model.Passenger;
import org.springframework.core.convert.converter.Converter;

public class PassengerDtoToPassenger implements Converter<PassengerDto, Passenger> {

    @Override
    public Passenger convert(PassengerDto source) {
        return null;
    }

    @Override
    public <U> Converter<PassengerDto, U> andThen(Converter<? super Passenger, ? extends U> after) {
        return Converter.super.andThen(after);
    }

}
