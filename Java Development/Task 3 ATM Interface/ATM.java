import java.util.Scanner;

public class ATM {
private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    public void start() {

        Account account = login();

        if (account == null) {

            System.out.println("\nAccess denied.");
            System.out.println("ATM session terminated.");

            return;
        }

        System.out.println("\nLogin successful!");
        System.out.println("Welcome, " + account.getUserId());

        showMenu(account);
    }

    private Account login() {

        System.out.println("================================");
        System.out.println("          ATM SYSTEM");
        System.out.println("================================");

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.print("\nEnter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            Account account = bank.login(userId, pin);

            if (account != null) {
                return account;
            }

            System.out.println("Invalid User ID or PIN.");

            System.out.println(
                    "Attempts remaining: " + (3 - attempt)
            );
        }

        return null;
    }

    private void showMenu(Account account) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("           MAIN MENU");
            System.out.println("================================");

            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");

            System.out.print("\nEnter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    showTransactionHistory(account);
                    break;

                case "2":
                    withdraw(account);
                    break;

                case "3":
                    deposit(account);
                    break;

                case "4":
                    transfer(account);
                    break;

                case "5":
                    showBalance(account);
                    break;

                case "6":

                    System.out.println(
                            "\nThank you for using the ATM."
                    );

                    System.out.println("Goodbye!");

                    return;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }

    private void showTransactionHistory(Account account) {

        System.out.println(
                "\n---------- Transaction History ----------"
        );

        if (account.getTransactions().isEmpty()) {

            System.out.println("No transactions available.");

            return;
        }

        for (Transaction transaction : account.getTransactions()) {

            System.out.println(transaction);
        }
    }

    private void withdraw(Account account) {

        System.out.print("\nEnter withdrawal amount: ");

        double amount = readAmount();

        if (amount <= 0) {

            System.out.println("Invalid amount.");

            return;
        }

        if (account.withdraw(amount)) {

            account.addTransaction(
                    new Transaction(
                            "WITHDRAW",
                            amount,
                            "Cash withdrawal"
                    )
            );

            System.out.println("Withdrawal successful!");

            System.out.println(
                    "Remaining balance: ₹"
                    + String.format(
                            "%.2f",
                            account.getBalance()
                    )
            );

        } else {

            System.out.println("Insufficient Funds.");
        }
    }

    private void deposit(Account account) {

        System.out.print("\nEnter deposit amount: ");

        double amount = readAmount();

        if (amount <= 0) {

            System.out.println("Invalid amount.");

            return;
        }

        if (account.deposit(amount)) {

            account.addTransaction(
                    new Transaction(
                            "DEPOSIT",
                            amount,
                            "Cash deposit"
                    )
            );

            System.out.println("Deposit successful!");

            System.out.println(
                    "Current balance: ₹"
                    + String.format(
                            "%.2f",
                            account.getBalance()
                    )
            );
        }
    }

    private void transfer(Account account) {

        System.out.print(
                "\nEnter recipient account ID: "
        );

        String recipientId = scanner.nextLine();

        Account recipient =
                bank.findAccountById(recipientId);

        if (recipient == null) {

            System.out.println(
                    "Recipient account not found."
            );

            return;
        }

        if (recipient == account) {

            System.out.println(
                    "You cannot transfer to the same account."
            );

            return;
        }

        System.out.print(
                "Enter transfer amount: "
        );

        double amount = readAmount();

        if (amount <= 0) {

            System.out.println("Invalid amount.");

            return;
        }

        if (account.withdraw(amount)) {

            recipient.deposit(amount);

            account.addTransaction(
                    new Transaction(
                            "TRANSFER",
                            amount,
                            "Transferred to "
                                    + recipient.getAccountId()
                    )
            );

            recipient.addTransaction(
                    new Transaction(
                            "RECEIVED",
                            amount,
                            "Received from "
                                    + account.getAccountId()
                    )
            );

            System.out.println(
                    "Transfer successful!"
            );

            System.out.println(
                    "Remaining balance: ₹"
                    + String.format(
                            "%.2f",
                            account.getBalance()
                    )
            );

        } else {

            System.out.println("Insufficient Funds.");
        }
    }

    private void showBalance(Account account) {

        System.out.println(
                "\nCurrent Balance: ₹"
                + String.format(
                        "%.2f",
                        account.getBalance()
                )
        );
    }

    private double readAmount() {

        try {

            return Double.parseDouble(
                    scanner.nextLine()
            );

        } catch (NumberFormatException e) {

            return -1;
        }
    }
}