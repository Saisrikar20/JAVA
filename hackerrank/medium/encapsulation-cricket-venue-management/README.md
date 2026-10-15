# Encapsulation - Cricket Venue Management

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are working on an application that manages cricket tournament venues. For each venue, you need to store its name and the city where it is located. You are required to store this information in an object-oriented way, ensuring that venue details are displayed in a formatted output using a specific format. The program needs to have a Venue class for storing venue data and a VenueBO class for displaying the venue details.

Program Specifications

Venue Class:

- Private member variables: Name (String) and city (String).
- Provides a default constructor and a 2-argument constructor to initialize the variables.
- Getters and setters for the member variables using appropriate naming conventions.
- Override the toString() method to format the output in the specified format: ", ".

VenueBO Class:

- Contains a method displayVenueDetails(Venue venue) that prints the venue details using the toString() method of the Venue class.

Main Class:

- Handles input from the user to create a Venue object and uses the VenueBO class to display the venue's details in the required format.

 **Input Format** 

- Enter the venue name: A string representing the venue's name.
- Enter the city name: A string representing the city's name.

 **Constraints** 

NA

 **Output Format** 

- Venue Details: This text is printed inside the VenueBO class's displayVenueDetails method.
- The venue name and city are printed in the format ", ".

 **Sample Input 0** 

```
Eden Gardens
Kolkata

```

 **Sample Output 0** 

```
Enter the venue name
Enter the city name
Venue Details
Eden Gardens,Kolkata

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
Wankhede Stadium,Mumbai

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:50:52.608Z  

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

    @Override
    public String toString() {
        return name + "," + city;
    }
}

class VenueBO {
    public void displayVenueDetails(Venue venue) {
        System.out.println("Venue Details");
        System.out.println(venue.toString());
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the venue name");
        String name = sc.nextLine();

        System.out.println("Enter the city name");
        String city = sc.nextLine();

        Venue venue = new Venue(name, city);

        VenueBO venueBO = new VenueBO();
        venueBO.displayVenueDetails(venue);

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-cricket-venue-management/problem)