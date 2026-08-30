# Class and Objects - Cricket Match Score Management System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are working on a project for a cricket score management system. One of the key features is to record and display details of each inning played in a cricket match. The data includes the team batting in that inning and the runs scored by the team. You need to implement this using object-oriented programming, where each inning's details are stored in an object. The system then prints out the details for both innings in a match.

 **Program Specifications** 

Class Name: Innings

- Member Variables:
- String battingTeam – Stores the name of the team batting in the inning.
- Long runs – Stores the total runs scored by the team in the inning.

Constructor:

- A 2-argument constructor that initializes battingTeam and runs.
- A default constructor (no arguments).

Main Class:

- Reads the details of two innings from user input using an array of objects.
- Prints the output in the main method without using getters and setters.

 **Input Format** 

- The first line contains the prompt: "Enter the values for Innings 1."
- The second line contains the prompt: "Enter the BattingTeam," followed by the user input for the first inning's batting team (e.g., RCB).
- The third line contains the prompt: "Enter the runs scored," followed by the user input for the first inning's runs (e.g., 190).
- The fourth line contains the prompt: "Enter the values for Innings 2."
- The fifth line contains the prompt: "Enter the BattingTeam," followed by the user input for the second inning's batting team (e.g., CSK).
- The sixth line contains the prompt: "Enter the runs scored," followed by the user input for the second inning's runs (e.g., 190).

 **Constraints** 

NA

 **Output Format** 

- The first line of the output contains "Innings 1 Details".
- The second line contains "BattingTeam: " followed by the batting team name for the first inning (e.g., "RCB").
- The third line contains "Runs scored: " followed by the runs scored by the first inning's team (e.g., 190).
- The fourth line of the output contains "Innings 2 Details".
- The fifth line contains "BattingTeam: " followed by the batting team name for the second inning (e.g., "CSK").
- The sixth line contains "Runs scored: " followed by the runs scored by the second inning's team (e.g., 190).

 **Sample Input 0** 

```
MI
180
KKR
175

```

 **Sample Output 0** 

```
Enter the values for Innings 1
Enter the BattingTeam
Enter the runs scored
Enter the values for Innings 2
Enter the BattingTeam
Enter the runs scored
Innings 1 Details
BattingTeam: MI
Runs scored: 180
Innings 2 Details
BattingTeam: KKR
Runs scored: 175

```

 **Sample Input 1** 

```
SRH
225
DC
220

```

 **Sample Output 1** 

```
Enter the values for Innings 1
Enter the BattingTeam
Enter the runs scored
Enter the values for Innings 2
Enter the BattingTeam
Enter the runs scored
Innings 1 Details
BattingTeam: SRH
Runs scored: 225
Innings 2 Details
BattingTeam: DC
Runs scored: 220

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T16:04:14.128Z  

```java
import java.util.*;

class Innings {
    String battingTeam;
    Long runs;

    // Default constructor
    Innings() {
    }

    // 2-argument constructor
    Innings(String battingTeam, Long runs) {
        this.battingTeam = battingTeam;
        this.runs = runs;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Innings[] innings = new Innings[2];

        System.out.println("Enter the values for Innings 1");

        System.out.println("Enter the BattingTeam");
        String team1 = sc.nextLine();

        System.out.println("Enter the runs scored");
        Long runs1 = sc.nextLong();
        sc.nextLine();

        innings[0] = new Innings(team1, runs1);

        System.out.println("Enter the values for Innings 2");

        System.out.println("Enter the BattingTeam");
        String team2 = sc.nextLine();

        System.out.println("Enter the runs scored");
        Long runs2 = sc.nextLong();

        innings[1] = new Innings(team2, runs2);

        System.out.println("Innings 1 Details");
        System.out.println("BattingTeam: " + innings[0].battingTeam);
        System.out.println("Runs scored: " + innings[0].runs);

        System.out.println("Innings 2 Details");
        System.out.println("BattingTeam: " + innings[1].battingTeam);
        System.out.println("Runs scored: " + innings[1].runs);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-cricket-match-score-management-system/problem)