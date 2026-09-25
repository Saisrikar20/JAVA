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
