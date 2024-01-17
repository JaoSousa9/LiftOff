package com.liftOff.LiftOff.converters;

import com.liftOff.LiftOff.command.PassengerDto;
import com.liftOff.LiftOff.persistence.model.Passenger;
import org.springframework.core.convert.converter.Converter;

public class PassengerToPassengerDto implements Converter<Passenger, PassengerDto> {

    @Override
    public PassengerDto convert(Passenger source) {
        return null;
    }

    @Override
    public <U> Converter<Passenger, U> andThen(Converter<? super PassengerDto, ? extends U> after) {
        return Converter.super.andThen(after);
    }

}
