# Class and Objects - Wicket Tracking System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In the world of cricket analysis, match analysts and commentators need precise and organized information about each wicket that falls during the game. The process of recording wicket details is essential for detailed commentary and post-match analysis. This Wicket Tracking System will allow cricket analysts to input the details of every wicket (such as over, ball, wicket type, dismissed player, and bowler) and then display that information in a well-structured format for easy reference.

In this scenario, imagine you are building a system for a cricket commentary team to log each wicket as the game progresses. The system will capture the details of the wicket, like which over and ball it occurred, who the player dismissed was, the type of dismissal, and the bowler responsible.

The data will be captured using objects and stored in memory to allow the commentary team to recall it during and after the game for analysis.

 **Program Specifications** 

Class Wicket: Attributes:

- over: Stores the over in which the wicket occurred.
- ball: Stores the ball within the over when the wicket was taken.
- wicketType: Stores the type of dismissal (e.g., LBW, Bowled, Stumped).
- playerName: Stores the name of the player who got out.
- bowlerName: Stores the name of the bowler who took the wicket.

Constructors:

- A 5-argument constructor to initialize all member variables.
- A default constructor with no arguments.

Class Main: Main Method:

- Reads input for the number of wickets.
- Reads each wicket’s details using a comma-separated string (split using String.split()).
- Uses an array of Wicket objects to store the information for multiple wickets.
- Outputs the wicket details in a formatted manner.

 **Input Format** 

- The first line contains an integer representing the number of wickets.
- For each wicket, the user will input the details in the following format: over,ball,wicketType,playerName,bowlerName The details should be separated by commas with no leading or trailing spaces.

 **Constraints** 

NA

 **Output Format** 

- The output begins with "Wicket Details".
- For each wicket, the details will be printed in the following format: Over: Ball: Wicket Type: Player Name: Bowler Name:

 **Sample Input 0** 

```
3
5,2,LBW,Gautam Gambir,Aswin
6,6,Bowled,Brad Hogg,Dwayne Bravo
7,3,Stumped,Robin Uthappa,Ravindra Jadeja

```

 **Sample Output 0** 

```
Enter the number of wickets
Enter the details of wicket 1
Enter the details of wicket 2
Enter the details of wicket 3
Wicket Details
Over: 5
Ball: 2
Wicket Type: LBW
Player Name: Gautam Gambir
Bowler Name: Aswin
Over: 6
Ball: 6
Wicket Type: Bowled
Player Name: Brad Hogg
Bowler Name: Dwayne Bravo
Over: 7
Ball: 3
Wicket Type: Stumped
Player Name: Robin Uthappa
Bowler Name: Ravindra Jadeja

```

 **Sample Input 1** 

```
1
10,4,Caught,AB de Villiers,Moeen Ali

```

 **Sample Output 1** 

```
Enter the number of wickets
Enter the details of wicket 1
Wicket Details
Over: 10
Ball: 4
Wicket Type: Caught
Player Name: AB de Villiers
Bowler Name: Moeen Ali

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T16:06:13.054Z  

```java
import java.util.*;

class Wicket {
    int over;
    int ball;
    String wicketType;
    String playerName;
    String bowlerName;

    // Default constructor
    Wicket() {
    }

    // 5-argument constructor
    Wicket(int over, int ball, String wicketType,
           String playerName, String bowlerName) {
        this.over = over;
        this.ball = ball;
        this.wicketType = wicketType;
        this.playerName = playerName;
        this.bowlerName = bowlerName;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of wickets");
        int n = sc.nextInt();
        sc.nextLine();

        Wicket[] wickets = new Wicket[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the details of wicket " + (i + 1));

            String input = sc.nextLine();
            String[] details = input.split(",");

            int over = Integer.parseInt(details[0]);
            int ball = Integer.parseInt(details[1]);
            String wicketType = details[2];
            String playerName = details[3];
            String bowlerName = details[4];

            wickets[i] = new Wicket(
                over,
                ball,
                wicketType,
                playerName,
                bowlerName
            );
        }

        System.out.println("Wicket Details");

        for (int i = 0; i < n; i++) {
            System.out.println("Over: " + wickets[i].over);
            System.out.println("Ball: " + wickets[i].ball);
            System.out.println("Wicket Type: " + wickets[i].wicketType);
            System.out.println("Player Name: " + wickets[i].playerName);
            System.out.println("Bowler Name: " + wickets[i].bowlerName);
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-wicket-tracking-system/problem)