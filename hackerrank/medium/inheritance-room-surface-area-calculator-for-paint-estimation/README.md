# Inheritance - Room Surface Area Calculator for Paint Estimation

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

An interior decorator wants to estimate the amount of paint required to cover the walls and ceiling in various rooms. Each room may have a different shape (rectangular, square, or circular). The decorator inputs the dimensions of each room to calculate its surface area. The area calculator application will prompt the user to select the shape of the room and input the relevant dimensions, then output the surface area.

Program Specifications

Base Class: Shape

Attributes:

- protected String shapeName: The name of the shape.

Methods:

- public Shape(String shapeName): Constructor to initialize the shape name.
- public Double calculateArea(): Returns 0 by default.

Derived Class: Square

Attributes:

- private Integer side: Length of one side of the square.

Methods:

- public Square(int side): Constructor to initialize the side and set the shape name.
- public Double calculateArea(): Calculates and returns the area of the square.

Derived Class: Rectangle

Attributes:

- private Integer length: Length of the rectangle.
- private Integer breadth: Breadth of the rectangle.

Methods:

- public Rectangle(int length, int breadth): Constructor to initialize the dimensions and set the shape name.
- public Double calculateArea(): Calculates and returns the area of the rectangle.

Derived Class: Circle

Attributes:

- private Integer radius: Radius of the circle.

Methods:

- public Circle(int radius): Constructor to initialize the radius and set the shape name.
- public Double calculateArea(): Calculates and returns the area of the circle.

 **Input Format** 

- User selects the shape by entering the corresponding number.
- For rectangles, the user inputs length and breadth.
- For squares, the user inputs the side length.
- For circles, the user inputs the radius.

 **Constraints** 

NA

 **Output Format** 

Displays the calculated area formatted to two decimal places.

 **Sample Input 0** 

```
1
150
75

```

 **Sample Output 0** 

```
1. Rectangle
2. Square
3. Circle
Area Calculator --- Choose your shape: Enter length and breadth: Area of Rectangle is: 11250.00

```

 **Sample Input 1** 

```
2
10

```

 **Sample Output 1** 

```
1. Rectangle
2. Square
3. Circle
Area Calculator --- Choose your shape: Enter side: Area of Square is: 100.00

```

 **Sample Input 2** 

```
3
12

```

 **Sample Output 2** 

```
1. Rectangle
2. Square
3. Circle
Area Calculator --- Choose your shape: Enter Radius: Area of Circle is: 452.39

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-12T14:59:29.040Z  

```java
import java.util.Scanner;

class Shape {
    protected String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public Double calculateArea() {
        return 0.0;
    }
}

class Square extends Shape {
    private Integer side;

    public Square(int side) {
        super("Square");
        this.side = side;
    }

    @Override
    public Double calculateArea() {
        return (double) (side * side);
    }
}

class Rectangle extends Shape {
    private Integer length;
    private Integer breadth;

    public Rectangle(int length, int breadth) {
        super("Rectangle");
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public Double calculateArea() {
        return (double) (length * breadth);
    }
}

class Circle extends Shape {
    private Integer radius;

    public Circle(int radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.print("Area Calculator --- Choose your shape: ");

        int choice = scanner.nextInt();

        Shape shape = null;

        switch (choice) {
            case 1:
                System.out.print("Enter length and breadth: ");
                int length = scanner.nextInt();
                int breadth = scanner.nextInt();
                shape = new Rectangle(length, breadth);
                break;

            case 2:
                System.out.print("Enter side: ");
                int side = scanner.nextInt();
                shape = new Square(side);
                break;

            case 3:
                System.out.print("Enter Radius: ");
                int radius = scanner.nextInt();
                shape = new Circle(radius);
                break;

            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        System.out.printf("Area of %s is: %.2f%n", shape.shapeName, shape.calculateArea());

        scanner.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/inheritance-room-surface-area-calculator-for-paint-estimation/problem)