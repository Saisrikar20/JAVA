# Class and Objects - Sports Event Venue Management System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you're tasked with developing a Sports Event Venue Management System for a sports event organization. The company is responsible for organizing major sporting events like cricket, football, and other tournaments at different stadiums across the country. Each venue where the events take place needs to be stored in the system with details such as the venue's name and the city where it is located.

The system should be simple to use, allowing the event organizers to input venue information and retrieve the stored details to ensure proper event planning and logistics.

 **Program Specifications** 

- Create a class named Venue to store details about a venue, such as the venue name and city.
- Create a Main class to capture user input and display the venue’s information in a structured format.
- Adhere strictly to object-oriented principles and use default access for member variables.

 **Input Format** 

- First, the user is prompted to enter the venue name (String).
- Next, the user is asked to input the city name (String).

 **Constraints** 

NA

 **Output Format** 

- The output should display the details of the venue in a structured format, with each piece of information labeled (Venue Name, City Name).
- Each label and its corresponding value should be separated by a colon (:) and a space.
- The output should be printed on separate lines.

 **Sample Input 0** 

```
M. A. Chidambaram Stadium
Chennai

```

 **Sample Output 0** 

```
Enter the venue name
Enter the city name
Venue Details
Venue Name : M. A. Chidambaram Stadium
City Name : Chennai
M. A. Chidambaram Stadium

```

 **Sample Input 1** 

```
Wankhede Stadium
Mumbai

```

 **Sample Output 1** 

```
Enter the venue name
Enter the city name
Venue Details
Venue Name : Wankhede Stadium
City Name : Mumbai
Wankhede Stadium

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:34:17.743Z  

```java
import java.util.*;

class Venue {
    String venueName;
    String cityName;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the venue name");
        String venueName = sc.nextLine();

        System.out.println("Enter the city name");
        String cityName = sc.nextLine();

        Venue venue = new Venue();

        venue.venueName = venueName;
        venue.cityName = cityName;

        System.out.println("Venue Details");
        System.out.println("Venue Name : " + venue.venueName);
        System.out.println("City Name : " + venue.cityName);
        System.out.println(venue.venueName);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-sports-event-venue-management-system/problem)