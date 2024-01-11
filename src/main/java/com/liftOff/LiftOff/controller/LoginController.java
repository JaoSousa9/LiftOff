package com.liftOff.LiftOff.controller;

import com.liftOff.LiftOff.persistence.model.Passenger;
import com.liftOff.LiftOff.view.Messages;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class LoginController extends AbstractController {

    private Controller nextController;
    private boolean authFailed;
    private EntityManager em;
    private Passenger passenger;


    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void onLogin(String username, String password) {

        if(getUsername(username) != null && isPassword(password)) {
            nextController.init();
            return;
        }

        authFailed = true;
        init();

    }

    public boolean isAuthFailed() {
        return authFailed;
    }


    private boolean isPassword(String password) {
       if (password.equals(passenger.getPassword())) {
           return true;
       }
       return false;
    }

    private Passenger getUsername(String username) {

        passenger = em.find(Passenger.class, username);
        if (passenger == null) {
            System.out.println(Messages.LOGIN_ERROR_MESSAGE);
            init();
        }
        return passenger;
    }

}
