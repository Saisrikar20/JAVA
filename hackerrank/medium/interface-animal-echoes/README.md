# Interface - Animal Echoes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine a classroom where students are learning about different animals and the sounds they make. To make the learning process engaging, we will create an interface called Animal that defines the behavior of animals, specifically the ability to make a sound. Students will implement this interface in different classes representing various animals, allowing them to understand the concept of interfaces in Java.

Program Specifications

Interface: Animal

Methods:

- void makeSound(); - This method will be implemented by different animal classes to provide their specific sounds.

Implementing Classes:

Dog - Implements the Animal interface.

Methods:

- makeSound() - Outputs "Woof!" to represent the sound a dog makes.

Cat - Implements the Animal interface.

Methods:

- makeSound() - Outputs "Meow!" to represent the sound a cat makes.

Cow - Implements the Animal interface.

Methods:

- makeSound() - Outputs "Moo!" to represent the sound a cow makes.

Driver Class: Main

- The main method will create instances of each animal and call their makeSound() method to demonstrate polymorphism and interface implementation.

 **Input Format** 

No user input is required in this simple program; the program will automatically create and use instances of the animal classes.

 **Constraints** 

NA

 **Output Format** 

Display the sound made by each animal.

 **Sample Output 0** 

```
The dog goes: Woof!
The cat goes: Meow!
The cow goes: Moo!

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:34:17.949Z  

```java
import java.util.*;

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("The dog goes: Woof!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("The cat goes: Meow!");
    }
}

class Cow implements Animal {
    public void makeSound() {
        System.out.println("The cow goes: Moo!");
    }
}

public class Solution {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal cow = new Cow();

        dog.makeSound();
        cat.makeSound();
        cow.makeSound();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/interface-animal-echoes/problem)