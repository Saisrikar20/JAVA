# Abstraction - Vehicle Registration System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a bustling city, a new vehicle registration system is needed to manage various types of vehicles. The city requires a streamlined way to register different vehicles such as cars and motorcycles, and it wants to ensure that each vehicle's details are captured correctly. To achieve this, an abstract class named Vehicle will be created to define the common properties and methods that all vehicles share. Specific vehicle types like Car and Motorcycle will extend this abstract class, allowing the system to be flexible and easily maintainable.

Program Specifications

Abstract Class: Vehicle

Attributes:

- String ownerName
- String registrationNumber

Constructor:

- Vehicle(String ownerName, String registrationNumber)

Methods:

- abstract void displayDetails()

Derived Class: Car

Additional Attribute:

- int numberOfDoors

Constructor:

- Car(String ownerName, String registrationNumber, int numberOfDoors)

Method:

- void displayDetails() (Overrides the abstract method)

Derived Class: Motorcycle

Additional Attribute:

- boolean hasSidecar

Constructor:

- Motorcycle(String ownerName, String registrationNumber, boolean hasSidecar)

Method:

- void displayDetails() (Overrides the abstract method)

Driver Class: Main

- The main method will prompt the user to input vehicle details and display the registered vehicle's information.

 **Input Format** 

- Enter the type of vehicle (1 for Car, 2 for Motorcycle)
- Enter the owner's name
- Enter the registration number
- For Car: Enter the number of doors
- For Motorcycle: Enter whether it has a sidecar (true or false)

 **Constraints** 

NA

 **Output Format** 

Display the vehicle's details based on the inputs.

 **Sample Input 0** 

```
1
John Doe
ABC1234
4

```

 **Sample Output 0** 

```
Enter the type of vehicle (1 for Car, 2 for Motorcycle): 
Enter owner's name:
Enter registration number:
Enter number of doors:
Vehicle Details:
Owner: John Doe
Registration Number: ABC1234
Number of Doors: 4

```

 **Sample Input 1** 

```
2
Jane Smith
XYZ5678
true

```

 **Sample Output 1** 

```
Enter the type of vehicle (1 for Car, 2 for Motorcycle): 
Enter owner's name:
Enter registration number:
Does it have a sidecar? (true/false):
Vehicle Details:
Owner: Jane Smith
Registration Number: XYZ5678
Has Sidecar: true

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T04:08:31.630Z  

```java
import java.util.Scanner;
abstract class Vehicle {
    String ownerName;
    String registrationNumber;
    Vehicle(String ownerName, String registrationNumber) {
        this.ownerName = ownerName;
        this.registrationNumber = registrationNumber;
    }
    abstract void displayDetails();
}
class Car extends Vehicle {
    int numberOfDoors;
    Car(String ownerName, String registrationNumber, int numberOfDoors) {
        super(ownerName, registrationNumber);
        this.numberOfDoors = numberOfDoors;
    }
    void displayDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("Owner: " + ownerName);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}
class Motorcycle extends Vehicle {
    boolean hasSidecar;
    Motorcycle(String ownerName, String registrationNumber, boolean hasSidecar) {
        super(ownerName, registrationNumber);
        this.hasSidecar = hasSidecar;
    }
    void displayDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("Owner: " + ownerName);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Has Sidecar: " + hasSidecar);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of vehicle (1 for Car, 2 for Motorcycle): ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter owner's name:");
        String ownerName = sc.nextLine();
        System.out.println("Enter registration number:");
        String registrationNumber = sc.nextLine();
        Vehicle vehicle;
        if(choice == 1) {
            System.out.println("Enter number of doors:");
            int numberOfDoors = sc.nextInt();
            vehicle = new Car(ownerName, registrationNumber, numberOfDoors);
        }
        else {
            System.out.println("Does it have a sidecar? (true/false):");
            boolean hasSidecar = sc.nextBoolean();
            vehicle = new Motorcycle(ownerName, registrationNumber, hasSidecar);
        }
        vehicle.displayDetails();
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/abstraction-vehicle-registration-system/problem)