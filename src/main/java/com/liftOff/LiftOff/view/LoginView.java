package com.liftOff.LiftOff.view;

import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import com.liftOff.LiftOff.controller.LoginController;
import com.liftOff.LiftOff.controller.StartController;

public class LoginView extends AbstractView {

    private LoginController loginController;
    private String username;
    private String password;


    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }


    @Override
    public void show() {

       showUsernamePrompt();
       showPasswordPrompt();
       loginController.onLogin(username, password);

    }

    private void showUsernamePrompt() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.PASSENGER_USERNAME);
        scanner.setError(Messages.LOGIN_ERROR_MESSAGE);
        username = prompt.getUserInput(scanner);
    }

    private void showPasswordPrompt() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.PASSENGER_PASSWORD);
        scanner.setError(Messages.LOGIN_FAILED_MESSAGE);
        password = prompt.getUserInput(scanner);
    }


}
