package com.liftOff.LiftOff.controller.rest;

import com.liftOff.LiftOff.command.PassengerDto;
import com.liftOff.LiftOff.converters.PassengerDtoToPassenger;
import com.liftOff.LiftOff.converters.PassengerToPassengerDto;
import com.liftOff.LiftOff.exceptions.PassengerNotFoundException;
import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    private PassengerService passengerService;
    private PassengerDtoToPassenger passengerDtoToPassenger;
    private PassengerToPassengerDto passengerToPassengerDto;


    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Autowired
    public void setPassengerDtoToPassenger(PassengerDtoToPassenger passengerDtoToPassenger) {
        this.passengerDtoToPassenger = passengerDtoToPassenger;
    }

    @Autowired
    public void setPassengerToPassengerDto(PassengerToPassengerDto passengerToPassengerDto) {
        this.passengerToPassengerDto = passengerToPassengerDto;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PassengerDto> login(@RequestBody LoginRequest loginRequest) throws PassengerNotFoundException {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Passenger passenger = passengerService.getPassengerByUsername(username);

        if (passenger != null && password.equals(passenger.getPassword())) {
            PassengerDto passengerDto = passengerToPassengerDto.convert(passenger);
            return new ResponseEntity<>(passengerDto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/sign-up",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity addPassenger(@Valid @RequestBody PassengerDto passengerDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Passenger passenger = passengerDtoToPassenger.convert(passengerDto);
        passengerService.saveOrUpdate(passenger);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/edit/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity editPassenger(@Valid @RequestBody PassengerDto passengerDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        passengerDto.setId(id);
        Passenger passenger = passengerDtoToPassenger.convert(passengerDto);
        passengerService.saveOrUpdate(passenger);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity deletePassenger(@PathVariable Integer id) throws PassengerNotFoundException {

        passengerService.deletePassenger(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }


    // Inner class created to encapsulate login information for use with the @RequestBody annotation.
    // Using @RequestBody is important as it ensures the secure transmission of sensitive information.
    private static class LoginRequest {

        private String username;
        private String password;


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
