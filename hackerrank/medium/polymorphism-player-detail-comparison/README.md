# Polymorphism - Player Detail Comparison

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a sports management application, we need to manage and compare player details for cricket players. This system allows users to input player information and check whether two players have the same attributes (name, country, and skill). This feature is particularly useful for ensuring data consistency, especially when managing player registrations or rosters.

Program Specifications

Class: Player

Private Attributes:

- String name
- String country
- String skill

Getters:

- getName()
- getCountry()
- getSkill()

Setters:

- setName(String name)
- setCountry(String country)
- setSkill(String skill)

Override the equals() method to compare the current object with another Player object based on the values of name, country, and skill.

Class: Main

- In the main() method, prompt the user to input details for two players.
- After collecting the details, display the entered player information.
- Use the overridden equals() method to compare the two Player objects and display whether they are the same or not.

 **Input Format** 

The user will input player details, including name, country, and skill for both players.

 **Constraints** 

NA

 **Output Format** 

- Display the player details in the specified format.
- Indicate whether the details of the two players are the same.

 **Sample Input 0** 

```
Player 1:
Name: Virat
Country: India
Skill: Batsman

Player 2:
Name: Virat
Country: India
Skill: Batsman

```

 **Sample Output 0** 

```
Enter the player 1 details
Enter the player name
Enter the country name 
Enter the skill
Player 1:----- Name: Virat------ Country: India

Enter the player 2 details
Enter the player name
Enter the country name 
Enter the skill
Skill: Batsman----- ------ Player 2:
Both the player details are same.

```

 **Sample Input 1** 

```
Player 1:
Name: Rohit
Country: India
Skill: Batsman

Player 2:
Name: Jasprit
Country: India
Skill: Bowler

```

 **Sample Output 1** 

```
Enter the player 1 details
Enter the player name
Enter the country name 
Enter the skill
Player 1:----- Name: Rohit------ Country: India

Enter the player 2 details
Enter the player name
Enter the country name 
Enter the skill
Skill: Batsman----- ------ Player 2:
Both the player details are different.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-17T07:02:06.173Z  

```java
import java.util.*;

class Player {
    private String name;
    private String country;
    private String skill;

    public String getName() { return name; }
    public String getCountry() { return country; }
    public String getSkill() { return skill; }

    public void setName(String name) { this.name = name; }
    public void setCountry(String country) { this.country = country; }
    public void setSkill(String skill) { this.skill = skill; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player o = (Player) obj;
        return Objects.equals(name, o.name)
            && Objects.equals(country, o.country)
            && Objects.equals(skill, o.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, skill);
    }
}

public class Main {
    static Player readPlayer(Scanner sc, int no) {
        Player p = new Player();
        System.out.println("Enter the player " + no + " details");
        System.out.println("Enter the player name");
        p.setName(sc.hasNextLine() ? sc.nextLine() : "");
        System.out.println("Enter the country name ");
        p.setCountry(sc.hasNextLine() ? sc.nextLine() : "");
        System.out.println("Enter the skill");
        p.setSkill(sc.hasNextLine() ? sc.nextLine() : "");
        return p;
    }

    static void show(Player p) {
        System.out.println(p.getName() + "----- " + p.getCountry() + "------ " + p.getSkill());
    }

    // value after "Label:" on lines starting with that label
    static List<String> values(List<String> lines, String label) {
        List<String> res = new ArrayList<>();
        for (String l : lines) {
            String t = l.trim();
            if (t.startsWith(label)) res.add(t.substring(label.length()).trim());
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) all.add(in.nextLine());
        in.close();

        Scanner sc = new Scanner(String.join("\n", all));

        Player p1 = readPlayer(sc, 1);
        show(p1);
        System.out.println();
        Player p2 = readPlayer(sc, 2);
        show(p2);

        // compare the actual values if the input has labels, else the raw ones
        List<String> n = values(all, "Name:");
        List<String> c = values(all, "Country:");
        List<String> s = values(all, "Skill:");
        Player a = p1, b = p2;
        if (n.size() >= 2 && c.size() >= 2 && s.size() >= 2) {
            a = new Player(); b = new Player();
            a.setName(n.get(0)); a.setCountry(c.get(0)); a.setSkill(s.get(0));
            b.setName(n.get(1)); b.setCountry(c.get(1)); b.setSkill(s.get(1));
        }

        if (a.equals(b)) {
            System.out.println("Both the player details are same.");
        } else {
            System.out.println("Both the player details are different.");
        }
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/polymorphism-player-detail-comparison/problem)