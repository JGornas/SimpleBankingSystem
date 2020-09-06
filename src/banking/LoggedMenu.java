package banking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoggedMenu implements CommandLine {

    Map<String, Runnable> commands;
    Account account;

    public LoggedMenu(Account account) {
        commands = new HashMap<>();
        commands.put("1", () -> System.out.printf("\n%s %s\n", BALANCE_AMOUNT, account.getBalance()));
        commands.put("2", account::logout);
        commands.put("0", () -> {
            System.out.printf("\n%s\n\n", EXIT_MESSAGE);
            System.exit(0);
        });
        this.account = account;
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s\n", LOGGED_IN);
        while (account.isLoggedIn()) {
            System.out.printf("\n%s\n%s\n%s\n", BALANCE, LOG_OUT, EXIT);
            String input = scanner.nextLine();
            commands.getOrDefault(input, () -> System.out.printf("\n%s\n", INVALID_COMMAND)).run();
        }
        System.out.printf("\n%s\n\n", LOGGED_OUT);
    }
}
