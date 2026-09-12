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
