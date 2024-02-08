package com.liftOff.LiftOff.controller.rest;

import com.liftOff.LiftOff.command.FlightDto;
import com.liftOff.LiftOff.converters.FlightDtoToFlight;
import com.liftOff.LiftOff.converters.FlightToFlightDto;
import com.liftOff.LiftOff.exceptions.FlightNotFoundException;
import com.liftOff.LiftOff.persistence.model.Flight;
import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.services.FlightService;
import com.liftOff.LiftOff.services.FlightServiceImp;
import org.hibernate.engine.jdbc.mutation.spi.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private FlightServiceImp flightService;

    private FlightToFlightDto flightToFlightDto;

    private FlightDtoToFlight flightDtoToFlight;

    @Autowired
    public void setFlightController(FlightServiceImp flightService) {
        this.flightService = flightService;
    }
    @Autowired
    public void setFlightToFlightDto(FlightToFlightDto flightToFlightDto) {
        this.flightToFlightDto = flightToFlightDto;
    }
    @Autowired
    public void setFlightDtoToFlight(FlightDtoToFlight flightDtoToFlight) {
        this.flightDtoToFlight = flightDtoToFlight;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FlightDto>> getFlights(){

        List<FlightDto> flights = flightService.getAllFlights().stream()
                .map(flight -> flightToFlightDto.convert(flight))
                .toList();
        

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{origin}/{destiny}/date/{date}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FlightDto>> getFlightDate(@PathVariable String destiny, @PathVariable String origin , @PathVariable String date) {

        try {
            List<Flight> flights = flightService.getFlightDate(destiny,origin,date);
            List<FlightDto> flightDTOs = flights.stream().map(flight -> flightToFlightDto.convert(flight)).toList();
            return new ResponseEntity<>(flightDTOs, HttpStatus.OK);
        } catch (FlightNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{origin}/{destiny}/{price}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FlightDto>> getFlightPrice(@PathVariable String destiny, @PathVariable String origin , @PathVariable Integer price) {

        System.out.println(destiny + " " + origin + " " + price);
        try {
            List<Flight> flights = flightService.getFlightPrice(destiny,origin,price);
            List<FlightDto> flightDTOs = flights.stream().map(flight -> flightToFlightDto.convert(flight)).toList();
            return new ResponseEntity<>(flightDTOs, HttpStatus.OK);
        } catch (FlightNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/add"
    )
    public ResponseEntity<?> addFlight(@Valid @RequestBody FlightDto flightDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Flight flight = flightDtoToFlight.convert(flightDto);
        flightService.save(flight);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/{id}"
    )
    public void deleteFlight(@PathVariable Integer id){
        flightService.delete(id);
    }
}
