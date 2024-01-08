package com.liftOff.LiftOff.view;

public enum StartOptions {

    LOGIN(1, Messages.LOGIN_MESSAGE),
    SIGN_IN(2, Messages.SIGN_IN_MESSAGE);

    private int option;
    private String message;

    StartOptions(int option, String message) {
        this.option = option;
        this.message = message;
    }

    public int getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }

    public static String[] getMessages() {

        String[] messages = new String[values().length];

        for(StartOptions option : values()) {
            messages[option.getOption() -1] = option.getMessage();
        }

        return messages;
    }
}
