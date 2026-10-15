import java.io.*;
import java.util.*;

interface Enrollable {
    void enrollInCourse(String courseName);
    void provideFeedback(String feedback);
}

interface Person {
    String getName();
    String getID();
}

class Student implements Enrollable, Person {
    String name, studentID;

    Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return studentID;
    }

    public void enrollInCourse(String courseName) {
        System.out.println("Student " + name + " with ID " + studentID
                + " has enrolled in the course: " + courseName + ".");
    }

    public void provideFeedback(String feedback) {
        System.out.println("Student " + name + " provides feedback: " + feedback);
    }
}

class Professor implements Enrollable, Person {
    String name, employeeID;

    Professor(String name, String employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return employeeID;
    }

    public void enrollInCourse(String courseName) {
        System.out.println("Professor " + name + " with ID " + employeeID
                + " has enrolled in the course: " + courseName + ".");
    }

    public void provideFeedback(String feedback) {
        System.out.println("Professor " + name + " provides feedback: " + feedback);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Student ID: ");
        String studentID = sc.nextLine();

        System.out.print("Enter Course Name for Student: ");
        String studentCourse = sc.nextLine();

        Student student = new Student(studentName, studentID);
        student.enrollInCourse(studentCourse);

        System.out.print("Enter Feedback from Student: ");
        String studentFeedback = sc.nextLine();
        student.provideFeedback(studentFeedback);

        System.out.println();

        System.out.print("Enter Professor Name: ");
        String professorName = sc.nextLine();

        System.out.print("Enter Professor ID: ");
        String professorID = sc.nextLine();

        System.out.print("Enter Course Name for Professor: ");
        String professorCourse = sc.nextLine();

        Professor professor = new Professor(professorName, professorID);
        professor.enrollInCourse(professorCourse);

        System.out.print("Enter Feedback from Professor: ");
        String professorFeedback = sc.nextLine();
        professor.provideFeedback(professorFeedback);

        sc.close();
    }
}
