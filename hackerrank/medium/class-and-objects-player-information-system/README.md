# Class and Objects - Player Information System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you're building a Player Information System for a sports management company. The system is designed to store and display the details of players from different sports teams. Every player has a name, the country they represent, and a specific skill set such as a batsman, bowler, or all-rounder.

The company's goal is to maintain a record of their players and easily retrieve and display their information as needed. To accomplish this, you're tasked with developing an object-oriented program that captures the player's details and prints them in a structured format.

 **Program Specifications** 

- Create a class named Player to store player information like name, country, and skill.
- Create a Main class to capture user input and display the player’s information.
- Adhere strictly to object-oriented principles by encapsulating the player’s data within the Player class and using another class for testing.

 **Input Format** 

- First, the user is prompted to enter the player's name (String).
- Next, the user is asked to input the player's country name (String).
- Finally, the user is asked to input the player's skill (String).

 **Constraints** 

NA

 **Output Format** 

- The output should display the details of the player in a structured format, with each piece of information labeled (Player Name, Country Name, Skill).
- Each label and its corresponding value should be separated by a colon (:) and a space.
- The output should be printed on separate lines.

 **Sample Input 0** 

```
MS Dhoni
India
All Rounder

```

 **Sample Output 0** 

```
Enter the player name
Enter the country name
Enter the skill
Player Details: 
Player Name : MS Dhoni
Country Name : India
Skill : All Rounder

```

 **Sample Input 1** 

```
Virat Kohli
India
Batsman

```

 **Sample Output 1** 

```
Enter the player name
Enter the country name
Enter the skill
Player Details: 
Player Name : Virat Kohli
Country Name : India
Skill : Batsman

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:30:44.637Z  

```java
import java.util.*;

class Player {
    private String name;
    private String country;
    private String skill;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getSkill() {
        return skill;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player name");
        String name = sc.nextLine();

        System.out.println("Enter the country name");
        String country = sc.nextLine();

        System.out.println("Enter the skill");
        String skill = sc.nextLine();

        Player player = new Player();

        player.setName(name);
        player.setCountry(country);
        player.setSkill(skill);

        System.out.println("Player Details: ");
        System.out.println("Player Name : " + player.getName());
        System.out.println("Country Name : " + player.getCountry());
        System.out.println("Skill : " + player.getSkill());
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-player-information-system/problem)