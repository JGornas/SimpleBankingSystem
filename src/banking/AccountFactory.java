package banking;

import java.util.Random;

public class AccountFactory {

    private static Long generateCardNumber() {
        Random generator = new Random();
        String cardNumber = "400000";
        while (cardNumber.length() < 15) {
            cardNumber = String.format("%s%s", cardNumber, generator.nextInt(9));
        }
        int controlNumber = calculateControlNumber(cardNumber);
        cardNumber = String.format("%s%s", cardNumber, controlNumber);
        return Long.parseLong(cardNumber);
    }
    private static int calculateControlNumber(String cardNumber) {
        int counter = 0;
        for (int i = 0; i < cardNumber.length(); i++){
            int number = cardNumber.charAt(i) - '0';
            if (i % 2 == 0) {
                number *= 2;
            }
            if (number > 9) {
                number -= 9;
            }
            counter += number;
        }
        return 10 - (counter % 10);
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
