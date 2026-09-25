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
