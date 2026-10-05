# Polymorphism - Cricket Match Delivery Tracking System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In this scenario, we will develop a Cricket Match Delivery Tracking System that allows users to log and display details about specific deliveries during a cricket match. The system will utilize method overloading to handle different aspects of a delivery, such as player details (bowler and batsman) and run details.

Program Specifications

Class: Delivery

Methods:

- void displayDeliveryDetails(String bowler, String batsman): Displays the last names of the bowler and batsman for a particular delivery.
- void displayDeliveryDetails(Long runs): Displays run details for that delivery and indicates if it's a boundary or a six based on the runs scored.

Class: Main

Methods:

- public static void main(String[] args): Contains the menu-driven interface to test the Delivery class.

 **Input Format** 

- The user can choose to log player details (bowler and batsman) or run details.
- The user inputs names and run values as specified.

 **Constraints** 

NA

 **Output Format** 

The system will display the last names of the bowler and batsman or the run details based on user input.

 **Sample Input 0** 

```
1
Ravichandran Ashwin
Virat Kohli

```

 **Sample Output 0** 

```
Menu
1. Player details of the delivery
2. Run details of the delivery
Enter the bowler name: 
Enter the batsman name: 
Player details of the delivery:
Bowler: Ashwin
Batsman: Kohli

```

 **Sample Input 1** 

```
2
6

```

 **Sample Output 1** 

```
Menu
1. Player details of the delivery
2. Run details of the delivery
Enter the number of runs: 
Number of runs scored in the delivery: 6
It is a Sixer.

```

 **Sample Input 2** 

```
2
4

```

 **Sample Output 2** 

```
Menu
1. Player details of the delivery
2. Run details of the delivery
Enter the number of runs: 
Number of runs scored in the delivery: 4
It is a boundary.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T02:58:50.312Z  

```java
import java.util.*;
class Delivery {
    void displayDeliveryDetails(String bowler,String batsman) {
        String b=bowler.substring(bowler.lastIndexOf(" ")+1);
        String bat=batsman.substring(batsman.lastIndexOf(" ")+1);
        System.out.println("Player details of the delivery:");
        System.out.println("Bowler: "+b);
        System.out.println("Batsman: "+bat);
    }
    void displayDeliveryDetails(Long runs) {
        System.out.println("Number of runs scored in the delivery: "+runs);
        if(runs==6)
        System.out.println("It is a Sixer.");
        else if(runs==4)
        System.out.println("It is a boundary.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Delivery d=new Delivery();
        System.out.println("Menu");
        System.out.println("1. Player details of the delivery");
        System.out.println("2. Run details of the delivery");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1) {
            System.out.println("Enter the bowler name: ");
            String bowler=sc.nextLine();
            System.out.println("Enter the batsman name: ");
            String batsman=sc.nextLine();
            d.displayDeliveryDetails(bowler,batsman);
        }
        else if(choice==2) {
            System.out.println("Enter the number of runs: ");
            Long runs=sc.nextLong();
            d.displayDeliveryDetails(runs);
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/polymorphism-cricket-match-delivery-tracking-system/problem)