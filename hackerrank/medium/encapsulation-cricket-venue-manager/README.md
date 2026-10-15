# Encapsulation - Cricket Venue Manager

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are working on a cricket tournament management application, where you need to store information about multiple venues where matches will be played. Each venue has a name and the city where it is located. You are required to design a Venue class to store this information, using appropriate encapsulation with getters and setters. The user will input venue details in a comma-separated format, and your application will split the input to extract the venue name and city.

Program Specifications

Venue Class

- Private member variables: name and city.
- A 2-argument constructor to initialize these variables.
- A default constructor.
- Getters and setters following the given naming convention (getName, setName, getCity, setCity).

Main Class

- Accepts the number of venues as input.
- Uses a list to store multiple Venue objects.
- Splits the input string to extract the venue name and city, and prints the details in the specified format.

 **Input Format** 

- Enter the number of venues: An integer value representing the number of venues.
- For each venue, enter the details in the following format: Enter the details of venue X: A string containing the venue name and city separated by a comma (,).

 **Constraints** 

NA

 **Output Format** 

- Venue Details: A heading to indicate the start of the output.
- For each venue: Venue Name: The name of the venue, exactly as input, except if there are spaces after the comma (like "M. Chinnasamy Stadium"), the first comma should not be printed directly next to the venue's name (e.g., "M, Chinnasamy Stadium" instead of "M. Chinnasamy Stadium"). City Name: The city of the venue.

 **Sample Input 0** 

```
2
Stadium A,New York
Hall B,Los Angeles

```

 **Sample Output 0** 

```
Enter the number of venues
Enter the details of venue 1
Enter the details of venue 2
Venue Details
Venue Name : Stadium A
City Name : New York
Venue Name : Hall B
City Name : Los Angeles

```

 **Sample Input 1** 

```
1
Convention Center,Chicago

```

 **Sample Output 1** 

```
Enter the number of venues
Enter the details of venue 1
Venue Details
Venue Name : Convention Center
City Name : Chicago

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:47:35.140Z  

```java
import java.util.*;

class Venue {
    private String name;
    private String city;

    public Venue() {
    }

    public Venue(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of venues");
        int n = Integer.parseInt(sc.nextLine());

        List<Venue> venues = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the details of venue " + i);
            String input = sc.nextLine();

            String[] details = input.split(",", 2);
            String name = details[0].trim();
            String city = details[1].trim();

            venues.add(new Venue(name, city));
        }

        System.out.println("Venue Details");

        for (Venue venue : venues) {
            System.out.println("Venue Name : " + venue.getName());
            System.out.println("City Name : " + venue.getCity());
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-cricket-venue-manager/problem)