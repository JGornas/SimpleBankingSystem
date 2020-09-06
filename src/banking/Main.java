package banking;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        CommandLine mainMenu = new MainMenu(database);

        mainMenu.start();
    }
}
