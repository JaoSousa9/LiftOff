package project.view;

public enum ChangeReservationOption {

    CHANGE_DATE(1, Messages.CHANGE_DATE_MESSAGE),
    CHANGE_DESTINY(2, Messages.CHANGE_DESTINY_MESSAGE),
    UPGRADE_SEAT(3, Messages.UPGRADE_SEAT_MESSAGE);

    private int option;
    private String message;

    ChangeReservationOption(int option, String message) {
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

        for(ChangeReservationOption option : values()) {
            messages[option.getOption() -1] = option.getMessage();
        }

        return messages;
    }
}
