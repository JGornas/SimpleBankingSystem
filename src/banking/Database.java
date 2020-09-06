package banking;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private final Map<Long, Account> accounts = new HashMap<>();

    public void createAccount(Long cardNumber, String pin) {
        accounts.put(cardNumber, new Account(cardNumber, pin));
    }

    public Account readAccount(Long cardNumber) {
        return accounts.get(cardNumber);
    }

    public boolean verifyPin(Long cardNumber, String pin) {
        Account account = accounts.getOrDefault(cardNumber, null);
        if (account == null) {
            return false;
        } else {
            return pin.equals(account.getPin());
        }
    }
}
