package com.liftOff.LiftOff.controller;

import com.liftOff.LiftOff.view.*;

public abstract class AbstractController implements Controller {

    protected View view;

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init() {
        view.show();
    }
}
