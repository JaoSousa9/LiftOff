package com.liftOff.LiftOff.converters;

import com.liftOff.LiftOff.command.FlightDto;
import com.liftOff.LiftOff.persistence.model.Flight;
import org.springframework.core.convert.converter.Converter;

public class FlightToFlightDto implements Converter<Flight, FlightDto> {


    @Override
    public FlightDto convert(Flight flight) {

        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setFlightNumber(flight.getFlightNumber());
        flightDto.setOrigin(flight.getOrigin());
        flightDto.setDestiny(flight.getDestiny());
        flightDto.setDepartureHour(flight.getDepartureHour());
        flightDto.setArrivalHour(flight.getArrivalHour());
        flightDto.setDate(flight.getDate());
        flightDto.setDuration(flight.getDuration());
        flightDto.setPrice(flight.getPrice());
        flightDto.setECapacity(flight.geteCapacity());
        flightDto.setBCapacity(flight.getbCapacity());
        flightDto.setFCapacity(flight.getfCapacity());

        return flightDto;
    }

}
