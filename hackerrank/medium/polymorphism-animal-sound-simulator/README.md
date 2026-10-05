# Polymorphism - Animal Sound Simulator

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The Animal Sound Simulator application demonstrates the concept of method overriding in Java. It allows users to interact with different animal types and hear their unique sounds. This is particularly useful for educational purposes, helping children learn about animals and the sounds they make.

Animal Classes: Different animal classes (e.g., Dog, Cat) will extend a base class (Animal) and override the sound method to provide specific sounds for each animal. Sound Playback: Users can create objects of different animal types and call the overridden method to simulate the animal's sound.

Program Specifications

Class: Animal (Base Class)

- Method:
- void sound(): This method will be overridden in derived classes to provide specific sounds.

Derived Classes:

Dog: - Overrides: void sound(): Outputs "Bark".

Cat: - Overrides: void sound(): Outputs "Meow".

Main Class: Main

- Contains the main method to demonstrate method overriding.
- Uses user input to choose an animal and display the corresponding sound.

 **Input Format** 

The user is prompted to select an animal from a list (e.g., Dog or Cat).

 **Constraints** 

NA

 **Output Format** 

The system displays the sound produced by the selected animal.

 **Sample Input 0** 

```
1

```

 **Sample Output 0** 

```
Welcome to the Animal Sound Simulator!
Select an animal:
1. Dog
2. Cat
Enter your choice (1-2): Bark

```

 **Sample Input 1** 

```
2

```

 **Sample Output 1** 

```
Welcome to the Animal Sound Simulator!
Select an animal:
1. Dog
2. Cat
Enter your choice (1-2): Meow

```

 **Sample Input 2** 

```
3

```

 **Sample Output 2** 

```
Welcome to the Animal Sound Simulator!
Select an animal:
1. Dog
2. Cat
Enter your choice (1-2): Invalid choice.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T03:30:29.243Z  

```java
import java.util.*;
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}
class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}
class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the Animal Sound Simulator!");
        System.out.println("Select an animal:");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.print("Enter your choice (1-2): ");
        int choice=sc.nextInt();
        Animal a;
        if(choice==1) {
            a=new Dog();
            a.sound();
        }
        else if(choice==2) {
            a=new Cat();
            a.sound();
        }
        else {
            System.out.println("Invalid choice.");
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/polymorphism-animal-sound-simulator/problem)