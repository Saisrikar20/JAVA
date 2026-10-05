# Polymorphism - Cricket Player Information Hub

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The Cricket Player Information Hub is designed to help cricket teams manage and view player details based on specific criteria. Coaches and team managers can input player information, retrieve complete player lists, and filter players by their country. This system utilizes object-oriented programming principles, such as encapsulation and method overriding, for a clean and efficient design.

Program Specifications

Class: Player

Attributes:

- private String name
- private String country
- private String skill

Constructor: Initializes player details.

Getters and Setters: For each attribute.

Override:

- toString(): Formats the output to display player details.

Class: PlayerBO

Methods:

- void displayAllPlayerDetails(Player[] playerList): Displays the details of all players.
- void displaySpecificPlayerDetails(Player[] playerList, String countryName): Displays details of players from a specific country.

Class: Main

- Main Method: Tests the functionality by taking user input and invoking methods from PlayerBO.

 **Input Format** 

- The user is prompted to enter the number of players and their details (name, country, and skill).
- After entering the player details, the user can specify a country to filter players.

 **Constraints** 

NA

 **Output Format** 

- The system displays all player details and details of players filtered by country.
- Print the player details by using this spacing format(%-15s %-15s %s).

 **Sample Input 0** 

```
2
Virat Kohli
India
Batsman
Steve Smith
Australia
Batsman
India

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
Virat Kohli     India           Batsman
Steve Smith     Australia       Batsman

Enter the country name for which players details to be known

Player Details
Virat Kohli     India           Batsman

```

 **Sample Input 1** 

```
3
MS Dhoni
India
Wicketkeeper
Kane Williamson
New Zealand
Batsman
Mitchell Starc
Australia
Bowler
Australia

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
MS Dhoni        India           Wicketkeeper
Kane Williamson New Zealand     Batsman
Mitchell Starc  Australia       Bowler

Enter the country name for which players details to be known

Player Details
Mitchell Starc  Australia       Bowler

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T03:53:06.904Z  

```java
import java.util.*;
class Player {
    private String name;
    private String country;
    private String skill;
    Player(String name,String country,String skill) {
        this.name=name;
        this.country=country;
        this.skill=skill;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country=country;
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill=skill;
    }
    @Override
    public String toString() {
        return String.format("%-15s %-15s %s",name,country,skill);
    }
}
class PlayerBO {
    void displayAllPlayerDetails(Player[] playerList) {
        for(Player p:playerList) {
            System.out.println(p);
        }
    }
    void displaySpecificPlayerDetails(Player[] playerList,String countryName) {
        for(Player p:playerList) {
            if(p.getCountry().equals(countryName)) {
                System.out.println(p);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of players");
        int n=sc.nextInt();
        sc.nextLine();
        Player[] playerList=new Player[n];
        for(int i=0;i<n;i++) {
            System.out.println("Enter the player name");
            String name=sc.nextLine();
            System.out.println("Enter the country name");
            String country=sc.nextLine();
            System.out.println("Enter the skill");
            String skill=sc.nextLine();
            playerList[i]=new Player(name,country,skill);
        }
        System.out.println();
        System.out.println("Player Details");
        PlayerBO pbo=new PlayerBO();
        pbo.displayAllPlayerDetails(playerList);
        System.out.println();
        System.out.println("Enter the country name for which players details to be known");
        String countryName=sc.nextLine();
        System.out.println();
        System.out.println("Player Details");
        pbo.displaySpecificPlayerDetails(playerList,countryName);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/polymorphism-cricket-player-information-hub/problem)