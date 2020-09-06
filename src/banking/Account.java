package banking;

public class Account {
    private final Long cardNumber;
    private final String pin;
    private int balance;
    private boolean loggedIn;

    public Account(Long cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = 0;
        this.loggedIn = false;
    }

    int getBalance() {
        return balance;
    }

    String getPin() {
        return pin;
    }

    void login() {
        loggedIn = true;
    }
    void logout() {
        loggedIn = false;
    }

    boolean isLoggedIn() {
        return this.loggedIn;
    }
}
