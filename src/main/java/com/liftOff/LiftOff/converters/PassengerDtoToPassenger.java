package com.liftOff.LiftOff.converters;

import com.liftOff.LiftOff.command.PassengerDto;
import com.liftOff.LiftOff.exceptions.PassengerNotFoundException;
import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.services.PassengerService;
import org.springframework.core.convert.converter.Converter;

public class PassengerDtoToPassenger implements Converter<PassengerDto, Passenger> {

    private PassengerService passengerService;


    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Override
    public Passenger convert(PassengerDto passengerDto) {

        Passenger passenger = (passengerDto.getId() != null ? passengerService.get(passengerDto.getId()) : new Passenger());

        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setUsername(passengerDto.getUsername());
        passenger.setPassword(passengerDto.getPassword());
        passenger.setPhoneNumber(passengerDto.getPhoneNumber());

        return passenger;
    }


}
