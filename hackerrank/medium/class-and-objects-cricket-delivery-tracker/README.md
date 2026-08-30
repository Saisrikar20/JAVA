# Class and Objects - Cricket Delivery Tracker

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are tasked with developing a program for a cricket statistics application. The application tracks deliveries in a cricket match. Each delivery in cricket is associated with details such as the over number, ball number, number of runs scored, the batsman who faced the ball, the bowler who bowled the ball, and the non-striker at the other end. To model this, you will create a Delivery class to store the details of a particular delivery, and a Main class to test and display these details.

 **Program Specifications** 

Delivery Class:

- Private member variables: over, ball, runs, batsman, bowler, nonStriker.
- Constructors:
- Default constructor.
- Parameterized constructor to initialize all member variables.
- Getters for all member variables (no setters required as the values are initialized through the constructor).

Main Class:

- The main method will handle input and output.
- It will create an instance of Delivery using the parameterized constructor and print the details in the required format.

 **Input Format** 

The input will be provided in the following order:

- Enter the over: An integer value representing the over number.
- Enter the ball: An integer value representing the ball number within the over.
- Enter the runs: An integer value representing the number of runs scored in the delivery.
- Enter the batsman name: A string representing the name of the batsman facing the ball.
- Enter the bowler name: A string representing the name of the bowler delivering the ball.
- Enter the nonStriker name: A string representing the name of the non-striker (the other batsman at the crease).

 **Constraints** 

NA

 **Output Format** 

The output will be displayed in the following order:

- Over: The over number.
- Ball: The ball number.
- Runs: The number of runs scored.
- Batsman: The name of the batsman.
- Bowler: The name of the bowler.
- NonStriker: The name of the non-striker.

 **Sample Input 0** 

```
1
1
4
MS Dhoni
Dale Steyn
Suresh Raina

```

 **Sample Output 0** 

```
Enter the over
Enter the ball
Enter the runs
Enter the batsman name
Enter the bowler name
Enter the nonStriker name
Over: 1
Ball: 1
Runs: 4
Batsman: MS Dhoni
Bowler: Dale Steyn
NonStriker: Suresh Raina

```

 **Sample Input 1** 

```
3
5
6
Virat Kohli
Mitchell Starc
Rohit Sharma

```

 **Sample Output 1** 

```
Enter the over
Enter the ball
Enter the runs
Enter the batsman name
Enter the bowler name
Enter the nonStriker name
Over: 3
Ball: 5
Runs: 6
Batsman: Virat Kohli
Bowler: Mitchell Starc
NonStriker: Rohit Sharma

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:56:52.406Z  

```java
import java.util.*;

class Delivery {
    private int over;
    private int ball;
    private int runs;
    private String batsman;
    private String bowler;
    private String nonStriker;

    // Default constructor
    Delivery() {
    }

    // Parameterized constructor
    Delivery(int over, int ball, int runs, String batsman,
             String bowler, String nonStriker) {
        this.over = over;
        this.ball = ball;
        this.runs = runs;
        this.batsman = batsman;
        this.bowler = bowler;
        this.nonStriker = nonStriker;
    }

    // Getters
    int getOver() {
        return over;
    }

    int getBall() {
        return ball;
    }

    int getRuns() {
        return runs;
    }

    String getBatsman() {
        return batsman;
    }

    String getBowler() {
        return bowler;
    }

    String getNonStriker() {
        return nonStriker;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the over");
        int over = sc.nextInt();

        System.out.println("Enter the ball");
        int ball = sc.nextInt();

        System.out.println("Enter the runs");
        int runs = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter the batsman name");
        String batsman = sc.nextLine();

        System.out.println("Enter the bowler name");
        String bowler = sc.nextLine();

        System.out.println("Enter the nonStriker name");
        String nonStriker = sc.nextLine();

        Delivery delivery = new Delivery(
            over, ball, runs, batsman, bowler, nonStriker
        );

        System.out.println("Over: " + delivery.getOver());
        System.out.println("Ball: " + delivery.getBall());
        System.out.println("Runs: " + delivery.getRuns());
        System.out.println("Batsman: " + delivery.getBatsman());
        System.out.println("Bowler: " + delivery.getBowler());
        System.out.println("NonStriker: " + delivery.getNonStriker());
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-cricket-delivery-tracker/problem)