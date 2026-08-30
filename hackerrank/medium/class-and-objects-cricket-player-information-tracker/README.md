# Class and Objects - Cricket Player Information Tracker

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are developing a Cricket Player Information Tracker application that helps coaches, analysts, and fans easily access detailed information about various cricket players. The application will allow users to input player details in a simple format, and then parse that information to display it in a structured way. This will be particularly useful for sports analysts who need quick access to player profiles during matches or training sessions.

In this application, each player is represented as an object that holds their name, country, and skill set. The user can input player details in a comma-separated format, and the application will utilize the String.split() function to parse and display these details cleanly.

 **Program Specifications** 

Class Name: Player

- Member Variables:
- String name (to store the player's name).
- String country (to store the player's country).
- String skill (to store the player's skill).

Class Name: Main

- This class contains the main method to interact with the user and test the Player class.

 **Input Format** 

The user is prompted to enter the player details as a single line of tet, with each detail separated by a comma.

- The first detail is the player's name (String).
- The second detail is the player's country (String).
- The third detail is the player's skill (String).

 **Constraints** 

NA

 **Output Format** 

- The output displays the details of the player in a structured format, with each piece of information labelled (Player Name, Country Name, Skill).
- Each label and its corresponding value should be separated by a colon (:) and a space.
- The output should be printed on separate lines, clearly presenting each detail.

 **Sample Input 0** 

```
Virat Kohli,India,Batsman

```

 **Sample Output 0** 

```
Enter the player details
Player Details 
Player Name : Virat Kohli
Country Name : India
Skill : Batsman

```

 **Sample Input 1** 

```
Joe Root,England,Batsman

```

 **Sample Output 1** 

```
Enter the player details
Player Details 
Player Name : Joe Root
Country Name : England
Skill : Batsman

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:47:18.378Z  

```java
import java.util.*;

class Player {
    String name;
    String country;
    String skill;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player details");
        String input = sc.nextLine();

        String[] details = input.split(",");

        Player player = new Player();

        player.name = details[0];
        player.country = details[1];
        player.skill = details[2];

        System.out.println("Player Details ");
        System.out.println("Player Name : " + player.name);
        System.out.println("Country Name : " + player.country);
        System.out.println("Skill : " + player.skill);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-cricket-player-information-tracker/problem)