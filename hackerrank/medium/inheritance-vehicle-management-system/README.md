# Inheritance - Vehicle Management System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A car rental company needs a system to organize its fleet of vehicles by tracking general vehicle details, car-specific information, and features for electric cars. This system allows rental agents to view detailed information on each vehicle type and assists in customer recommendations based on the vehicle type.

Using multilevel inheritance, the system has the following levels:

- Vehicle Class for storing basic vehicle information.
- Car Class extends Vehicle to include car-specific details.
- ElectricCar Class extends Car to add details specific to electric cars.

Program Specifications

Create a Vehicle class with the following attributes:

- String make: The make of the vehicle (e.g., Toyota).
- String model: The model of the vehicle (e.g., Camry).
- int year: The manufacturing year of the vehicle.
- Method displayVehicleInfo(): Displays general vehicle information.

Create a Car class extending Vehicle with additional attributes:

- int numberOfDoors: Number of doors on the car.
- String fuelType: Type of fuel (e.g., gasoline, diesel).
- Method displayCarInfo(): Displays car-specific information.

Create an ElectricCar class extending Car with additional attributes:

- int batteryCapacity: Battery capacity in kWh.
- int rangePerCharge: Range per charge in kilometers.
- Method displayElectricCarInfo(): Displays electric car-specific information.

Create a Main class to capture user input and display the vehicle details across inheritance levels.

 **Input Format** 

- First, the user is prompted to enter the make of the vehicle.
- The model of the vehicle.
- The manufacturing year.
- The number of doors.
- The fuel type (if the vehicle is an electric car, this should be "electric").
- The battery capacity in kWh.
- The range per charge in kilometers.

 **Constraints** 

NA

 **Output Format** 

The output should display:

- The general vehicle details.
- Car-specific details.
- Electric car-specific details (if applicable).

 **Sample Input 0** 

```
Toyota
Corolla
2020
4
gasoline

```

 **Sample Output 0** 

```
Enter the make of the vehicle:
Enter the model of the vehicle:
Enter the manufacturing year:
Enter the number of doors:
Enter the fuel type:
Vehicle Details:
Make: Toyota
Model: Corolla
Year: 2020
Car Details:
Number of Doors: 4
Fuel Type: gasoline

```

 **Sample Input 1** 

```
Nissan
Leaf
2019
4
electric
40
240

```

 **Sample Output 1** 

```
Enter the make of the vehicle:
Enter the model of the vehicle:
Enter the manufacturing year:
Enter the number of doors:
Enter the fuel type:
Enter the battery capacity in kWh:
Enter the range per charge in km:
Vehicle Details:
Make: Nissan
Model: Leaf
Year: 2019
Car Details:
Number of Doors: 4
Fuel Type: electric
Electric Car Details:
Battery Capacity: 40 kWh
Range Per Charge: 240 km

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T16:31:10.900Z  

```java
import java.util.*;

class Vehicle {
    String make;
    String model;
    int year;

    Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayVehicleInfo() {
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

class Car extends Vehicle {
    int numberOfDoors;
    String fuelType;

    Car(String make, String model, int year, int numberOfDoors, String fuelType) {
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    void displayCarInfo() {
        System.out.println("Car Details:");
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class ElectricCar extends Car {
    int batteryCapacity;
    int rangePerCharge;

    ElectricCar(String make, String model, int year, int numberOfDoors,
                String fuelType, int batteryCapacity, int rangePerCharge) {
        super(make, model, year, numberOfDoors, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.rangePerCharge = rangePerCharge;
    }

    void displayElectricCarInfo() {
        System.out.println("Electric Car Details:");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Range Per Charge: " + rangePerCharge + " km");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the make of the vehicle:");
        String make = sc.nextLine();

        System.out.println("Enter the model of the vehicle:");
        String model = sc.nextLine();

        System.out.println("Enter the manufacturing year:");
        int year = sc.nextInt();

        System.out.println("Enter the number of doors:");
        int numberOfDoors = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the fuel type:");
        String fuelType = sc.nextLine();

        if (fuelType.equalsIgnoreCase("electric")) {
            System.out.println("Enter the battery capacity in kWh:");
            int batteryCapacity = sc.nextInt();

            System.out.println("Enter the range per charge in km:");
            int rangePerCharge = sc.nextInt();

            ElectricCar car = new ElectricCar(
                make, model, year, numberOfDoors,
                fuelType, batteryCapacity, rangePerCharge
            );

            car.displayVehicleInfo();
            car.displayCarInfo();
            car.displayElectricCarInfo();

        } else {
            Car car = new Car(
                make, model, year, numberOfDoors, fuelType
            );

            car.displayVehicleInfo();
            car.displayCarInfo();
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/inheritance-vehicle-management-system/problem)