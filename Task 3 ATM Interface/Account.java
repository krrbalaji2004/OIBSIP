import java.util.ArrayList;

public class Account {

    private String accountId;
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transaction;
    public Account(String accountId, String userId, String pin, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        transaction = new ArrayList<>();
    }
    public String getAccountId() {
        return accountId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transaction;
    }

    public boolean checkPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }
public void addTransaction(Transaction transaction) {
    this.transaction.add(transaction);
}
}