# Polymorphism - Cricket Player Profile with Role-Specific Details

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A cricket team manager needs a system to keep track of the players on the team and their specific roles. Every player has basic information like their name, country, and the number of matches they’ve played. However, based on their specialization, each player type has additional details:

Batsman has a batting average and total runs scored. Bowler has a bowling average and total wickets taken. All-rounder has both batting and bowling averages. The manager wants to record player details and retrieve information about each player's statistics based on their roles, using inheritance to structure common and specific player attributes.

Program Specifications

Create a base class named Player:

Attributes:

- String name: Stores the player's name.
- String country: Stores the country the player represents.
- int matches: Stores the number of matches the player has played.

Constructors:

- Parameterized Constructor: Initializes name, country, and matches.

Method:

- public void displayPlayerInfo(): Displays basic player information (name, country, matches).

Create three subclasses Batsman, Bowler, and AllRounder:

Batsman:

- Additional Attributes: double battingAverage, int totalRuns.
- Constructor: Initializes all player details plus the batting average and total runs.
- public void displayPlayerInfo(): Overrides the base method to include batting details.

Bowler:

- Additional Attributes: double bowlingAverage, int totalWickets.
- Constructor: Initializes all player details plus the bowling average and total wickets.
- public void displayPlayerInfo(): Overrides the base method to include bowling details.

AllRounder:

- Additional Attributes: double battingAverage, double bowlingAverage.
- Constructor: Initializes all player details plus batting and bowling averages.
- public void displayPlayerInfo(): Overrides the base method to include both batting and bowling details.

Create a class named Main:

- Purpose: Capture user input for player type, instantiate the appropriate player subclass, and display player details.

 **Input Format** 

- Player Type (Batsman, Bowler, or AllRounder).
- Player’s Name (String).
- Country Name (String).
- Number of Matches (Integer).
- Additional inputs based on player type: For Batsman: Batting Average (Double), Total Runs (Integer). For Bowler: Bowling Average (Double), Total Wickets (Integer). For AllRounder: Batting Average (Double), Bowling Average (Double).

 **Constraints** 

NA

 **Output Format** 

Displays player details in a structured format, showing specific stats based on the player type.

 **Sample Input 0** 

```
Batsman
Virat Kohli
India
250
59.33
12000

```

 **Sample Output 0** 

```
Enter player type (Batsman/Bowler/AllRounder):
Enter player name:
Enter country:
Enter matches played:
Enter batting average:
Enter total runs:

Player Details:
Name: Virat Kohli
Country: India
Matches Played: 250
Player Type: Batsman
Batting Average: 59.33
Total Runs: 12000

```

 **Sample Input 1** 

```
Bowler
James Anderson
England
150
26.85
600

```

 **Sample Output 1** 

```
Enter player type (Batsman/Bowler/AllRounder):
Enter player name:
Enter country:
Enter matches played:
Enter bowling average:
Enter total wickets:

Player Details:
Name: James Anderson
Country: England
Matches Played: 150
Player Type: Bowler
Bowling Average: 26.85
Total Wickets: 600

```

 **Sample Input 2** 

```
AllRounder
Ben Stokes
England
80
35.50
29.75

```

 **Sample Output 2** 

```
Enter player type (Batsman/Bowler/AllRounder):
Enter player name:
Enter country:
Enter matches played:
Enter batting average:
Enter bowling average:

Player Details:
Name: Ben Stokes
Country: England
Matches Played: 80
Player Type: AllRounder
Batting Average: 35.5
Bowling Average: 29.75

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T03:45:30.015Z  

```java
import java.util.*;
class Player {
    String name;
    String country;
    int matches;
    Player(String name,String country,int matches) {
        this.name=name;
        this.country=country;
        this.matches=matches;
    }
    public void displayPlayerInfo() {
        System.out.println("Name: "+name);
        System.out.println("Country: "+country);
        System.out.println("Matches Played: "+matches);
    }
}
class Batsman extends Player {
    double battingAverage;
    int totalRuns;
    Batsman(String name,String country,int matches,double battingAverage,int totalRuns) {
        super(name,country,matches);
        this.battingAverage=battingAverage;
        this.totalRuns=totalRuns;
    }
    public void displayPlayerInfo() {
        super.displayPlayerInfo();
        System.out.println("Player Type: Batsman");
        System.out.println("Batting Average: "+battingAverage);
        System.out.println("Total Runs: "+totalRuns);
    }
}
class Bowler extends Player {
    double bowlingAverage;
    int totalWickets;
    Bowler(String name,String country,int matches,double bowlingAverage,int totalWickets) {
        super(name,country,matches);
        this.bowlingAverage=bowlingAverage;
        this.totalWickets=totalWickets;
    }
    public void displayPlayerInfo() {
        super.displayPlayerInfo();
        System.out.println("Player Type: Bowler");
        System.out.println("Bowling Average: "+bowlingAverage);
        System.out.println("Total Wickets: "+totalWickets);
    }
}
class AllRounder extends Player {
    double battingAverage;
    double bowlingAverage;
    AllRounder(String name,String country,int matches,double battingAverage,double bowlingAverage) {
        super(name,country,matches);
        this.battingAverage=battingAverage;
        this.bowlingAverage=bowlingAverage;
    }
    public void displayPlayerInfo() {
        super.displayPlayerInfo();
        System.out.println("Player Type: AllRounder");
        System.out.println("Batting Average: "+battingAverage);
        System.out.println("Bowling Average: "+bowlingAverage);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter player type (Batsman/Bowler/AllRounder):");
        String type=sc.nextLine();
        System.out.println("Enter player name:");
        String name=sc.nextLine();
        System.out.println("Enter country:");
        String country=sc.nextLine();
        System.out.println("Enter matches played:");
        int matches=sc.nextInt();
        Player p;
        if(type.equals("Batsman")) {
            System.out.println("Enter batting average:");
            double avg=sc.nextDouble();
            System.out.println("Enter total runs:");
            int runs=sc.nextInt();
            p=new Batsman(name,country,matches,avg,runs);
            }
            else if(type.equals("Bowler")) {
                System.out.println("Enter bowling average:");
                double avg=sc.nextDouble();
                System.out.println("Enter total wickets:");
                int wickets=sc.nextInt();
                p=new Bowler(name,country,matches,avg,wickets);
            }
            else {
                System.out.println("Enter batting average:");
                double batting=sc.nextDouble();
                System.out.println("Enter bowling average:");
                double bowling=sc.nextDouble();
                p=new AllRounder(name,country,matches,batting,bowling);
            }
            System.out.println();
            System.out.println("Player Details:");
            p.displayPlayerInfo();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/polymorphism-cricket-player-profile-with-role-specific-details/problem)