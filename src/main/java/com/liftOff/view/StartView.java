package com.liftOff.view;

import com.liftOff.controller.StartController;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class StartView extends AbstractView {

    private StartController startController;

    public void setStartController(StartController startController) {
        this.startController = startController;
    }

    @Override
    public void show() {
        showWelcome();
        showOptions();
    }

    private void showWelcome() {
        System.out.println(Messages.WELCOME_MESSAGE);
    }

    private void showOptions() {
        MenuInputScanner menu = new MenuInputScanner(StartOptions.getMessages());
        menu.setError(Messages.LOGIN_ERROR_MESSAGE);
        menu.setMessage(Messages.OPTION_MESSAGE);
        startController.startSelection(prompt.getUserInput(menu));
    }


}
