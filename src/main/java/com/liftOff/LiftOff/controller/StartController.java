package com.liftOff.LiftOff.controller;

import com.liftOff.LiftOff.view.Messages;

import java.util.Map;

public class StartController extends AbstractController {

    private Controller nextController;
    private Map<Integer, Controller> startMap;


    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }



    public void startSelection(int option) {

        if (!startMap.containsKey(option)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        startMap.get(option).init();
        init();
    }

    public void setStartMap(Map<Integer, Controller> startMap) {
        this.startMap = startMap;
    }



}
