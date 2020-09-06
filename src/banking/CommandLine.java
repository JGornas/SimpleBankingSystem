package banking;

public interface CommandLine {
    String CREATE_AN_ACCOUNT = "1. Create an account";
    String LOG_INTO_ACCOUNT = "2. Log into account";
    String EXIT = "0. Exit";
    String EXIT_MESSAGE = "Bye!";
    String INVALID_COMMAND = "Invalid command!";

    String BALANCE_AMOUNT = "Balance:";
    String BALANCE = "1. Balance";
    String LOG_OUT = "2. Log out";
    String LOGGED_IN = "You have successfully logged in!";
    String LOGGED_OUT = "You have successfully logged out!";

    void start();
}
