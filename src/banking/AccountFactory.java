package banking;

import java.util.Random;

public class AccountFactory {

    private static Long generateCardNumber() {
        Random generator = new Random();
        String cardNumber = "400000";
        while (cardNumber.length() < 16) {
            cardNumber = String.format("%s%s", cardNumber, generator.nextInt(9));
        }
        return Long.parseLong(cardNumber);
    }
    private static String generatePin() {
        Random generator = new Random();
        String pin = "";
        while (pin.length() < 4) {
            pin = String.format("%s%s", pin, generator.nextInt(9));
        }
        return pin;
    }

    public static void newAccount(Database database) {
        Long cardNumber = generateCardNumber();
        String pin = generatePin();

        database.createAccount(cardNumber, pin);

        System.out.printf("\nYour card has been created\n" +
                          "Your card number:\n" +
                          "%s\n" +
                          "Your card Pin:\n" +
                          "%s\n\n", cardNumber, pin);
    }
}
