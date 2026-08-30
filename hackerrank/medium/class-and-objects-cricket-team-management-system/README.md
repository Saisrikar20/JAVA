# Class and Objects - Cricket Team Management System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are the manager of a professional cricket team. You need a system to keep track of essential information about your team, including the team’s name, coach's name, location, players, and the captain. You want to ensure that this information can be entered easily and displayed clearly. This program will allow you to input team details in a structured format and retrieve that information when needed.

 **Program Specifications** 

Class Name: Team Attributes:

- String name - Name of the team
- String coach - Coach of the team
- String location - Location of the team
- String players - List of players in the team (comma-separated)
- String captain - Name of the captain

Constructors:

- 5-Argument Constructor: Initializes all member variables.
- Default Constructor: Initializes the object with default values.

Class Name: Main Methods:

- main: Entry point for the program to read team details, create a Team object, and print the details.

 **Input Format** 

- The user is prompted to enter the team details in a single line.
- The details should be separated by the # character, in the following order: Team name (String) Coach name (String) Location (String) Players (comma-separated String) Captain name (String)

 **Constraints** 

NA

 **Output Format** 

- The output displays the details of the team in a structured format.
- Each piece of information is labelled and printed on a separate line as follows: Team: [Team Name] Coach: [Coach Name] Location: [Location] Players: [List of Players] Captain: [Captain Name]

 **Sample Input 0** 

```
CSK#Stephen Fleming#Chennai#MS Dhoni, Ashwin, Raina, Hussey, Maxwell, Bravo, Morkel, Jadeja, Mohit Sharma, Hayden, du Plessis, Abhinav Mukund#MS Dhoni

```

 **Sample Output 0** 

```
Enter the team details
Team: CSK
Coach: Stephen Fleming
Location: Chennai
Players: MS Dhoni, Ashwin, Raina, Hussey, Maxwell, Bravo, Morkel, Jadeja, Mohit Sharma, Hayden, du Plessis, Abhinav Mukund
Captain: MS Dhoni

```

 **Sample Input 1** 

```
MI#Mahela Jayawardene#Mumbai#Rohit Sharma, Hardik Pandya, Krunal Pandya, Pollard, Boult, Bumrah, Ishan Kishan, de Kock, Surya Kumar Yadav, Jayant Yadav#Rohit Sharma

```

 **Sample Output 1** 

```
Enter the team details
Team: MI
Coach: Mahela Jayawardene
Location: Mumbai
Players: Rohit Sharma, Hardik Pandya, Krunal Pandya, Pollard, Boult, Bumrah, Ishan Kishan, de Kock, Surya Kumar Yadav, Jayant Yadav
Captain: Rohit Sharma

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:58:04.880Z  

```java
import java.util.*;

class Team {
    String name;
    String coach;
    String location;
    String players;
    String captain;

    // Default constructor
    Team() {
    }

    // 5-Argument constructor
    Team(String name, String coach, String location, String players, String captain) {
        this.name = name;
        this.coach = coach;
        this.location = location;
        this.players = players;
        this.captain = captain;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the team details");
        String input = sc.nextLine();

        String[] details = input.split("#");

        Team team = new Team(
            details[0],
            details[1],
            details[2],
            details[3],
            details[4]
        );

        System.out.println("Team: " + team.name);
        System.out.println("Coach: " + team.coach);
        System.out.println("Location: " + team.location);
        System.out.println("Players: " + team.players);
        System.out.println("Captain: " + team.captain);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-cricket-team-management-system/problem)