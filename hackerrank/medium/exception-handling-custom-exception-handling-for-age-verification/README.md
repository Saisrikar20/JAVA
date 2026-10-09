# Exception Handling - Custom Exception Handling for Age Verification

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A developer is tasked with creating a program that verifies a user's age for a certain application. The program should throw a custom exception if the user is under the required age of 18. It should handle this exception with a try-catch block. Regardless of whether an exception occurs, a finally block should execute to print a message indicating the end of the age verification process.

This exercise will teach you:

- How to create and throw custom exceptions.
- How to handle exceptions using try, catch, and finally blocks.

Write a Java program that:

- Prompts the user to enter their age.
- If the age is less than 18, throw a custom exception named AgeNotValidException.
- Use a try-catch block to catch the exception and display an appropriate message.
- If the age is valid (18 or older), print a success message.
- Include a finally block that executes regardless of whether an exception was caught.

 **Input Format** 

A single integer representing the user's age.

 **Constraints** 

NA

 **Output Format** 

- If the age is less than 18, output a message indicating that the age is not valid.
- If the age is valid, output a success message.
- Output a final message indicating the completion of the verification process in all cases.

 **Sample Input 0** 

```
17

```

 **Sample Output 0** 

```
Enter your age: 
Exception: Age is not valid. You must be at least 18 years old.
End of Age Verification Process.

```

 **Sample Input 1** 

```
18

```

 **Sample Output 1** 

```
Enter your age: 
Age verification successful. Welcome!
End of Age Verification Process.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T01:13:17.582Z  

```java
import java.util.Scanner;

class AgeNotValidException extends Exception {
    AgeNotValidException(String message) {
        super(message);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = sc.nextInt();

        try {
            if (age < 18) {
                throw new AgeNotValidException("Age is not valid. You must be at least 18 years old.");
            }
            System.out.println("Age verification successful. Welcome!");
        } catch (AgeNotValidException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("End of Age Verification Process.");
        }
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/exception-handling-custom-exception-handling-for-age-verification/problem)