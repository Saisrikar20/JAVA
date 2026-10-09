# Exception Handling - Student Grades Lookup System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A college wants to create a simple lookup system where students can check their grades for different subjects by entering a subject index number. The system holds a fixed number of subjects with corresponding grades stored in an array. However, if a student enters an index that is outside the bounds of the array, an ArrayIndexOutOfBoundsException occurs. To handle this, the system should catch the exception and display an appropriate error message.

Write a Java program that:

- Initializes an array of grades for a list of subjects.
- Prompts the user to enter the index of the subject for which they want to view the grade.
- Displays the grade for the chosen subject.
- If the entered index is out of bounds, catches the ArrayIndexOutOfBoundsException and displays an error message: Error: Invalid subject index. Please enter a number between 0 and last valid index.
- Allows the user to try again until a valid index is entered.

 **Input Format** 

- Number of subjects (integer).
- Grades for each subject (array of integers).
- Subject index to look up (integer).

 **Constraints** 

NA

 **Output Format** 

- If a valid index is entered, display the grade for the chosen subject.
- If an invalid index is entered, display an error message and prompt the user to try again.

 **Sample Input 0** 

```
4
75 84 92 68
1

```

 **Sample Output 0** 

```
Enter the number of subjects: 
Enter grades for each subject:
Enter the subject index to check grade: 
Grade for subject 1: 84

```

 **Sample Input 1** 

```
6
80 95 70 88 76 91
6
5

```

 **Sample Output 1** 

```
Enter the number of subjects: 
Enter grades for each subject:
Enter the subject index to check grade: 
Error: Invalid subject index. Please enter a number between 0 and 5.
Enter the subject index to check grade: 
Grade for subject 5: 91

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T01:28:27.443Z  

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        int n = sc.nextInt();

        int[] grades = new int[n];

        System.out.println("Enter grades for each subject:");
        for (int i = 0; i < n; i++) {
            grades[i] = sc.nextInt();
        }

        while (true) {
            System.out.println("Enter the subject index to check grade: ");
            int index = sc.nextInt();

            try {
                System.out.println("Grade for subject " + index + ": " + grades[index]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid subject index. Please enter a number between 0 and " + (n - 1) + ".");
            }
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/exception-handling-student-grades-lookup-system/problem)