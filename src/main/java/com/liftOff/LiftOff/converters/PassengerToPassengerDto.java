package com.liftOff.LiftOff.converters;

import com.liftOff.LiftOff.command.PassengerDto;
import com.liftOff.LiftOff.persistence.model.Passenger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PassengerToPassengerDto implements Converter<Passenger, PassengerDto> {

    @Override
    public PassengerDto convert(Passenger passenger) {

        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setId(passenger.getId());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setLastName(passenger.getLastName());
        passengerDto.setEmail(passenger.getEmail());
        passengerDto.setUsername(passenger.getUsername());
        passengerDto.setPassword(passenger.getPassword());
        passengerDto.setPhoneNumber(passenger.getPhoneNumber());
        
        return passengerDto;
    }


}
