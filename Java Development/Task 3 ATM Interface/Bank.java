import java.util.HashMap;

public class Bank {

    private HashMap<String, Account> accounts;

    public Bank() {

        accounts = new HashMap<>();

        Account account1 =new Account("ACC1001", "user1", "1234", 10000);

        Account account2 = new Account("ACC1002", "user2", "5678", 5000);

        accounts.put(account1.getUserId(), account1);
        accounts.put(account2.getUserId(), account2);
    }

    public Account login(String userId, String pin) {

        Account account = accounts.get(userId);

        if (account != null && account.checkPin(pin)) {
            return account;
        }

        return null;
    }

    public Account findAccountById(String accountId) {

        for (Account account : accounts.values()) {

            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }
}