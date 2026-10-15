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
