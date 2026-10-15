# Encapsulation - Cricket Match Analysis

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are working on an application that tracks the details of every ball delivered in a cricket match. For each delivery, you need to store the over number, ball number, batsman, bowler, and non-striker. You are required to implement this using object-oriented programming principles and ensure that the delivery details can be displayed in a formatted way. The program must have a Delivery class to hold the delivery details and a DeliveryBO class to manage and display the list of deliveries.

Program Specifications

Delivery Class:

Private member variables:

- Long Over
- Long ball
- String Batsman
- String bowler
- String NonStriker

Provides a 5-argument constructor to initialize these variables.

Getters and setters for the member variables using appropriate naming conventions.

Override the toString() method to format the delivery details as specified.

DeliveryBO Class:

- Contains a method displayAllDeliveryDetails(Delivery[] deliveryList) that prints the details of all deliveries passed in the array.

Main Class:

- Handles input from the user to create multiple Delivery objects and uses the DeliveryBO class to display the details of each delivery in the specified format.

 **Input Format** 

- Enter the number of deliveries: An integer representing the number of deliveries.
- Enter the over: A long integer representing the over number.
- Enter the ball: A long integer representing the ball number.
- Enter the batsman: A string representing the batsman's name.
- Enter the bowler: A string representing the bowler's name.
- Enter the non-striker: A string representing the non-striker's name.

 **Constraints** 

NA

 **Output Format** 

The details of each delivery formatted in the specified format:

Delivery -

Over:

Ball:

Batsman:

Bowler:

NonStriker:

 **Sample Input 0** 

```
2
1
1
Rohit
Starc
Rahul
1
2
Rohit
Starc
Rahul

```

 **Sample Output 0** 

```
Enter the number of deliveries
Enter the over
Enter the ball
Enter the batsman
Enter the bowler
Enter the nonStriker
Enter the over
Enter the ball
Enter the batsman
Enter the bowler
Enter the nonStriker
Delivery Details
Delivery -- 1
Over : 1
Ball : 1
Batsman : Rohit
Bowler : Starc
NonStriker : Rahul
Delivery -- 2
Over : 1
Ball : 2
Batsman : Rohit
Bowler : Starc
NonStriker : Rahul

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:52:54.620Z  

```java
import java.util.*;

class Delivery {
    private Long over;
    private Long ball;
    private String batsman;
    private String bowler;
    private String nonStriker;

    public Delivery(Long over, Long ball, String batsman,
                    String bowler, String nonStriker) {
        this.over = over;
        this.ball = ball;
        this.batsman = batsman;
        this.bowler = bowler;
        this.nonStriker = nonStriker;
    }

    public Long getOver() {
        return over;
    }

    public void setOver(Long over) {
        this.over = over;
    }

    public Long getBall() {
        return ball;
    }

    public void setBall(Long ball) {
        this.ball = ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(String nonStriker) {
        this.nonStriker = nonStriker;
    }

    @Override
    public String toString() {
        return "Over : " + over + "\n"
             + "Ball : " + ball + "\n"
             + "Batsman : " + batsman + "\n"
             + "Bowler : " + bowler + "\n"
             + "NonStriker : " + nonStriker;
    }
}

class DeliveryBO {
    public void displayAllDeliveryDetails(Delivery[] deliveryList) {
        System.out.println("Delivery Details");

        for (int i = 0; i < deliveryList.length; i++) {
            System.out.println("Delivery -- " + (i + 1));
            System.out.println(deliveryList[i]);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of deliveries");
        int n = sc.nextInt();

        Delivery[] deliveryList = new Delivery[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the over");
            Long over = sc.nextLong();

            System.out.println("Enter the ball");
            Long ball = sc.nextLong();
            sc.nextLine();

            System.out.println("Enter the batsman");
            String batsman = sc.nextLine();

            System.out.println("Enter the bowler");
            String bowler = sc.nextLine();

            System.out.println("Enter the nonStriker");
            String nonStriker = sc.nextLine();

            deliveryList[i] = new Delivery(
                over, ball, batsman, bowler, nonStriker
            );
        }

        DeliveryBO deliveryBO = new DeliveryBO();
        deliveryBO.displayAllDeliveryDetails(deliveryList);

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-cricket-match-analysis/problem)