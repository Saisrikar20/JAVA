# Inheritance - University Student Information System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The university wants to maintain basic details of students along with specific information about graduate students. The base class, Student, holds general information about all students, while the derived class GraduateStudent adds specific information relevant to graduate students.

Program Specifications

Create a class named Student to store general student information:

String name: Name of the student.

- int id: Student ID number.
- String department: Department of the student.
- Include a method named displayStudentInfo() to print the student's general information.

Create a class named GraduateStudent that extends Student with an additional attribute:

- String thesisTopic: The topic of the thesis for graduate students.
- Include a method named displayThesisTopic() to print the graduate student's thesis topic.

Create a Main class to capture user input for a graduate student, including their thesis topic, and display their details.

 **Input Format** 

- First, the user is prompted to enter the student's name (String).
- Next, the user is asked to enter the student ID (Integer).
- The user is prompted to enter the student's department (String).
- Finally, the user is asked to enter the thesis topic of the graduate student (String).

 **Constraints** 

NA

 **Output Format** 

- The output should display the student's general details first, followed by the thesis topic.
- Each label and its corresponding value should be separated by a colon (:) and a space.
- The output should print on separate lines.

 **Sample Input 0** 

```
John Doe
10001
Biology
Genetics and Evolution

```

 **Sample Output 0** 

```
Enter the student's name:
Enter the student ID:
Enter the student's department:
Enter the thesis topic:
Student Details:
Name: John Doe
ID: 10001
Department: Biology
Thesis Topic: Genetics and Evolution

```

 **Sample Input 1** 

```
Mary Smith
20002
Mathematics
Algebraic Topology Applications

```

 **Sample Output 1** 

```
Enter the student's name:
Enter the student ID:
Enter the student's department:
Enter the thesis topic:
Student Details:
Name: Mary Smith
ID: 20002
Department: Mathematics
Thesis Topic: Algebraic Topology Applications

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T16:09:09.550Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/inheritance-university-student-information-system/problem)