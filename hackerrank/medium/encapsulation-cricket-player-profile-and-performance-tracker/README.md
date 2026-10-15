# Encapsulation - Cricket Player Profile and Performance Tracker

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A cricket team management system needs to store and manage player information. The details include each player’s name, age, role (e.g., Batsman, Bowler, All-Rounder), total matches played, and total runs scored. The management team wants a system where they can add player statistics, view player details, and securely manage sensitive player data by preventing direct access to the player’s attributes.

Program Specifications

Create a class named CricketPlayer:

Attributes (Private):

- String name: Stores the player’s name.
- int age: Stores the player’s age.
- String role: Stores the player’s role (e.g., Batsman, Bowler, All-Rounder).
- int matchesPlayed: Stores the total number of matches played by the player.
- int runsScored: Stores the total runs scored by the player.

Constructors: - Parameterized Constructor: Initializes all attributes when a new player is created.

Methods:

- public String getName(): Returns the player’s name.
- public int getAge(): Returns the player’s age.
- public String getRole(): Returns the player’s role.
- public int getMatchesPlayed(): Returns the number of matches played.
- public int getRunsScored(): Returns the runs scored by the player.
- public void addRuns(int runs): Adds runs to the player’s total (if runs is positive).
- public void addMatches(int matches): Increases matches played (if matches is positive).
- public void displayPlayerDetails(): Displays the player’s information in a structured format.

Create a class named Main:

- Purpose: Captures user input to create a CricketPlayer object, allows the addition of runs and matches, and displays the player’s details.

 **Input Format** 

The program should prompt the user to enter the following details:

1.Player’s Name (String).

2.Player’s Age (int).

3.Player’s Role (String).

4.Matches Played (int).

5.Runs Scored (int).

 **Constraints** 

NA

 **Output Format** 

Displays the player details as well as the updated statistics after adding runs or matches.

The format should be:

Player Details:

Name: [name]

Age: [age]

Role: [role]

Matches Played: [matchesPlayed]

Runs Scored: [runsScored]

If an invalid action is attempted (e.g., negative runs/matches), display: Invalid Input

 **Sample Input 0** 

```
Rohit Sharma
36
Batsman
250
9500
200
2

```

 **Sample Output 0** 

```
Enter the player's name:
Enter the player's age:
Enter the player's role:
Enter matches played:
Enter runs scored:
Player Details:
Name: Rohit Sharma
Age: 36
Role: Batsman
Matches Played: 250
Runs Scored: 9500
Enter runs to add:
Runs added successfully. Updated Runs Scored: 9700
Enter matches to add:
Matches added successfully. Updated Matches Played: 252
Player Details:
Name: Rohit Sharma
Age: 36
Role: Batsman
Matches Played: 252
Runs Scored: 9700

```

 **Sample Input 1** 

```
Rishabh Pant
25
Wicketkeeper
50
1500
-100
0

```

 **Sample Output 1** 

```
Enter the player's name:
Enter the player's age:
Enter the player's role:
Enter matches played:
Enter runs scored:
Player Details:
Name: Rishabh Pant
Age: 25
Role: Wicketkeeper
Matches Played: 50
Runs Scored: 1500
Enter runs to add:
Invalid Input
Enter matches to add:
Invalid Input
Player Details:
Name: Rishabh Pant
Age: 25
Role: Wicketkeeper
Matches Played: 50
Runs Scored: 1500

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:45:20.512Z  

```java
import java.util.*;

class CricketPlayer {
    private String name;
    private int age;
    private String role;
    private int matchesPlayed;
    private int runsScored;

    public CricketPlayer(String name, int age, String role,
                         int matchesPlayed, int runsScored) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void addRuns(int runs) {
        if (runs > 0) {
            runsScored += runs;
            System.out.println("Runs added successfully. Updated Runs Scored: " + runsScored);
        } else {
            System.out.println("Invalid Input");
        }
    }

    public void addMatches(int matches) {
        if (matches > 0) {
            matchesPlayed += matches;
            System.out.println("Matches added successfully. Updated Matches Played: " + matchesPlayed);
        } else {
            System.out.println("Invalid Input");
        }
    }

    public void displayPlayerDetails() {
        System.out.println("Player Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Role: " + role);
        System.out.println("Matches Played: " + matchesPlayed);
        System.out.println("Runs Scored: " + runsScored);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player's name:");
        String name = sc.nextLine();

        System.out.println("Enter the player's age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the player's role:");
        String role = sc.nextLine();

        System.out.println("Enter matches played:");
        int matchesPlayed = sc.nextInt();

        System.out.println("Enter runs scored:");
        int runsScored = sc.nextInt();

        CricketPlayer player = new CricketPlayer(
            name, age, role, matchesPlayed, runsScored
        );

        player.displayPlayerDetails();

        System.out.println("Enter runs to add:");
        int runs = sc.nextInt();
        player.addRuns(runs);

        System.out.println("Enter matches to add:");
        int matches = sc.nextInt();
        player.addMatches(matches);

        player.displayPlayerDetails();

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-cricket-player-profile-and-performance-tracker/problem)