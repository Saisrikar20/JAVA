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
