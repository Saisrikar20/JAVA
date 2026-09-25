# Abstraction - Shape Volume Calculator in a 3D Design Tool

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a 3D design tool used for educational or architectural purposes, designers often need to calculate the volume of different 3D shapes, such as spheres, cubes, and cuboids. This helps in estimating material usage and object scaling. Using Java, we can create an abstraction that allows users to calculate the volume of various shapes. By providing an abstract base class and concrete implementations, we ensure a modular and scalable structure that can be expanded to include other shapes in the future.

Program Specifications

Abstract Class: Volume

Protected Attribute:

- String name - the name of the shape.

Constructor:

- Initializes the name attribute.

Abstract Method:

- Float calculateVolume(): an abstract method that subclasses must override to calculate their specific volume.

Concrete Classes:

VolumeOfSphere:

- Private Attribute: Integer radius
- Constructor: Initializes name and radius.
- Method: calculateVolume() - calculates the volume of a sphere using the formula V=4/3πr3 (where pi = 3.14).

VolumeOfCube:

- Private Attribute: Integer side
- Constructor: Initializes name and side.
- Method: calculateVolume() - calculates the volume of a cube using the formula V=s3

VolumeOfCuboid:

- Private Attributes: Integer length, breadth, height
- Constructor: Initializes name, length, breadth, and height.
- Method: calculateVolume() - calculates the volume of a cuboid using the formula V=l×b× h.

Main Class:

- The main() method accepts the shape name and its respective dimensions as input.
- Based on the shape type, the method creates an instance of the appropriate subclass and calls the calculateVolume() method.
- The program should validate that all dimension values are non-negative; if any value is negative, it outputs "Invalid Input."

 **Input Format** 

NA

 **Constraints** 

NA

 **Output Format** 

NA

 **Sample Input 0** 

```
Sphere
3

```

 **Sample Output 0** 

```
Enter the shape (Sphere, Cube, or Cuboid):
Enter the radius of the sphere:
The volume of the sphere is 113.04

```

 **Sample Input 1** 

```
Cube
4

```

 **Sample Output 1** 

```
Enter the shape (Sphere, Cube, or Cuboid):
Enter the side of the cube:
The volume of the cube is 64.00

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T03:18:14.824Z  

```java
import java.util.Scanner;

abstract class Volume {
    protected String name;
    
    Volume(String name) {
        this.name = name;
    }
    
    abstract Float calculateVolume();
}

class VolumeOfSphere extends Volume {
    private Integer radius;
    
    VolumeOfSphere(String name, Integer radius) {
        super(name);
        this.radius = radius;
    }
    
    Float calculateVolume() {
        return (float)(4.0 / 3.0 * 3.14 * radius * radius * radius);
    }
}

class VolumeOfCube extends Volume {
    private Integer side;
    
    VolumeOfCube(String name, Integer side) {
        super(name);
        this.side = side;
    }
    
    Float calculateVolume() {
        return (float)(side * side * side);
    }
}

class VolumeOfCuboid extends Volume {
    private Integer length, breadth, height;
    
    VolumeOfCuboid(String name, Integer length, Integer breadth, Integer height) {
        super(name);
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }
    
    Float calculateVolume() {
        return (float)(length * breadth * height);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the shape (Sphere, Cube, or Cuboid):");
        String shape = sc.nextLine();
        
        Volume volume;
        
        if(shape.equalsIgnoreCase("Sphere")) {
            System.out.println("Enter the radius of the sphere:");
            int radius = sc.nextInt();
            
            if(radius < 0) {
                System.out.println("Invalid Input.");
                return;
            }
            
            volume = new VolumeOfSphere(shape, radius);
            System.out.printf("The volume of the sphere is %.2f%n", volume.calculateVolume());
            
        }
        else if(shape.equalsIgnoreCase("Cube")) {
            System.out.println("Enter the side of the cube:");
            int side = sc.nextInt();
            
            if(side < 0) {
                System.out.println("Invalid Input.");
                return;
            }
            
            volume = new VolumeOfCube(shape, side);
            System.out.printf("The volume of the cube is %.2f%n", volume.calculateVolume());
            
        }
        else if(shape.equalsIgnoreCase("Cuboid")) {
            System.out.println("Enter the length of the cuboid:");
            int length = sc.nextInt();
            
            System.out.println("Enter the breadth of the cuboid:");
            int breadth = sc.nextInt();
            
            System.out.println("Enter the height of the cuboid:");
            int height = sc.nextInt();
            
            if(length < 0 || breadth < 0 || height < 0) {
                System.out.println("Invalid Input.");
                return;
            }
            
            volume = new VolumeOfCuboid(shape, length, breadth, height);
            System.out.printf("The volume of the cuboid is %.2f%n", volume.calculateVolume());
            
        }
        else {
            System.out.println("Invalid Input.");
        }
        
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/abstraction-shape-volume-calculator-in-a-3d-design-tool/problem)