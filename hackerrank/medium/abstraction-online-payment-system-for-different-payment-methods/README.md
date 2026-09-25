# Abstraction - Online Payment System for Different Payment Methods

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In an online shopping platform, customers have multiple payment options, such as credit card, debit card, and digital wallets. To process these payments, each payment method has unique details and processes, but they all follow a general approach to initiate a payment. By using abstraction, we can define a general payment class and specific implementations for each payment method.

Program Specifications

Abstract Class: Payment

Protected Attributes:

- double amount

Constructor:

- Initializes the amount attribute.

Abstract Method:

- void makePayment(): Abstract method that will be overridden to specify the process for each payment type.

Subclasses:

- CreditCardPayment: Implements makePayment() to specify the process for credit card payments.
- DebitCardPayment: Implements makePayment() to specify the process for debit card payments.
- DigitalWalletPayment: Implements makePayment() to specify the process for digital wallet payments.

Class: PaymentSystem

- In the main() method, prompt the user to input the payment method, amount, and additional payment-specific information.
- Based on the chosen payment method, create an instance of the appropriate subclass.
- Call the makePayment() method to process the payment.

 **Input Format** 

- The user inputs the payment method (credit card, debit card, or digital wallet).
- The user enters the payment amount and, depending on the payment method, specific details (e.g., card number, wallet ID).

 **Constraints** 

NA

 **Output Format** 

The program displays confirmation with the amount and method of payment.

 **Sample Input 0** 

```
1
250.00
4321-8765-5678-1234
456

```

 **Sample Output 0** 

```
Select payment method:
1. Credit Card
2. Debit Card
3. Digital Wallet
Enter payment amount:
Enter credit card number:
Enter CVV:
Payment of $250.0 processed using Credit Card.
Card Number: 4321-8765-5678-1234

```

 **Sample Input 1** 

```
2
100.50
5678-1234-7890-4321
9876

```

 **Sample Output 1** 

```
Select payment method:
1. Credit Card
2. Debit Card
3. Digital Wallet
Enter payment amount:
Enter debit card number:
Payment of $100.5 processed using Debit Card.
Card Number: 5678-1234-7890-4321

```

 **Sample Input 2** 

```
3
200.00
wallet5678

```

 **Sample Output 2** 

```
Select payment method:
1. Credit Card
2. Debit Card
3. Digital Wallet
Enter payment amount:
Enter wallet ID:
Payment of $200.0 processed using Digital Wallet.
Wallet ID: wallet5678

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T03:11:05.778Z  

```java
import java.util.Scanner;

abstract class Payment {
    protected double amount;
    Payment(double amount) {
        this.amount = amount;
    }
    abstract void makePayment();
}

class CreditCardPayment extends Payment {
    String cardNumber, cvv;
    CreditCardPayment(double amount, String cardNumber, String cvv) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
    void makePayment() {
        System.out.println("Payment of $" + amount + " processed using Credit Card.");
        System.out.println("Card Number: " + cardNumber);
    }
}

class DebitCardPayment extends Payment {
    String cardNumber;
    DebitCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }
    void makePayment() {
        System.out.println("Payment of $" + amount + " processed using Debit Card.");
        System.out.println("Card Number: " + cardNumber);
    }
}

class DigitalWalletPayment extends Payment {
    String walletId;
    DigitalWalletPayment(double amount, String walletId) {
        super(amount);
        this.walletId = walletId;
    }
    void makePayment() {
        System.out.println("Payment of $" + amount + " processed using Digital Wallet.");
        System.out.println("Wallet ID: " + walletId);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Digital Wallet");
        
        int choice = sc.nextInt();
        
        System.out.println("Enter payment amount:");
        double amount = sc.nextDouble();
        sc.nextLine();
        
        Payment payment;
        
        if(choice == 1) {
            System.out.println("Enter credit card number:");
            String cardNumber = sc.nextLine();
            
            System.out.println("Enter CVV:");
            String cvv = sc.nextLine();
            
            payment = new CreditCardPayment(amount, cardNumber, cvv);
        }
        else if(choice == 2) {
            System.out.println("Enter debit card number:");
            String cardNumber = sc.nextLine();
            
            payment = new DebitCardPayment(amount, cardNumber);
        }
        else {
            System.out.println("Enter wallet ID:");
            String walletId = sc.nextLine();
            
            payment = new DigitalWalletPayment(amount, walletId);
        }
        
        payment.makePayment();
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/abstraction-online-payment-system-for-different-payment-methods/problem)