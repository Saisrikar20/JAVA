# Exception Handling - Budget Planner for Monthly Expenses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Sam wants to create a simple budget planner to manage monthly expenses. The planner will take inputs for the estimated monthly income and expected expenses. Sam may occasionally enter non-numeric values by mistake, which would cause a NumberFormatException. To handle this, Sam’s budget planner needs to catch this exception, inform the user of the error, and prompt them to enter a valid number.

 **Problem Statement** 

Write a Java program that:

- Prompts the user to enter the estimated monthly income and expected monthly expenses.
- Calculates and displays the remaining balance by subtracting expenses from income.
- If the user enters a non-numeric value for income or expenses, handle the NumberFormatException and display an error message: Error: Please enter a valid numeric value.
- Re-prompt the user to enter valid values until they are correct.

 **Input Format** 

- Monthly income (string that should be convertible to a double).
- Monthly expenses (string that should be convertible to a double).

 **Constraints** 

NA

 **Output Format** 

- If both inputs are valid numbers, display the remaining balance after subtracting expenses from income.
- If an input is invalid, display an error message and re-prompt the user for valid input.

 **Sample Input 0** 

```
6000
3000

```

 **Sample Output 0** 

```
Enter your estimated monthly income: 
Enter your expected monthly expenses: 
Remaining balance: Rs.3000.00

```

 **Sample Input 1** 

```
4500
three thousand
2000

```

 **Sample Output 1** 

```
Enter your estimated monthly income: 
Enter your expected monthly expenses: 
Error: Please enter a valid numeric value.
Enter your expected monthly expenses: 
Remaining balance: Rs.2500.00

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T01:29:19.834Z  

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double income, expenses;

        while (true) {
            try {
                System.out.println("Enter your estimated monthly income: ");
                income = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric value.");
            }
        }

        while (true) {
            try {
                System.out.println("Enter your expected monthly expenses: ");
                expenses = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric value.");
            }
        }

        System.out.printf("Remaining balance: Rs.%.2f%n", income - expenses);
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/exception-handling-budget-planner-for-monthly-expenses/problem)