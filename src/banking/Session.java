package banking;

import java.util.Scanner;

public class Session {
    public static void login(Database database) {
        String CARD_NUMBER = "Enter your card number:";
        String PIN = "Enter your PIN:";
        String INVALID_CREDENTIALS = "Wrong card number or PIN!";

        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s\n", CARD_NUMBER);
        Long cardNumber = Long.parseLong(scanner.nextLine());
        System.out.println(PIN);
        String pin = scanner.nextLine();

        if (database.verifyPin(cardNumber, pin)) {
            Account account = database.readAccount(cardNumber);
            account.login();
            CommandLine loggedMenu = new LoggedMenu(account);
            loggedMenu.start();
        } else {
            System.out.printf("\n%s\n\n", INVALID_CREDENTIALS);
        }
    }
}
