package com.liftOff.LiftOff.controller;

import com.liftOff.LiftOff.persistence.model.Passenger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends AbstractController {

    private Controller nextController;
    private boolean authFailed;
    private EntityManager em;
    private Passenger passenger;
    private Controller startController;


    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void setStartController(Controller startController) {
        this.startController = startController;
    }

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void onLogin(String username, String password) {

        passenger = getUsername(username);

        if (passenger != null && isPassword(password)) {
            authFailed = false;
            nextController.init();
        } else {
            authFailed = true;
            startController.init();
        }
    }

    public boolean isAuthFailed() {
        return authFailed;
    }


    private boolean isPassword(String password) {
        return passenger != null && password.equals(passenger.getPassword());
    }

    private Passenger getUsername(String username) {

        try {
            return em.createQuery("SELECT p FROM Passenger p WHERE p.username = :username", Passenger.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
           // System.out.println(Messages.LOGIN_ERROR_MESSAGE);
            return null;
        }
    }


    @Override
    public void init() {

    }
}
