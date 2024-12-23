import java.util.ArrayList;
import java.util.List;

public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private List<String> transactionLog; // Store transaction history

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactionLog = new ArrayList<>(); // Initialize the log
    }

    @Override
    public void Deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            transactionLog.add("Failed deposit: " + amount); // Log failed attempt
        } else {
            balance += amount;
            System.out.println("Deposited " + amount + " successfully.");
            transactionLog.add("Deposit: " + amount + " | New Balance: " + balance);
        }
    }

    @Override
    public double Withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            transactionLog.add("Failed withdrawal: " + amount); // Log failed attempt
            return 0;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " successfully.");
        transactionLog.add("Withdrawal: " + amount + " | New Balance: " + balance);
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }

    // Additional Method: Print transaction log
    public void PrintTransactionLog() {
        System.out.println("Transaction Log for Account " + accountNumber + ":");
        for (String log : transactionLog) {
            System.out.println(log);
        }
    }
}
