import java.util.Scanner;
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account balance: ");
        double balance = sc.nextDouble();
        System.out.println("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        try {
            if (balance - amount < 1000) {
                throw new InsufficientBalanceException("Withdrawal denied. Minimum balance of Rs.1000 must be maintained.");
            }
            System.out.printf("Transaction successful. Remaining balance: Rs.%.2f%n", balance - amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
