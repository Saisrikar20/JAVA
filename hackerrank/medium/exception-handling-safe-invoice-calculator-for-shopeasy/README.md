# Exception Handling - Safe Invoice Calculator for ShopEasy

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

ShopEasy, an online retailer, uses a simple internal application to calculate the price per item for each order. The application calculates the price per item by dividing the total price by the number of items ordered. During testing, the application encountered issues when the number of items ordered was zero, resulting in an ArithmeticException. To avoid application crashes and provide a smooth user experience, ShopEasy needs a solution that handles this exception gracefully.

Write a Java program to help ShopEasy’s team safely calculate the price per item. The program should:

- Prompt the user to enter the total price of the items.
- Prompt the user to enter the number of items.
- Display the price per item by dividing the total price by the number of items.
- If the number of items is zero, catch the ArithmeticException and display the message: Error: Number of items cannot be zero. Please enter a valid quantity.
- Allow the user to re-enter the number of items if they initially entered zero.

 **Input Format** 

- Total price of items (integer or decimal).
- Number of items (integer).

 **Constraints** 

NA

 **Output Format** 

- Display price per item if calculated successfully.
- Display an error message if an ArithmeticException is encountered and prompt the user to enter a valid quantity.

 **Sample Input 0** 

```
100
0
4

```

 **Sample Output 0** 

```
Enter the total price of the items: 
Enter the number of items: 
Error: Number of items cannot be zero. Please enter a valid quantity.
Enter the number of items: 
Price per item: 25.00

```

 **Sample Input 1** 

```
250.50
5

```

 **Sample Output 1** 

```
Enter the total price of the items: 
Enter the number of items: 
Price per item: 50.10

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T03:46:30.004Z  

```java

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total price of the items: ");
        double price = sc.nextDouble();

        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();

        while (true) {
            try {
                if (n == 0)
                    throw new ArithmeticException();

                System.out.printf("Price per item: %.2f%n", price / n);
                break;
            } catch (ArithmeticException e) {
                System.out.println("Error: Number of items cannot be zero. Please enter a valid quantity.");
                System.out.println("Enter the number of items: ");
                n = sc.nextInt();
            }
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/exception-handling-safe-invoice-calculator-for-shopeasy/problem)