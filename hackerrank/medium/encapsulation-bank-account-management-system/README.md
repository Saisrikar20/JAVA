# Encapsulation - Bank Account Management System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A bank wants a system to manage customer bank accounts. To maintain security, account details such as account number, account holder’s name, account balance, and account type should not be accessible or modifiable directly. Only authorized methods should be able to view or update the balance. This is achieved by encapsulating the data within a BankAccount class and providing secure access through getter and setter methods.

Program Specifications

Create a class named BankAccount: Attributes (Private):

- String accountNumber: Stores the bank account number.
- String accountHolderName: Stores the account holder's name.
- double balance: Stores the account balance.
- String accountType: Stores the type of account (e.g., "Savings" or "Checking").

Constructors: - Parameterized Constructor: Initializes all attributes when a new account is created.

Methods:

- public String getAccountNumber(): Returns the account number.
- public String getAccountHolderName(): Returns the account holder’s name.
- public String getAccountType(): Returns the account type.
- public double getBalance(): Returns the current balance.
- public void deposit(double amount): Allows adding money to the balance (if amount is positive).
- public void withdraw(double amount): Allows withdrawing money from the balance (if amount is positive and does not exceed the balance).
- public void displayAccountDetails(): Displays the account’s information in a structured format.

Create a class named Main:

- Purpose: Captures user input to create a BankAccount object, allows deposits, withdrawals, and displays the account’s details.

 **Input Format** 

The program should prompt the user to enter the following details:

1.Account Number (String).

2.Account Holder's Name (String).

3.Initial Balance (double).

4.Account Type (String).

 **Constraints** 

NA

 **Output Format** 

Displays the account details as well as the balance after any deposit or withdrawal. The format should be:

Account Details:

Account Number: [accountNumber]

Account Holder Name: [accountHolderName]

Account Type: [accountType]

Balance: $[balance]

If an invalid transaction is attempted (e.g., negative deposit/withdrawal or withdrawal exceeding balance), display:

Invalid Transaction

 **Sample Input 0** 

```
1234567890
John Doe
500.0
Savings
200.0
150.0

```

 **Sample Output 0** 

```
Enter the account number:
Enter the account holder's name:
Enter the initial balance:
Enter the account type:
Account Details:
Account Number: 1234567890
Account Holder Name: John Doe
Account Type: Savings
Balance: $500.0
Enter deposit amount:
Deposit Successful. Updated Balance: $700.0
Enter withdrawal amount:
Withdrawal Successful. Updated Balance: $550.0
Account Details: 
Account Number: 1234567890
Account Holder Name: John Doe
Account Type: Savings
Balance: $550.0

```

 **Sample Input 1** 

```
9876543210
Jane Smith
1000.0
Checking
 -50.0
200.0

```

 **Sample Output 1** 

```
Enter the account number:
Enter the account holder's name:
Enter the initial balance:
Enter the account type:
Account Details:
Account Number: 9876543210
Account Holder Name: Jane Smith
Account Type: Checking
Balance: $1000.0
Enter deposit amount:
Invalid Transaction
Enter withdrawal amount:
Withdrawal Successful. Updated Balance: $800.0
Account Details:
Account Number: 9876543210
Account Holder Name: Jane Smith
Account Type: Checking
Balance: $800.0

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:44:00.170Z  

```java
import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;

    public BankAccount(String accountNumber, String accountHolderName,
                       double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful. Updated Balance: $" + balance);
        } else {
            System.out.println("Invalid Transaction");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful. Updated Balance: $" + balance);
        } else {
            System.out.println("Invalid Transaction");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the account number:");
        String accountNumber = sc.next();

        sc.nextLine();
        System.out.println("Enter the account holder's name:");
        String accountHolderName = sc.nextLine();

        System.out.println("Enter the initial balance:");
        double initialBalance = sc.nextDouble();

        sc.nextLine();
        System.out.println("Enter the account type:");
        String accountType = sc.nextLine();

        BankAccount account = new BankAccount(
            accountNumber, accountHolderName, initialBalance, accountType
        );

        account.displayAccountDetails();

        System.out.println("Enter deposit amount:");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        System.out.println("Enter withdrawal amount:");
        double withdrawalAmount = sc.nextDouble();
        account.withdraw(withdrawalAmount);

        System.out.println("Account Details:");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder Name: " + account.getAccountHolderName());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Balance: $" + account.getBalance());

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-bank-account-management-system/problem)