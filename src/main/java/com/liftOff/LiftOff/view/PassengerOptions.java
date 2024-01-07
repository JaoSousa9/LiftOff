package project.view;

public enum PassengerOptions {

    VIEW_RESERVATIONS(1, Messages.MENU_VIEW_RESERVATIONS),
    RESERVE_FLIGHT(2, Messages.MENU_RESERVE_FLIGHT),
    MAKE_PAYMENT(3, Messages.MENU_MAKE_PAYMENT),
    LOG_OUT(4, Messages.MENU_LOG_OUT);

    private int option;
    private String message;

    PassengerOptions(int option, String message) {
        this.option = option;
        this.message = message;
    }

    public Integer getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }

    public static String[] getMessages() {

        String[] messages = new String[values().length];

        for(PassengerOptions option : values()) {
            messages[option.getOption() - 1] = option.getMessage();
        }

        return messages;
    }
}
