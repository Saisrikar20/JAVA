# Inheritance - Cricket Squad Information System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In this Cricket Squad Information System, we aim to manage information about different players in a cricket team. The system allows users to enter details about various types of players, specifically Batsmen and Bowlers. The design uses hierarchical inheritance, where we have a base class called Player that captures common attributes of all players, and two derived classes, Batsman and Bowler, that inherit from Player and add their specific properties.

Program Specifications

Base Class: Player

Attributes:

- name: String (the name of the player)
- age: int (the age of the player)
- team: String (the team the player belongs to)

Methods:

- displayDetails(): Displays the player's name, age, and team.

Derived Class: Batsman

Additional Attributes:

- runsScored: int (total runs scored by the batsman)

Methods:

- displayBatsmanDetails(): Displays batsman-specific details along with the inherited player details.

Derived Class: Bowler

Additional Attributes:

- wicketsTaken: int (total wickets taken by the bowler)

Methods:

- displayBowlerDetails(): Displays bowler-specific details along with the inherited player details.

 **Input Format** 

- For Batsman: The user will be prompted to enter the name, age, team, and runs scored.
- For Bowler: The user will be prompted to enter the name, age, team, and wickets taken.

 **Constraints** 

NA

 **Output Format** 

The program will display the details of the entered batsman and bowler in a structured format, including both common and specific attributes.

 **Sample Input 0** 

```
Virat Kohli
35
India
12345
Jasprit Bumrah
30
India
120

```

 **Sample Output 0** 

```
Enter details for Batsman:
Name: Age: Team: Runs Scored: 
Enter details for Bowler:
Name: Age: Team: Wickets Taken: 
Batsman Details:
Name: Virat Kohli
Age: 35
Team: India
Runs Scored: 12345

Bowler Details:
Name: Jasprit Bumrah
Age: 30
Team: India
Wickets Taken: 120

```

 **Sample Input 1** 

```
Joe Root
33
England
10567
James Anderson
42
England
690

```

 **Sample Output 1** 

```
Enter details for Batsman:
Name: Age: Team: Runs Scored: 
Enter details for Bowler:
Name: Age: Team: Wickets Taken: 
Batsman Details:
Name: Joe Root
Age: 33
Team: England
Runs Scored: 10567

Bowler Details:
Name: James Anderson
Age: 42
Team: England
Wickets Taken: 690

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-12T14:57:20.116Z  

```java
import java.util.Scanner;

class Player {
    String name;
    int age;
    String team;

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Team: " + team);
    }
}

class Batsman extends Player {
    int runsScored;

    void displayBatsmanDetails() {
        System.out.println("Batsman Details:");
        displayDetails();
        System.out.println("Runs Scored: " + runsScored);
        System.out.println();
    }
}

class Bowler extends Player {
    int wicketsTaken;

    void displayBowlerDetails() {
        System.out.println("Bowler Details:");
        displayDetails();
        System.out.println("Wickets Taken: " + wicketsTaken);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Batsman batsman = new Batsman();
        System.out.println("Enter details for Batsman:");
        System.out.print("Name: ");
        batsman.name = sc.nextLine();
        System.out.print("Age: ");
        batsman.age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Team: ");
        batsman.team = sc.nextLine();
        System.out.print("Runs Scored: ");
        batsman.runsScored = Integer.parseInt(sc.nextLine().trim());
        System.out.println();

        Bowler bowler = new Bowler();
        System.out.println("Enter details for Bowler:");
        System.out.print("Name: ");
        bowler.name = sc.nextLine();
        System.out.print("Age: ");
        bowler.age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Team: ");
        bowler.team = sc.nextLine();
        System.out.print("Wickets Taken: ");
        bowler.wicketsTaken = Integer.parseInt(sc.nextLine().trim());
        System.out.println();

        batsman.displayBatsmanDetails();
        bowler.displayBowlerDetails();

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/inheritance-cricket-squad-information-system/problem)