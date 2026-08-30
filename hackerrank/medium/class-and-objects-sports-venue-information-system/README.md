# Class and Objects - Sports Venue Information System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are developing a Sports Venue Information System for sports enthusiasts, event organizers, and fans. This system allows users to input details about various sports venues, such as stadiums and arenas, in a simple and structured format. Users can quickly retrieve and view the information about venues where their favorite teams play or where upcoming events are scheduled.

In this application, each venue is represented as an object that holds its name and city. Users can input venue details in a comma-separated format, and the application will utilize the String.split() function to parse and display this information in a user-friendly manner.

 **Program Specifications** 

Class Name: Venue

- Member Variables:
- String name (to store the venue's name).
- String city (to store the city where the venue is located).

Class Name: Main

- This class contains the main method to interact with the user and test the Venue class.

 **Input Format** 

The user is prompted to enter the venue name (String).

- This input should be a single line containing the full name of the venue. The user is then prompted to enter the city name (String).
- This input should also be a single line containing the name of the city.

 **Constraints** 

NA

 **Output Format** 

- The output displays the details of the venue in a structured format, clearly labeled as "Venue Details."
- Each piece of information is displayed with a label (Venue Name, City Name) followed by its corresponding value.
- The label and its corresponding value should be separated by a colon (:) and a space.
- Each detail is printed on a separate line.

 **Sample Input 0** 

```
Wankhede Stadium,Mumbai

```

 **Sample Output 0** 

```
Enter the venue details
Venue Details 
Venue Name : Wankhede Stadium
City Name : Mumbai

```

 **Sample Input 1** 

```
Eden Gardens,Kolkata

```

 **Sample Output 1** 

```
Enter the venue details
Venue Details 
Venue Name : Eden Gardens
City Name : Kolkata

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:55:03.152Z  

```java
import java.util.*;

class Venue {
    String name;
    String city;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the venue details");
        String input = sc.nextLine();

        String[] details = input.split(",");

        Venue venue = new Venue();

        venue.name = details[0];
        venue.city = details[1];

        System.out.println("Venue Details ");
        System.out.println("Venue Name : " + venue.name);
        System.out.println("City Name : " + venue.city);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-sports-venue-information-system/problem)