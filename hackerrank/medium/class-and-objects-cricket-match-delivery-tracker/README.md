# Class and Objects - Cricket Match Delivery Tracker

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you're developing a Cricket Match Delivery Tracker system for a sports analytics company. This system helps track and display key details of each delivery (ball) bowled in a cricket match. For each delivery, the system records details like the over number, ball number, the number of runs scored, and the players involved (batsman, bowler, and non-striker).

This tool is useful for match commentators, statisticians, and coaches who want to log every ball and analyze the match in real-time. Your task is to develop an object-oriented program to input delivery details and display them in a user-friendly format.

 **Program Specifications** 

Class Name: Delivery

- Member Variables:
- Long Over (to store the over number).
- Long Ball (to store the ball number).
- Long Runs (to store the runs scored on that delivery).
- String Batsman (to store the name of the batsman).
- String Bowler (to store the name of the bowler).
- String NonStriker (to store the name of the non-striker).
- Method:
- void displayDeliveryDetails() (to display the details of the delivery).

Class Name: Main

- This class contains the main method to interact with the user and test the Delivery class.

 **Input Format** 

- The user is prompted to enter the over number (Long).
- Next, the user is asked to input the ball number (Long).
- The user is then prompted to enter the runs scored (Long).
- The user is asked to input the batsman’s name (String).
- The user is prompted to enter the bowler’s name (String).
- Finally, the user is asked to input the non-striker’s name (String).

 **Constraints** 

NA

 **Output Format** 

- The output should display the details of the delivery in a structured format, with each piece of information labeled (Over, Ball, Runs, Batsman, Bowler, NonStriker).
- Each label and its corresponding value should be separated by a colon (:) and a space.
- The output should be printed on separate lines.

 **Sample Input 0** 

```
1
1
0
Virat Kohli
Jasprit Bumrah
Rohit Sharma

```

 **Sample Output 0** 

```
Enter the over
Enter the ball
Enter the runs
Enter the batsman name
Enter the bowler name
Enter the nonStriker name
Delivery Details :
Over : 1
Ball : 1
Runs : 0
Batsman : Virat Kohli
Bowler : Jasprit Bumrah
NonStriker : Rohit Sharma

```

 **Sample Input 1** 

```
5
3
6
AB de Villiers
Pat Cummins
David Warner

```

 **Sample Output 1** 

```
Enter the over
Enter the ball
Enter the runs
Enter the batsman name
Enter the bowler name
Enter the nonStriker name
Delivery Details :
Over : 5
Ball : 3
Runs : 6
Batsman : AB de Villiers
Bowler : Pat Cummins
NonStriker : David Warner

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:37:05.345Z  

```java
import java.util.*;

class Delivery {
    Long Over;
    Long Ball;
    Long Runs;
    String Batsman;
    String Bowler;
    String NonStriker;

    void displayDeliveryDetails() {
        System.out.println("Delivery Details :");
        System.out.println("Over : " + Over);
        System.out.println("Ball : " + Ball);
        System.out.println("Runs : " + Runs);
        System.out.println("Batsman : " + Batsman);
        System.out.println("Bowler : " + Bowler);
        System.out.println("NonStriker : " + NonStriker);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Delivery delivery = new Delivery();

        System.out.println("Enter the over");
        delivery.Over = sc.nextLong();

        System.out.println("Enter the ball");
        delivery.Ball = sc.nextLong();

        System.out.println("Enter the runs");
        delivery.Runs = sc.nextLong();

        sc.nextLine();

        System.out.println("Enter the batsman name");
        delivery.Batsman = sc.nextLine();

        System.out.println("Enter the bowler name");
        delivery.Bowler = sc.nextLine();

        System.out.println("Enter the nonStriker name");
        delivery.NonStriker = sc.nextLine();

        delivery.displayDeliveryDetails();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-cricket-match-delivery-tracker/problem)