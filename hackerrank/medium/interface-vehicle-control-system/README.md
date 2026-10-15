# Interface - Vehicle Control System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a modern city, a transportation company needs a system to manage different types of vehicles, including cars and bikes. The system must allow for basic operations such as starting the vehicle, stopping the vehicle, and displaying vehicle details. To maintain flexibility and support multiple vehicle types, the company decides to implement this system using Java interfaces.

Program Specifications

Interface:

Create an interface named Vehicle with the following methods:

- void start();
- void stop();
- void fuelCapacity();

Classes:

Create two classes that implement the Vehicle interface:

Car

- Implements all methods of the Vehicle interface.
- Has a fuelCapacity of 50 liters.

Bike

- Implements all methods of the Vehicle interface.
- Has a fuelCapacity of 15 liters.

Main Class:

- Create a class named VehicleManagement that:
- Creates instances of Car and Bike.
- Demonstrates the usage of the interface methods.

 **Input Format** 

The user will choose which vehicle to start and stop.

 **Constraints** 

NA

 **Output Format** 

The program will display messages indicating the actions taken on the vehicle.

 **Sample Input 0** 

```
1

```

 **Sample Output 0** 

```
Choose a vehicle:
1. Car
2. Bike
Starting the car...
Fuel capacity: 50 liters.
The car has stopped.

```

 **Sample Input 1** 

```
2

```

 **Sample Output 1** 

```
Choose a vehicle:
1. Car
2. Bike
Starting the bike...
Fuel capacity: 15 liters.
The bike has stopped.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:27:19.818Z  

```java
import java.util.*;

interface Vehicle {
    void start();
    void stop();
    void fuelCapacity();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Starting the car...");
    }

    public void stop() {
        System.out.println("The car has stopped.");
    }

    public void fuelCapacity() {
        System.out.println("Fuel capacity: 50 liters.");
    }
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Starting the bike...");
    }

    public void stop() {
        System.out.println("The bike has stopped.");
    }

    public void fuelCapacity() {
        System.out.println("Fuel capacity: 15 liters.");
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a vehicle:");
        System.out.println("1. Car");
        System.out.println("2. Bike");

        int choice = sc.nextInt();

        Vehicle vehicle;

        if (choice == 1) {
            vehicle = new Car();
        } else if (choice == 2) {
            vehicle = new Bike();
        } else {
            sc.close();
            return;
        }

        vehicle.start();
        vehicle.fuelCapacity();
        vehicle.stop();

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/interface-vehicle-control-system/problem)