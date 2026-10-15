# Encapsulation - Cricket Player Management

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are working on a sports management system for a cricket league. The system needs to handle player information such as name, country, and skill. Your task is to develop a solution using Object-Oriented Programming (OOP) concepts to store and display details of multiple players. The program must prompt for input of player details and display the details in a formatted table.

The system will use:

- A Player class to hold individual player information.
- A PlayerBO class to handle operations related to players, such as displaying player details.
- An array of Player objects to store information for multiple players, ensuring a structured and organized representation.

Program Specifications

Player Class:

Private member variables:

- String Name
- String Country
- String Skill

Provides a 3-argument constructor for initializing these variables.

Getters and setters for the member variables using appropriate naming conventions.

Override the toString() method to format the player details as per the requirement.

PlayerBO Class:

- Contains a method displayPlayerDetails(Player[] playerList) which prints the details of all players passed in the array.

Main Class:

- Handles user input to create multiple Player objects and uses the PlayerBO class to display player details in the specified format.

 **Input Format** 

- Enter the number of players: An integer representing the number of players.
- Enter the player name: A string representing the player's name.
- Enter the country name: A string representing the player's country.
- Enter the skill: A string representing the player's skill (e.g., "Batsman", "Bowler", "All Rounder").

 **Constraints** 

NA

 **Output Format** 

The details of each player formatted in the specified format:(%-15s%-15s%-15s)

Player Details

 **Sample Input 0** 

```
2
Steve Smith
Australia
Batsman
Kagiso Rabada
South Africa
Bowler

```

 **Sample Output 0** 

```
Enter the number of players
Enter the player name
Enter the country name
Enter the skill
Enter the player name
Enter the country name
Enter the skill
Player Details
Steve Smith    Australia      Batsman        
Kagiso Rabada  South Africa   Bowler         

```

 **Sample Input 1** 

```
3
Ben Stokes
England
All Rounder
Moeen Ali
England
All Rounder
Chris Woakes
England
All Rounder

```

 **Sample Output 1** 

```
Enter the number of players
Enter the player name
Enter the country name
Enter the skill
Enter the player name
Enter the country name
Enter the skill
Enter the player name
Enter the country name
Enter the skill
Player Details
Ben Stokes     England        All Rounder    
Moeen Ali      England        All Rounder    
Chris Woakes   England        All Rounder    

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:57:21.601Z  

```java
import java.util.*;

class Player {
    private String name;
    private String country;
    private String skill;

    public Player(String name, String country, String skill) {
        this.name = name;
        this.country = country;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s", name, country, skill);
    }
}

class PlayerBO {
    public void displayPlayerDetails(Player[] playerList) {
        System.out.println("Player Details");
        for (Player player : playerList) {
            System.out.println(player);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of players");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] playerList = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the player name");
            String name = sc.nextLine();

            System.out.println("Enter the country name");
            String country = sc.nextLine();

            System.out.println("Enter the skill");
            String skill = sc.nextLine();

            playerList[i] = new Player(name, country, skill);
        }

        PlayerBO playerBO = new PlayerBO();
        playerBO.displayPlayerDetails(playerList);

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-cricket-player-management/problem)