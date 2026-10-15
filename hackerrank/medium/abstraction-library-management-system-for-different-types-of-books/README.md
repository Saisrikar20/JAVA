# Abstraction - Library Management System for Different Types of Books

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a library, books are categorized into different types, such as Reference Books and Regular Books. Each type of book has specific characteristics. For example, Reference Books are not available for borrowing, while Regular Books can be borrowed. Using abstraction, we can define a general Book class with common book attributes and methods, and then use specific subclasses for each type of book with their own behaviors.

Program Specifications

Abstract Class: Book

Protected Attributes:

- String title
- String author

Constructor:

- Initializes title and author attributes.

Abstract Method:

- void displayInfo(): Abstract method that will be implemented in each subclass to display the information based on the book type.

Subclasses:

- ReferenceBook: Implements displayInfo() to indicate that the book is only available for in-library use.
- RegularBook: Implements displayInfo() to show that the book can be borrowed.

Class: Library

- In the main() method, prompt the user to input details of the book and specify its type.
- Based on the selected book type, create an instance of the appropriate subclass.
- Call the displayInfo() method to display book details.

 **Input Format** 

The user inputs the book type (Reference or Regular), title, and author.

 **Constraints** 

NA

 **Output Format** 

The program displays information about the book, including its title, author, and availability status.

 **Sample Input 0** 

```
1
The Art of Computer Programming
Donald E. Knuth

```

 **Sample Output 0** 

```
Enter book type (1 for Reference, 2 for Regular):
Enter book title:
Enter author name:
Book Title: The Art of Computer Programming
Author: Donald E. Knuth
Availability: In-library use only

```

 **Sample Input 1** 

```
2
To Kill a Mockingbird
Harper Lee

```

 **Sample Output 1** 

```
Enter book type (1 for Reference, 2 for Regular):
Enter book title:
Enter author name:
Book Title: To Kill a Mockingbird
Author: Harper Lee
Availability: Available for borrowing

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:37:44.371Z  

```java
import java.util.*;

abstract class Book {
    protected String title;
    protected String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void displayInfo();
}

class ReferenceBook extends Book {
    public ReferenceBook(String title, String author) {
        super(title, author);
    }

    @Override
    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: In-library use only");
    }
}

class RegularBook extends Book {
    public RegularBook(String title, String author) {
        super(title, author);
    }

    @Override
    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: Available for borrowing");
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter book type (1 for Reference, 2 for Regular):");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter book title:");
        String title = sc.nextLine();

        System.out.println("Enter author name:");
        String author = sc.nextLine();

        Book book;

        if (type == 1) {
            book = new ReferenceBook(title, author);
        } else {
            book = new RegularBook(title, author);
        }

        book.displayInfo();
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/abstraction-library-management-system-for-different-types-of-books/problem)