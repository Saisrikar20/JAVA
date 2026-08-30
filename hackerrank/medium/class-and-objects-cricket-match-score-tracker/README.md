# Class and Objects - Cricket Match Score Tracker

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are developing a Cricket Match Score Tracker application for a cricket organization. The application is designed to help scorekeepers input and track innings details for various matches. The goal is to easily record the batting team's name, the runs scored in an innings, and the inning number, which helps coaches, players, and fans keep track of the match's progress.

In this application, each inning is represented as an object that holds essential details, making it easier to manage and display information about the ongoing cricket match.

 **Program Specification** s

Class Name: Innings

- Member Variables:
- String number (to store the innings number).
- String battingTeam (to store the name of the batting team).
- Long runs (to store the runs scored by the batting team).
- Method:
- void displayInningsDetails() (to display the details of the innings).

Class Name: Main

- This class contains the main method to interact with the user and test the Innings class.

 **Input Format** 

- The user is prompted to enter the innings number (String).
- The user is then asked to input the batting team name (String).
- Finally, the user is prompted to enter the runs scored (Long).

 **Constraints** 

NA

 **Output Format** 

- The output displays the details of the innings in a structured format, with each piece of information labeled (Innings number, Batting Team, Runs scored).
- Each label and its corresponding value should be separated by a colon (:) and a space.
- The output should be printed on separate lines.

 **Sample Input 0** 

```
Firstinnings
CSK
200

```

 **Sample Output 0** 

```
Enter the innings number
Enter the BattingTeam
Enter the runs scored
Innings Details :
Innings number : Firstinnings
BattingTeam :CSK
Runs scored :200

```

 **Sample Input 1** 

```
Secondinnings
MI
150

```

 **Sample Output 1** 

```
Enter the innings number
Enter the BattingTeam
Enter the runs scored
Innings Details :
Innings number : Secondinnings
BattingTeam :MI
Runs scored :150

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:41:33.874Z  

```java
import java.util.*;

class Innings {
    String number;
    String battingTeam;
    Long runs;

    void displayInningsDetails() {
        System.out.println("Innings Details :");
        System.out.println("Innings number : " + number);
        System.out.println("BattingTeam :" + battingTeam);
        System.out.println("Runs scored :" + runs);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Innings innings = new Innings();

        System.out.println("Enter the innings number");
        innings.number = sc.nextLine();

        System.out.println("Enter the BattingTeam");
        innings.battingTeam = sc.nextLine();

        System.out.println("Enter the runs scored");
        innings.runs = sc.nextLong();

        innings.displayInningsDetails();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-cricket-match-score-tracker/problem)