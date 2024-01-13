package com.liftOff.LiftOff.view;

import com.liftOff.LiftOff.controller.SignUpController;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class SignUpView extends AbstractView {

    private SignUpController signUpController;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;


    public void setSignInController(SignUpController signUpController) {
        this.signUpController = signUpController;
    }


    @Override
    public void show() {
        showFirstNamePrompt();
        showLastNamePrompt();
        showEmailPrompt();
        showPasswordPrompt();
        showUsernamePrompt();
    }

    private void showFirstNamePrompt() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.PASSENGER_FIRST_NAME);
        scanner.setError(Messages.SYSTEM_ERROR);
        firstName = prompt.getUserInput(scanner);
    }

    private void showLastNamePrompt() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.PASSENGER_LAST_NAME);
        scanner.setError(Messages.SYSTEM_ERROR);
        lastName = prompt.getUserInput(scanner);
    }

    private void showEmailPrompt() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.PASSENGER_EMAIL);
        scanner.setError(Messages.INVALID_EMAIL);
        email = prompt.getUserInput(scanner);
    }

    private void showUsernamePrompt() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.PASSENGER_USERNAME);
        scanner.setError(Messages.INVALID_USERNAME);
        username = prompt.getUserInput(scanner);
    }

    private void showPasswordPrompt() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.PASSENGER_PASSWORD);
        scanner.setError(Messages.SYSTEM_ERROR);
        password = prompt.getUserInput(scanner);
    }

}
