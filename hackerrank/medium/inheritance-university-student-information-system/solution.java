import java.util.*;

class Student {
    String name;
    int id;
    String department;

    void displayStudentInfo() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + department);
    }
}

class GraduateStudent extends Student {
    String thesisTopic;

    void displayThesisTopic() {
        System.out.println("Thesis Topic: " + thesisTopic);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the student's name:");
        String name = sc.nextLine();

        System.out.println("Enter the student ID:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the student's department:");
        String department = sc.nextLine();

        System.out.println("Enter the thesis topic:");
        String thesisTopic = sc.nextLine();

        GraduateStudent student = new GraduateStudent();

        student.name = name;
        student.id = id;
        student.department = department;
        student.thesisTopic = thesisTopic;

        student.displayStudentInfo();
        student.displayThesisTopic();
    }
}
