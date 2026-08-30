# Inheritance - Cricket Player Statistics System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The cricket association wants to keep track of both general player details and specific details about bowlers. The base class, Player, will store general information about all cricket players, while the derived class, Bowler, will add details specific to bowlers.

Program Specifications

Create a class named Player to store general cricket player information:

- String name: Name of the player.
- String team: Team of the player.
- int age: Age of the player.
- Include a method named displayPlayerInfo() to print the player's general information.

Create a class named Bowler that extends Player with additional attributes:

- int wicketsTaken: Number of wickets taken by the bowler.
- double bowlingAverage: The bowling average of the bowler.
- Include a method named displayBowlingStats() to print the bowler's specific statistics.

Create a Main class to capture user input for a bowler and display their details.

 **Input Format** 

- First, the user is prompted to enter the player's name (String).
- Next, the user is asked to enter the player’s team (String).
- The user is prompted to enter the player's age (Integer).
- Then, the user is asked to enter the number of wickets taken (Integer).
- Finally, the user is asked to enter the bowling average (Double).

 **Constraints** 

NA

 **Output Format** 

- The output should display the player's general details first, followed by the bowling statistics.
- Each label and its corresponding value should be separated by a colon (:) and a space.
- The output should print each detail on a new line.

 **Sample Input 0** 

```
Jasprit Bumrah
India
29
300
24.5

```

 **Sample Output 0** 

```
Enter the player's name:
Enter the player's team:
Enter the player's age:
Enter the number of wickets taken:
Enter the bowling average:
Player Details:
Name: Jasprit Bumrah
Team: India
Age: 29
Bowling Statistics:
Wickets Taken: 300
Bowling Average: 24.5

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T16:07:48.195Z  

```java
import java.util.*;

class Player {
    String name;
    String team;
    int age;

    void displayPlayerInfo() {
        System.out.println("Player Details:");
        System.out.println("Name: " + name);
        System.out.println("Team: " + team);
        System.out.println("Age: " + age);
    }
}

class Bowler extends Player {
    int wicketsTaken;
    double bowlingAverage;

    void displayBowlingStats() {
        System.out.println("Bowling Statistics:");
        System.out.println("Wickets Taken: " + wicketsTaken);
        System.out.println("Bowling Average: " + bowlingAverage);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player's name:");
        String name = sc.nextLine();

        System.out.println("Enter the player's team:");
        String team = sc.nextLine();

        System.out.println("Enter the player's age:");
        int age = sc.nextInt();

        System.out.println("Enter the number of wickets taken:");
        int wicketsTaken = sc.nextInt();

        System.out.println("Enter the bowling average:");
        double bowlingAverage = sc.nextDouble();

        Bowler bowler = new Bowler();

        bowler.name = name;
        bowler.team = team;
        bowler.age = age;
        bowler.wicketsTaken = wicketsTaken;
        bowler.bowlingAverage = bowlingAverage;

        bowler.displayPlayerInfo();
        bowler.displayBowlingStats();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/inheritance-cricket-player-statistics-system/problem)