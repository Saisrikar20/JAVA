# Interface - Player Statistics Management System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a sports management application, there is a need to keep track of players' statistics across various teams. This system allows sports analysts, coaches, and fans to view player performance details, making it easier to assess their contributions to the team. The application uses an interface to ensure that all player classes implement the required method for displaying statistics.

Program Specifications

Interface Creation:

- Create an interface named IPlayerStatistics with the method:

public void displayPlayerStatistics();

Class Implementation:

- Create a class named Player that implements the IPlayerStatistics interface.
- Include private data members: String name String teamName Integer noOfMatches Long totalRunsScored Integer noOfWicketsTaken

Include a constructor that initializes all the data members.

Implement the displayPlayerStatistics method to display the player details.

Main Class:

- Create a Main class with a main method to gather user input and display player statistics.

 **Input Format** 

- Player name (String)
- Team name (String)
- Number of matches played (Integer)
- Total runs scored (Long)
- Number of wickets taken (Integer)

 **Constraints** 

NA

 **Output Format** 

Display player details in the specified format.

 **Sample Input 0** 

```
Virat Kohli
Royal Challengers Bangalore
200
6000
4

```

 **Sample Output 0** 

```
Enter player name: Enter team name: Enter number of matches played: Enter total runs scored: Enter number of wickets taken: Player Details:
Player name: Virat Kohli
Team name: Royal Challengers Bangalore
No of matches: 200
Total runs scored: 6000
No of wickets taken: 4

```

 **Sample Input 1** 

```
MS Dhoni
Chennai Super Kings
175
4500
0

```

 **Sample Output 1** 

```
Enter player name: Enter team name: Enter number of matches played: Enter total runs scored: Enter number of wickets taken: Player Details:
Player name: MS Dhoni
Team name: Chennai Super Kings
No of matches: 175
Total runs scored: 4500
No of wickets taken: 0

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:30:45.904Z  

```java
import java.util.*;

interface IPlayerStatistics {
    public void displayPlayerStatistics();
}

class Player implements IPlayerStatistics {
    private String name;
    private String teamName;
    private Integer noOfMatches;
    private Long totalRunsScored;
    private Integer noOfWicketsTaken;

    public Player(String name, String teamName, Integer noOfMatches,
                  Long totalRunsScored, Integer noOfWicketsTaken) {
        this.name = name;
        this.teamName = teamName;
        this.noOfMatches = noOfMatches;
        this.totalRunsScored = totalRunsScored;
        this.noOfWicketsTaken = noOfWicketsTaken;
    }

    @Override
    public void displayPlayerStatistics() {
        System.out.println("Player Details:");
        System.out.println("Player name: " + name);
        System.out.println("Team name: " + teamName);
        System.out.println("No of matches: " + noOfMatches);
        System.out.println("Total runs scored: " + totalRunsScored);
        System.out.println("No of wickets taken: " + noOfWicketsTaken);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter player name: ");
        String name = sc.nextLine();

        System.out.print("Enter team name: ");
        String teamName = sc.nextLine();

        System.out.print("Enter number of matches played: ");
        int noOfMatches = sc.nextInt();

        System.out.print("Enter total runs scored: ");
        long totalRunsScored = sc.nextLong();

        System.out.print("Enter number of wickets taken: ");
        int noOfWicketsTaken = sc.nextInt();

        Player player = new Player(
            name, teamName, noOfMatches,
            totalRunsScored, noOfWicketsTaken
        );

        player.displayPlayerStatistics();

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/interface-player-statistics-management-system/problem)