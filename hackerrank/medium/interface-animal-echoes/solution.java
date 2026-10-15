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
