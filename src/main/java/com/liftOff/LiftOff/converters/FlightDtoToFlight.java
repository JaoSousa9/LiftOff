package com.liftOff.LiftOff.converters;

import com.liftOff.LiftOff.command.FlightDto;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class FlightDtoToFlight implements Converter<FlightDto, Flight> {

    private FlightService flightService;


    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public Flight convert(FlightDto flightDto) {

        Flight flight = (flightDto.getId() != null ? flightService.get(flightDto.getId()) : new Flight(flightDto.getFlightNumber(), flightDto.getOrigin(), flightDto.getDestiny(), flightDto.getDepartureHour(), flightDto.getArrivalHour(), flightDto.getDate(), flightDto.getDuration(), flightDto.getPrice(), flightDto.getECapacity(), flightDto.getBCapacity(), flightDto.getFCapacity()));

        return flight;

    }
    
}
