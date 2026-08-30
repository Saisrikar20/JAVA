# Class and Objects - Laptop Purchase Decision

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Alex and his friend Alicia are planning to purchase a new laptop. They want to compare different laptop models based on key specifications such as brand, processor, operating system, processor range, and RAM. To help them make an informed decision, we will create a program that captures the details of a laptop and displays it in a structured format. This will allow them to easily review the laptops they're considering.

 **Program Specifications** 

Create a class named Laptop: Attributes:

- String brandName: Stores the brand of the laptop.
- String processorName: Stores the processor name of the laptop.
- String os: Stores the operating system of the laptop.
- long processorRange: Stores the processor range (in bits).
- long ram: Stores the RAM size (in GB).

Methods:

- void displayLaptopDetails(): Displays the laptop's information in a structured format.

Create a class named Main:

- Purpose: Captures user input to create a Laptop object and then displays the laptop's details using the displayLaptopDetails() method.

 **Input Format** 

The program should prompt the user to enter the following details:

- First input: Brand of the laptop (String).
- Second input: Processor name of the laptop (String).
- Third input: OS of the laptop (String).
- Fourth input: Processor range of the laptop (long).
- Fifth input: RAM size of the laptop (long).

 **Constraints** 

NA

 **Output Format** 

- If the input is valid, the output should display the laptop details in the following format: Laptop Details:

Laptop Brand: [brandName]

Processor Name: [processorName]

OS: [os]

Processor Range: [processorRange] bit

Ram: [ram] GB

- If any input is invalid (e.g., processorRange and ram must be greater than zero), the output should display:Invalid Input

 **Sample Input 0** 

```
Dell
Intel Core i5-5675C
Windows
64
8

```

 **Sample Output 0** 

```
Enter the brand of the laptop:
Enter the processor of the laptop:
Enter the OS of the laptop:
Enter the processor range of the laptop:
Enter the ram size of the laptop:
Laptop Details:
Laptop Brand: Dell
Processor Name: Intel Core i5-5675C
OS: Windows
Processor Range: 64 bit
Ram: 8 GB

```

 **Sample Input 1** 

```
HP
AMD Ryzen 5
Linux
-32
4

```

 **Sample Output 1** 

```
Enter the brand of the laptop:
Enter the processor of the laptop:
Enter the OS of the laptop:
Enter the processor range of the laptop:
Enter the ram size of the laptop:
Invalid Input

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T16:00:34.325Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/class-and-objects-laptop-purchase-decision/problem)