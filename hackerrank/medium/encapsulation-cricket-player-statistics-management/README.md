# Encapsulation - Cricket Player Statistics Management

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine a simple cricket system where we need to store and manage a cricketer’s name, total runs, and total matches played. To ensure data security, we use encapsulation to keep these details private and allow access through public methods. The player's data should be updated and retrieved only through these methods.

Program Specifications

Create a class CricketPlayer with private fields:

- name (String)
- totalRuns (int)
- matchesPlayed (int)

Provide public getter and setter methods to:

- Get the player’s name, total runs, and matches played.
- Set the player’s name, total runs, and matches played.

 **Input Format** 

- The first input line will ask for the player's name as a string.
- The second input line will ask for the player's total runs as an integer.
- The third input line will ask for the number of matches played by the player as an integer.

 **Constraints** 

NA

 **Output Format** 

The program will output the cricket player details in the following format:

- The player's name.
- The total runs scored by the player.
- The number of matches played by the player.

 **Sample Input 0** 

```
Virat Kohli
12000
250

```

 **Sample Output 0** 

```
Enter Player Name:
Enter Total Runs:
Enter Matches Played:

Cricket Player Details:
Name: Virat Kohli
Total Runs: 12000
Matches Played: 250

```

 **Sample Input 1** 

```
Joe Root
8500
-50

```

 **Sample Output 1** 

```
Enter Player Name:
Enter Total Runs:
Enter Matches Played:

Cricket Player Details:
Name: Joe Root
Total Runs: 8500
Matches Played: -50

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:46:34.975Z  

```java
import java.util.*;

class CricketPlayer {
    private String name;
    private int totalRuns;
    private int matchesPlayed;

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public String getName() {
        return name;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CricketPlayer player = new CricketPlayer();

        System.out.println("Enter Player Name:");
        player.setName(sc.nextLine());

        System.out.println("Enter Total Runs:");
        player.setTotalRuns(sc.nextInt());

        System.out.println("Enter Matches Played:");
        player.setMatchesPlayed(sc.nextInt());

        System.out.println();
        System.out.println("Cricket Player Details:");
        System.out.println("Name: " + player.getName());
        System.out.println("Total Runs: " + player.getTotalRuns());
        System.out.println("Matches Played: " + player.getMatchesPlayed());

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-cricket-player-statistics-management/problem)