# Exception Handling - String Splitter with Exception Handling

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A programmer is creating a tool that splits a user-input string based on the / (slash) symbol and displays each split part with its respective index. If the string length is too short (2 characters or fewer), a NullPointerException should be triggered to indicate that splitting is not applicable. Additionally, regardless of any exceptions, the program should execute a final cleanup message.

This exercise teaches the concepts of:

- Handling exceptions with custom conditions.
- Using a finally block to execute code unconditionally.

Write a Java program that:

- Prompts the user to enter a string.
- If the string length is greater than 2, calls a user-defined method splitString() to split the string by /.
- Displays each split part with its index in the format Splitted string at index X is: Y.
- If the string length is 2 or less, throws a NullPointerException.
- Regardless of any exception occurrence, executes a finally block to print "Inside finally block".

 **Input Format** 

A single string (containing words separated by /).

 **Constraints** 

NA

 **Output Format** 

- If the string length is greater than 2, output each part of the split string with its index.
- If the string length is 2 or less, output a NullPointerException message.
- Output "Inside finally block" in all cases.

 **Sample Input 0** 

```
Java/Programming/Language

```

 **Sample Output 0** 

```
Enter a string: Splitted string at index 0 is: Java
Splitted string at index 1 is: Programming
Splitted string at index 2 is: Language
Inside finally block

```

 **Sample Input 1** 

```
Hi

```

 **Sample Output 1** 

```
Enter a string: Exception: java.lang.NullPointerException: String length is too short to split.
Inside finally block

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T01:14:29.559Z  

```java
import java.util.Scanner;

public class Solution {
    static void splitString(String s) {
        String[] parts = s.split("/");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("Splitted string at index " + i + " is: " + parts[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        try {
            if (s.length() <= 2) {
                throw new NullPointerException("String length is too short to split.");
            }
            splitString(s);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e);
        } finally {
            System.out.println("Inside finally block");
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/exception-handling-string-splitter-with-exception-handling/problem)