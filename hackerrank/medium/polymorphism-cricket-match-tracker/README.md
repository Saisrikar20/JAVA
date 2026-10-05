# Polymorphism - Cricket Match Tracker

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The Cricket Match Tracker application allows users to manage and display details about cricket matches. It leverages method overloading to provide different ways of displaying match-related information. This application is particularly useful for cricket fans, sports analysts, and event organizers who want to keep track of match schedules, venues, and outcomes.

Program Specifications

Class: Match Methods:

- void displayMatchDetails(Date matchDate): Displays the match date in MM-dd-yyyy format.
- void displayMatchDetails(String venue): Displays the stadium name and city separately.
- void displayMatchDetails(String winnerTeam, long runs): Displays the winner team and by how many runs they won.

Main Class: Main

- Contains the main method to test the Match class functionality.
- Utilizes user input to call the appropriate methods.

 **Input Format** 

The user can select an option to input match date, venue, or outcome.

The user provides:

- Match date in dd/MM/yyyy format.
- Venue in the format "Stadium Name, City".
- Winning team name and the number of runs.

 **Constraints** 

NA

 **Output Format** 

The system displays the formatted match date, venue details, or match outcome based on user input.

 **Sample Input 0** 

```
1
15/08/2025

```

 **Sample Output 0** 

```
Menu
1. Match Date
2. Match Venue
3. Match Outcome
Enter your choice (1-3): Enter the date of the match (dd/MM/yyyy): Match Date: 08-15-2025

```

 **Sample Input 1** 

```
2
Eden Gardens, Kolkata

```

 **Sample Output 1** 

```
Menu
1. Match Date
2. Match Venue
3. Match Outcome
Enter your choice (1-3): Enter venue of the match (Stadium, City): Match Venue:
Stadium: Eden Gardens
City: Kolkata

```

 **Sample Input 2** 

```
3
India
45

```

 **Sample Output 2** 

```
Menu
1. Match Date
2. Match Venue
3. Match Outcome
Enter your choice (1-3): Enter the winner team of the match: Enter the number of runs: Match Outcome:
India won by 45 runs.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T03:24:37.330Z  

```java
import java.util.*;
import java.text.*;
class Match {
    void displayMatchDetails(Date matchDate) {
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
        System.out.println("Match Date: "+sdf.format(matchDate));
    }
    void displayMatchDetails(String venue) {
        String[] parts=venue.split(",");
        System.out.println("Match Venue:");
        System.out.println("Stadium: "+parts[0].trim());
        System.out.println("City: "+parts[1].trim());
    }
    void displayMatchDetails(String winnerTeam,long runs) {
        System.out.println("Match Outcome:");
        System.out.println(winnerTeam+" won by "+runs+" runs.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Match m=new Match();
        System.out.println("Menu");
        System.out.println("1. Match Date");
        System.out.println("2. Match Venue");
        System.out.println("3. Match Outcome");
        System.out.print("Enter your choice (1-3): ");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1) {
            System.out.print("Enter the date of the match (dd/MM/yyyy): ");
            String date=sc.nextLine();
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                Date d=sdf.parse(date);
                m.displayMatchDetails(d);
            }
            catch(Exception e) {
                System.out.println("Invalid date");
            }
        }
        else if(choice==2) {
            System.out.print("Enter venue of the match (Stadium, City): ");
            String venue=sc.nextLine();
            m.displayMatchDetails(venue);
        }
        else if(choice==3) {
            System.out.print("Enter the winner team of the match: ");
            String team=sc.nextLine();
            System.out.print("Enter the number of runs: ");
            long runs=sc.nextLong();
            m.displayMatchDetails(team,runs);
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/polymorphism-cricket-match-tracker/problem)