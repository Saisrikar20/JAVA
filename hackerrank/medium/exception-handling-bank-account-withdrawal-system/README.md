# Exception Handling - Bank Account Withdrawal System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A bank provides a simple system where customers can withdraw money from their accounts. For security reasons, the bank needs to enforce a minimum balance requirement of ₹1000 in each account. If a withdrawal request would leave the account balance below this minimum, an exception should be raised, and the transaction should be denied. The program should handle this situation by throwing an exception and providing a clear error message.

Write a Java program that:

- Prompts the user to enter their account balance and the amount they want to withdraw.
- Checks if the withdrawal is possible without violating the minimum balance requirement of ₹1000.
- If the withdrawal amount would leave the account balance below ₹1000, the program should throw a custom exception, InsufficientBalanceException.
- Catch this exception and display an error message: Error: Withdrawal denied. Minimum balance of ₹1000 must be maintained.
- If the withdrawal is successful, display the remaining balance.

 **Input Format** 

- Initial account balance (double).
- Amount to withdraw (double).

 **Constraints** 

NA

 **Output Format** 

- If the withdrawal is valid, display the remaining balance.
- If the withdrawal violates the minimum balance, display an error message.

 **Sample Input 0** 

```
2500
1600

```

 **Sample Output 0** 

```
Enter your account balance: 
Enter amount to withdraw: 
Error: Withdrawal denied. Minimum balance of Rs.1000 must be maintained.

```

 **Sample Input 1** 

```
4500
3000

```

 **Sample Output 1** 

```
Enter your account balance: 
Enter amount to withdraw: 
Transaction successful. Remaining balance: Rs.1500.00

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T01:27:10.235Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/exception-handling-bank-account-withdrawal-system/problem)