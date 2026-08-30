import java.util.*;

class Laptop {
    String brandName;
    String processorName;
    String os;
    long processorRange;
    long ram;

    void displayLaptopDetails() {
        System.out.println("Laptop Details:");
        System.out.println("Laptop Brand: " + brandName);
        System.out.println("Processor Name: " + processorName);
        System.out.println("OS: " + os);
        System.out.println("Processor Range: " + processorRange + " bit");
        System.out.println("Ram: " + ram + " GB");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the brand of the laptop:");
        String brandName = sc.nextLine();

        System.out.println("Enter the processor of the laptop:");
        String processorName = sc.nextLine();

        System.out.println("Enter the OS of the laptop:");
        String os = sc.nextLine();

        System.out.println("Enter the processor range of the laptop:");
        long processorRange = sc.nextLong();

        System.out.println("Enter the ram size of the laptop:");
        long ram = sc.nextLong();

        if (processorRange <= 0 || ram <= 0) {
            System.out.println("Invalid Input");
        } else {
            Laptop laptop = new Laptop();

            laptop.brandName = brandName;
            laptop.processorName = processorName;
            laptop.os = os;
            laptop.processorRange = processorRange;
            laptop.ram = ram;

            laptop.displayLaptopDetails();
        }
    }
}
