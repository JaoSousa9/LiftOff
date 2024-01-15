package com.liftOff.LiftOff.controller;

import com.liftOff.LiftOff.persistence.dao.jpa.JpaPassengerDao;
import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.view.SignUpView;
import com.liftOff.LiftOff.view.View;

public class SignUpController extends AbstractController {

    private JpaPassengerDao jpaPassengerDao;
    private Controller nextController;
    private SignUpView signUpView;

    public void setJpaPassengerDao(JpaPassengerDao jpaPassengerDao) {
        this.jpaPassengerDao = jpaPassengerDao;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void setSignUpView(SignUpView signUpView) {
        this.signUpView = signUpView;
    }

    public void savePassenger() {
        jpaPassengerDao.saveOrUpdate(createPassenger());
    }

    private Passenger createPassenger() {
        Passenger passenger = new Passenger();
        passenger.setFirstName(signUpView.getFirstName());
        passenger.setLastName(signUpView.getLastName());
        passenger.setEmail(signUpView.getEmail());
        passenger.setUsername(signUpView.getUsername());
        passenger.setPassword(signUpView.getPassword());
        return passenger;
    }
}
