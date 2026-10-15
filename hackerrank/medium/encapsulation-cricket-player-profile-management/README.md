# Encapsulation - Cricket Player Profile Management

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are building a system for a cricket league where you need to store information about players. Each player has a name, country, and skill (e.g., Batsman, Bowler, All-rounder). You need to store this information and display it in a formatted way using object-oriented principles. The task requires overriding the toString() method in the Player class to format the player's details and then display them using a separate PlayerBO class.

Program Specifications

Player Class:

- Private member variables: Name, Country, and Skill.
- Provides a default constructor and a 3-argument constructor.
- Getters and setters for the member variables using appropriate naming conventions.
- Override the toString() method to format the output in the specified format using String.format("%-15s %-15s %-15s", name, country, skill).

PlayerBO Class:

- Contains a method displayPlayerDetails(Player player) that prints the player's details using the toString() method of the Player class.

Main Class:

- Handles input from the user to create a Player object and uses the PlayerBO class to display the player's details in the required format.

 **Input Format** 

- Enter the player name: A string representing the player's name.
- Enter the country name: A string representing the player's country.
- Enter the skill: A string representing the player's skill.

 **Constraints** 

NA

 **Output Format** 

- Player Details: This text is printed inside the PlayerBO class's displayPlayerDetails method.
- Player name, country, and skill are printed in a formatted way with fixed spacing.

 **Sample Input 0** 

```
Virat Kohli
India
Batsman

```

 **Sample Output 0** 

```
Enter the player name
Enter the country
Enter the skill
Player Details 
Virat Kohli     India           Batsman        

```

 **Sample Input 1** 

```
Steve Smith
Australia
Batsman

```

 **Sample Output 1** 

```
Enter the player name
Enter the country
Enter the skill
Player Details 
Steve Smith     Australia       Batsman        

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:48:37.127Z  

```java
import java.util.*;

class Player {
    private String name;
    private String country;
    private String skill;

    public Player() {
    }

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
        return String.format("%-15s %-15s %-15s", name, country, skill);
    }
}

class PlayerBO {
    public void displayPlayerDetails(Player player) {
        System.out.println("Player Details ");
        System.out.println(player.toString());
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player name");
        String name = sc.nextLine();

        System.out.println("Enter the country");
        String country = sc.nextLine();

        System.out.println("Enter the skill");
        String skill = sc.nextLine();

        Player player = new Player(name, country, skill);

        PlayerBO playerBO = new PlayerBO();
        playerBO.displayPlayerDetails(player);

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-cricket-player-profile-management/problem)