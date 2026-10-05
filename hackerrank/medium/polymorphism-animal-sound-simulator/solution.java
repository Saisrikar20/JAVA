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
