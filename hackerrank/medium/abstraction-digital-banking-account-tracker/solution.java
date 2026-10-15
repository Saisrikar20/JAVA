import java.util.*;

abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
    public abstract double calculateInterest();

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= 500) {
            balance -= amount;
        }
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= 1000) {
            balance -= amount;
        }
    }

    public double calculateInterest() {
        return 0.0;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account type (Savings/Current):");
        String type = sc.next();

        System.out.println("Enter account number:");
        String accountNumber = sc.next();

        System.out.println("Enter initial deposit:");
        double initialDeposit = sc.nextDouble();

        System.out.println("Enter deposit amount:");
        double depositAmount = sc.nextDouble();

        System.out.println("Enter withdrawal amount:");
        double withdrawalAmount = sc.nextDouble();

        BankAccount account;

        if (type.equalsIgnoreCase("Savings")) {
            account = new SavingsAccount(accountNumber, initialDeposit);
        } else {
            account = new CurrentAccount(accountNumber, initialDeposit);
        }

        account.deposit(depositAmount);
        account.withdraw(withdrawalAmount);

        System.out.println("Account Details:");
        System.out.println("Account Type: " +
                (type.equalsIgnoreCase("Savings")
                        ? "Savings" : "Current"));
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: $" + account.getBalance());

        if (type.equalsIgnoreCase("Savings")) {
            System.out.printf("Interest: $%.2f%n",
                    account.calculateInterest());
        }

        sc.close();
    }
}
