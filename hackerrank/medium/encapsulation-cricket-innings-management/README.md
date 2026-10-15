# Encapsulation - Cricket Innings Management

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are developing a cricket score management system for a tournament. In a cricket match, there are two innings where each team gets a chance to bat. The system needs to record the details of both innings (the batting team and the total runs scored) and display the results at the end of the match.

Your task is to design the solution using Object-Oriented Programming (OOP) principles to handle and display the innings details. The program will collect data for both innings, store the information using an array of objects, and display the results.

Program Specifications

Player Class:

Private member variables:

- String BattingTeam
- Long runs

Provides a 2-argument constructor for initializing these variables.

Getters and setters for the member variables using appropriate naming conventions.

Override the toString() method to format the innings details in the specified format.

InningsBO Class:

- Contains a method displayAllInningsDetails(Innings[] inningsList) which prints the details of all innings passed in the array.

Main Class:

- Handles user input to create the Innings objects and uses the InningsBO class to display the details.

 **Input Format** 

- Enter the values for Firstinnings: Prompt for entering the first innings data.
- Enter the BattingTeam: A string representing the batting team.
- Enter the runs scored: A long integer representing the runs scored.
- Enter the values for Secondinnings: Prompt for entering the second innings data.
- Enter the BattingTeam: A string representing the batting team.
- Enter the runs scored: A long integer representing the runs scored.

 **Constraints** 

NA

 **Output Format** 

The details of both innings formatted as:(%-20s%-20s)

Innings details

 **Sample Input 0** 

```
Australia
334
India
335

```

 **Sample Output 0** 

```
Enter the values for FirstInnings
Enter the BattingTeam
Enter the runs scored
Enter the values for SecondInnings
Enter the BattingTeam
Enter the runs scored
Innings Details
Australia           334                 
India               335                 

```

 **Sample Input 1** 

```
Bangladesh
112
Afghanistan
113

```

 **Sample Output 1** 

```
Enter the values for FirstInnings
Enter the BattingTeam
Enter the runs scored
Enter the values for SecondInnings
Enter the BattingTeam
Enter the runs scored
Innings Details
Bangladesh          112                 
Afghanistan         113                 

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:49:45.028Z  

```java
import java.util.*;

class Innings {
    private String battingTeam;
    private Long runs;

    public Innings(String battingTeam, Long runs) {
        this.battingTeam = battingTeam;
        this.runs = runs;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Long getRuns() {
        return runs;
    }

    public void setRuns(Long runs) {
        this.runs = runs;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s", battingTeam, runs);
    }
}

class InningsBO {
    public void displayAllInningsDetails(Innings[] inningsList) {
        System.out.println("Innings Details");
        for (Innings innings : inningsList) {
            System.out.println(innings);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Innings[] inningsList = new Innings[2];

        System.out.println("Enter the values for FirstInnings");
        System.out.println("Enter the BattingTeam");
        String team1 = sc.nextLine();

        System.out.println("Enter the runs scored");
        Long runs1 = sc.nextLong();
        sc.nextLine();

        inningsList[0] = new Innings(team1, runs1);

        System.out.println("Enter the values for SecondInnings");
        System.out.println("Enter the BattingTeam");
        String team2 = sc.nextLine();

        System.out.println("Enter the runs scored");
        Long runs2 = sc.nextLong();

        inningsList[1] = new Innings(team2, runs2);

        InningsBO inningsBO = new InningsBO();
        inningsBO.displayAllInningsDetails(inningsList);

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-cricket-innings-management/problem)