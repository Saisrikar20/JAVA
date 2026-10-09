# Exception Handling - Online Quiz Scoring System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

An online quiz platform allows students to take quizzes and receive scores based on their answers. After taking the quiz, students enter the total score they obtained. However, a score is only valid if it falls within the range of 0 to 100. If a score outside this range is entered, the system should throw a custom exception, InvalidScoreException, and prompt the student to enter a valid score.

The program should:

- Catch the invalid score exception and display an error message.
- Ensure all resources, such as the input scanner, are properly closed, regardless of whether the score is valid or invalid, by using a finally block.

Problem Statement

Write a Java program that:

- Prompts the user to enter their quiz score.
- Checks if the entered score is between 0 and 100.
- If the score is outside this range, throws an InvalidScoreException with an appropriate message.
- Catches this exception, displays the error message, and prompts the user to enter a valid score.
- Closes resources using a finally block to ensure proper cleanup, even if an exception occurs.

 **Input Format** 

Quiz score (integer).

 **Constraints** 

NA

 **Output Format** 

- If the score is valid, display a success message.
- If the score is invalid, display an error message and prompt for a valid score.
- Finally, display a confirmation message that resources have been closed.

 **Sample Input 0** 

```
105
85

```

 **Sample Output 0** 

```
Enter your quiz score: 
Error: Score must be between 0 and 100. Please enter a valid score.
Enter your quiz score: 
Your score of 85 has been recorded.
Resources have been closed.

```

 **Sample Input 1** 

```
50

```

 **Sample Output 1** 

```
Enter your quiz score: 
Your score of 50 has been recorded.
Resources have been closed.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T01:19:48.573Z  

```java
import java.util.Scanner;
class InvalidScoreException extends Exception {
    InvalidScoreException(String message) {
        super(message);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter your quiz score: ");
                int score = sc.nextInt();
                try {
                    if (score < 0 || score > 100) {
                        throw new InvalidScoreException("Score must be between 0 and 100. Please enter a valid score.");
                    }
                    System.out.println("Your score of " + score + " has been recorded.");
                    break;
                } catch (InvalidScoreException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                }
        } finally {
            sc.close();
            System.out.println("Resources have been closed.");
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/exception-handling-online-quiz-scoring-system/problem)