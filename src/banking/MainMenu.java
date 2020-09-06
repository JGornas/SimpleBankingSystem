package banking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu implements CommandLine {

    Map<String, Runnable> commands;

    public MainMenu(Database database) {
        commands = new HashMap<>();
        commands.put("1", () -> AccountFactory.newAccount(database));
        commands.put("2", () -> Session.login(database));
        commands.put("0", () -> {
            System.out.printf("\n%s\n\n", EXIT_MESSAGE);
            System.exit(0);
        });
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s\n%s\n%s\n", CREATE_AN_ACCOUNT, LOG_INTO_ACCOUNT, EXIT);
            String input = scanner.nextLine();
            commands.getOrDefault(input, () -> System.out.printf("\n%s\n\n", INVALID_COMMAND)).run();
        }
    }
}
