# Inheritance - Bowler Profile Management System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The cricket association wants to classify players based on their general profile, then further categorize them as either bowlers or specific types of fast bowlers. This classification helps manage player details at different levels of expertise.

This system will use multilevel inheritance:

- The Player class will store basic details about any player.
- The Bowler class will extend Player to add attributes specific to bowlers.
- The FastBowler class will extend Bowler to add details unique to fast bowlers.

Program Specifications

Create a Player class with the following attributes:

- String name: Name of the player.
- String team: Team of the player.
- int age: Age of the player.
- Include a method displayPlayerInfo() to print general player information.

Create a Bowler class extending Player with additional attributes:

- int wicketsTaken: Number of wickets taken by the bowler.
- double bowlingAverage: The bowling average of the bowler.
- Include a method displayBowlerInfo() to print bowler-specific details.

Create a FastBowler class extending Bowler with an additional attribute:

- int averageSpeed: Average bowling speed (km/h).
- Include a method displayFastBowlerInfo() to print fast bowler-specific details.

Create a Main class to capture user input and display player details at each level of inheritance.

 **Input Format** 

- First, the user is prompted to enter the player's name.
- Next, the player’s team name.
- Player's age.
- Number of wickets taken.
- Bowling average.
- Average speed of bowling.

 **Constraints** 

NA

 **Output Format** 

The output should display the player’s general details first, followed by bowler-specific details, and finally the fast bowler-specific details.

 **Sample Input 0** 

```
Mitchell Starc
Australia
33
280
25.3
145

```

 **Sample Output 0** 

```
Enter the player's name:
Enter the player's team:
Enter the player's age:
Enter the number of wickets taken:
Enter the bowling average:
Enter the average speed:
Player Details:
Name: Mitchell Starc
Team: Australia
Age: 33
Bowler Details:
Wickets Taken: 280
Bowling Average: 25.3
Fast Bowler Details:
Average Speed: 145 km/h

```

 **Sample Input 1** 

```
Kagiso Rabada
South Africa
28
210
23.1
142

```

 **Sample Output 1** 

```
Enter the player's name:
Enter the player's team:
Enter the player's age:
Enter the number of wickets taken:
Enter the bowling average:
Enter the average speed:
Player Details:
Name: Kagiso Rabada
Team: South Africa
Age: 28
Bowler Details:
Wickets Taken: 210
Bowling Average: 23.1
Fast Bowler Details:
Average Speed: 142 km/h

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-12T14:34:28.249Z  

```java
import java.util.Scanner;

class Player {
    String name;
    String team;
    int age;
    
    Player(String name, String team, int age) {
        this.name = name;
        this.team = team;
        this.age = age;
    }
    
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
    
    Bowler(String name, String team, int age, int wicketsTaken, double bowlingAverage) {
        super(name, team, age);
        this.wicketsTaken = wicketsTaken;
        this.bowlingAverage = bowlingAverage;
    }
    
    void displayBowlerInfo() {
        System.out.println("Bowler Details:");
        System.out.println("Wickets Taken: " + wicketsTaken);
        System.out.println("Bowling Average: " + bowlingAverage);
    }
}

class FastBowler extends Bowler {
    int averageSpeed;
    
    FastBowler(String name, String team, int age, int wicketsTaken, double bowlingAverage, int averageSpeed) {
        super(name, team, age, wicketsTaken, bowlingAverage);
        this.averageSpeed = averageSpeed;
    }
    
    void displayFastBowlerInfo() {
        System.out.println("Fast Bowler Details:");
        System.out.println("Average Speed: " + averageSpeed + " km/h");
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
                
                System.out.println("Enter the average speed:");
                int averageSpeed = sc.nextInt();
                
                FastBowler fb = new FastBowler(name, team, age, wicketsTaken, bowlingAverage, averageSpeed);
                
                fb.displayPlayerInfo();
                fb.displayBowlerInfo();
                fb.displayFastBowlerInfo();
                
                sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/inheritance-bowler-profile-management-system/problem)