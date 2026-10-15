# Abstraction - Digital Banking Account Tracker

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A bank provides different types of accounts to its customers, such as Savings and Current accounts. Each account type has its own rules for calculating interest and managing the minimum balance. The bank wants a system where basic account operations like checking balance, depositing, and withdrawing are handled, while the specific account rules (e.g., interest rates, minimum balance) are managed differently for each account type. This requires using abstraction to define common behaviors while allowing specific account types to implement their unique rules.

Program Specifications

Create an abstract class named BankAccount:

Attributes (Protected):

- String accountNumber: Stores the account number.
- double balance: Stores the balance in the account.

Constructors:

- Parameterized Constructor: Initializes accountNumber and balance.

Abstract Methods:

- public abstract void withdraw(double amount): Withdraws a specified amount.
- public abstract void deposit(double amount): Deposits a specified amount.
- public abstract double calculateInterest(): Calculates interest based on the account type.

Concrete Methods:

- public double getBalance(): Returns the current balance.
- public String getAccountNumber(): Returns the account number.

Create two subclasses SavingsAccount and CurrentAccount:

SavingsAccount:

- Implements calculateInterest() with a 4% interest rate.
- Minimum balance of $500 for withdrawals.

CurrentAccount:

- Implements calculateInterest() with no interest.
- Minimum balance of $1000 for withdrawals.

Create a class named Main:

- Purpose: Capture user input for account type, perform operations like deposit, withdraw, and display account details.

 **Input Format** 

- Account Type (Savings or Current).
- Account Number (String).
- Initial Deposit (Double).
- Deposit amount (Double).
- Withdrawal amount (Double).

 **Constraints** 

NA

 **Output Format** 

Displays account details, including:

Account Type, Account Number, Balance, Interest (if any).

 **Sample Input 0** 

```
Savings
SAV001
1000.00
500.00
200.00

```

 **Sample Output 0** 

```
Enter account type (Savings/Current):
Enter account number:
Enter initial deposit:
Enter deposit amount:
Enter withdrawal amount:
Account Details:
Account Type: Savings
Account Number: SAV001
Balance: $1300.0
Interest: $52.00

```

 **Sample Input 1** 

```
Current
CUR002
2000.00
1000.00
1500.00

```

 **Sample Output 1** 

```
Enter account type (Savings/Current):
Enter account number:
Enter initial deposit:
Enter deposit amount:
Enter withdrawal amount:
Account Details:
Account Type: Current
Account Number: CUR002
Balance: $1500.0

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:41:46.932Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/abstraction-digital-banking-account-tracker/problem)