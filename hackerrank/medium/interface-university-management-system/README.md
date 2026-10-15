# Interface - University Management System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a university management system, both students and professors can enroll in courses and provide feedback. The system needs to manage these functionalities efficiently, allowing for multiple inheritance through interfaces.

Program Specifications

Create an interface named Enrollable:

- Define the following methods: void enrollInCourse(String courseName); void provideFeedback(String feedback);

Create another interface named Person:

- Define the following methods: String getName(); String getID();

Create two classes that implement these interfaces:

- Class Student: Member variables: String name, String studentID Implement methods from Enrollable and Person.
- Class Professor: Member variables: String name, String employeeID Implement methods from Enrollable and Person.

Create a class named Main:

- In the main method, create instances of Student and Professor.
- Demonstrate the functionality of enrolling in courses and providing feedback.

 **Input Format** 

- Student Name
- Student ID
- Course Name for Student
- Feedback from Student
- Professor Name
- Professor ID
- Course Name for Professor
- Feedback from Professor

 **Constraints** 

NA

 **Output Format** 

Confirmation messages for enrollment and feedback provided by both student and professor.

 **Sample Input 0** 

```
John
S001
Chemistry
Very challenging course!
Dr. Smith
P100
Organic Chemistry
Course requires detailed study.

```

 **Sample Output 0** 

```
Enter Student Name: Enter Student ID: Enter Course Name for Student: Student John with ID S001 has enrolled in the course: Chemistry.
Enter Feedback from Student: Student John provides feedback: Very challenging course!

Enter Professor Name: Enter Professor ID: Enter Course Name for Professor: Professor Dr. Smith with ID P100 has enrolled in the course: Organic Chemistry.
Enter Feedback from Professor: Professor Dr. Smith provides feedback: Course requires detailed study.

```

 **Sample Input 1** 

```
Emma
S002
Computer Science
Enjoyed the programming assignments.
Dr. Brown
P101
Data Structures
Students should focus on algorithms.

```

 **Sample Output 1** 

```
Enter Student Name: Enter Student ID: Enter Course Name for Student: Student Emma with ID S002 has enrolled in the course: Computer Science.
Enter Feedback from Student: Student Emma provides feedback: Enjoyed the programming assignments.

Enter Professor Name: Enter Professor ID: Enter Course Name for Professor: Professor Dr. Brown with ID P101 has enrolled in the course: Data Structures.
Enter Feedback from Professor: Professor Dr. Brown provides feedback: Students should focus on algorithms.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:19:08.658Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/interface-university-management-system/problem)