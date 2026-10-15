# Interface - Player Management System for Sports AnalyticsIntInt

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a sports analytics application, it is crucial to manage statistics for different types of players in various sports. The application helps coaches, analysts, and sports enthusiasts track player performance and make informed decisions based on player statistics. This scenario involves creating a system where details for both cricket and hockey players can be managed using an abstract class and interface.

Program Specifications

Interface Creation:

- Create an interface named IPlayerStatistics with the method:

public void displayPlayerStatistics();

Base Class Implementation:

- Create an abstract class named Player.
- Include protected data members: String name String teamName Integer noOfMatches
- Include a constructor with the following arguments: name, teamName, noOfMatches.

Derived Class for Cricket Players:

- Create a class named CricketPlayer that extends the Player class.
- Include private data members: Long totalRunsScored Integer noOfWicketsTaken
- Include a constructor that takes totalRunsScored and noOfWicketsTaken as arguments.
- Implement the displayPlayerStatistics method to display cricket player details.

Derived Class for Hockey Players:

- Create a class named HockeyPlayer that extends the Player class.
- Include private data members: String position Integer noOfGoals
- Include a constructor that takes position and noOfGoals as arguments.
- Implement the displayPlayerStatistics method to display hockey player details.

Main Class:

- Create a Main class with a main method to display a menu, gather user input, and show player statistics.

 **Input Format** 

- Menu selection (1 for Cricket Player or 2 for Hockey Player)
- Player name (String)
- Team name (String)
- Number of matches played (Integer)
- Additional statistics (specific to the sport)

 **Constraints** 

NA

 **Output Format** 

Display player details in the specified format.

 **Sample Input 0** 

```
1
Virat Kohli
Royal Challengers Bangalore
120
4500
15

```

 **Sample Output 0** 

```
Menu
1. Cricket Player Details
2. Hockey Player Details
Enter choice: Enter player name: Enter team name: Enter number of matches played: Enter total runs scored: Enter total number of wickets taken: Player Details:
Player name: Virat Kohli
Team name: Royal Challengers Bangalore
No of matches: 120
Total runs scored: 4500
No of wickets taken: 15

```

 **Sample Input 1** 

```
2
Manpreet Singh
Punjab Warriors
55
Midfielder
12

```

 **Sample Output 1** 

```
Menu
1. Cricket Player Details
2. Hockey Player Details
Enter choice: Enter player name: Enter team name: Enter number of matches played: Enter the position: Enter total number of goals scored: Player Details:
Player name: Manpreet Singh
Team name: Punjab Warriors
No of matches: 55
Position: Midfielder
No of goals taken: 12

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:25:26.895Z  

```java
import java.util.*;

interface IPlayerStatistics {
    public void displayPlayerStatistics();
}

abstract class Player {
    protected String name;
    protected String teamName;
    protected Integer noOfMatches;

    public Player(String name, String teamName, Integer noOfMatches) {
        this.name = name;
        this.teamName = teamName;
        this.noOfMatches = noOfMatches;
    }
}

class CricketPlayer extends Player implements IPlayerStatistics {
    private Long totalRunsScored;
    private Integer noOfWicketsTaken;

    public CricketPlayer(String name, String teamName, Integer noOfMatches,
                         Long totalRunsScored, Integer noOfWicketsTaken) {
        super(name, teamName, noOfMatches);
        this.totalRunsScored = totalRunsScored;
        this.noOfWicketsTaken = noOfWicketsTaken;
    }

    public void displayPlayerStatistics() {
        System.out.println("Player Details:");
        System.out.println("Player name: " + name);
        System.out.println("Team name: " + teamName);
        System.out.println("No of matches: " + noOfMatches);
        System.out.println("Total runs scored: " + totalRunsScored);
        System.out.println("No of wickets taken: " + noOfWicketsTaken);
    }
}

class HockeyPlayer extends Player implements IPlayerStatistics {
    private String position;
    private Integer noOfGoals;

    public HockeyPlayer(String name, String teamName, Integer noOfMatches,
                        String position, Integer noOfGoals) {
        super(name, teamName, noOfMatches);
        this.position = position;
        this.noOfGoals = noOfGoals;
    }

    public void displayPlayerStatistics() {
        System.out.println("Player Details:");
        System.out.println("Player name: " + name);
        System.out.println("Team name: " + teamName);
        System.out.println("No of matches: " + noOfMatches);
        System.out.println("Position: " + position);
        System.out.println("No of goals taken: " + noOfGoals);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Cricket Player Details");
        System.out.println("2. Hockey Player Details");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter player name: ");
        String name = sc.nextLine();

        System.out.print("Enter team name: ");
        String teamName = sc.nextLine();

        System.out.print("Enter number of matches played: ");
        int noOfMatches = sc.nextInt();
        sc.nextLine();

        IPlayerStatistics player;

        if (choice == 1) {
            System.out.print("Enter total runs scored: ");
            long runs = sc.nextLong();

            System.out.print("Enter total number of wickets taken: ");
            int wickets = sc.nextInt();

            player = new CricketPlayer(
                name, teamName, noOfMatches, runs, wickets
            );

        } else if (choice == 2) {
            System.out.print("Enter the position: ");
            String position = sc.nextLine();

            System.out.print("Enter total number of goals scored: ");
            int goals = sc.nextInt();

            player = new HockeyPlayer(
                name, teamName, noOfMatches, position, goals
            );

        } else {
            sc.close();
            return;
        }

        player.displayPlayerStatistics();
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/interface-player-management-system-for-sports-analyticsintint/problem)