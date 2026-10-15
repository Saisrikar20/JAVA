# Abstraction - Library Management System for Book Details and Borrowing Status

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a library management system, we need to handle different types of books and their borrowing status. Here, the concept of abstraction allows us to define a generic book class and abstract methods for tracking different borrowing statuses (e.g., available, reserved, or borrowed). This abstraction is useful because we can define general methods in the parent class and provide specific implementations in each subclass.

Program Specifications

Abstract Class: Book

Protected Attributes:

- String title
- String author
- int yearPublished

Constructor:

- Initializes the title, author, and yearPublished attributes.

Abstract Method:

- void displayStatus(): Abstract method that will display the borrowing status of the book. Each subclass will implement this to provide a specific status.

Concrete Method:

- void displayBookInfo(): Displays the basic information about the book (title, author, and publication year).

Subclasses:

- AvailableBook: Implements displayStatus() method to show that the book is currently available.
- ReservedBook: Implements displayStatus() method to indicate the book is reserved.
- BorrowedBook: Implements displayStatus() method to show that the book is borrowed.

Class: LibraryManagement

- In the main() method, prompt the user to input book information, the year of publication, and the book's status.
- Based on the chosen status, create an object of the appropriate subclass.
- Display the book information and its status.

 **Input Format** 

The user inputs the book title, author, publication year, and status.

 **Constraints** 

NA

 **Output Format** 

The program displays the book information, followed by the borrowing status.

 **Sample Input 0** 

```
Moby Dick
Herman Melville
1851
1

```

 **Sample Output 0** 

```
Enter the book title:
Enter the author:
Enter the year of publication:
Select book status:
1. Available
2. Reserved
3. Borrowed
Book Information:
Title: Moby Dick
Author: Herman Melville
Year Published: 1851
Status: The book is available.

```

 **Sample Input 1** 

```
The Great Gatsby
F. Scott Fitzgerald
1925
2

```

 **Sample Output 1** 

```
Enter the book title:
Enter the author:
Enter the year of publication:
Select book status:
1. Available
2. Reserved
3. Borrowed
Book Information:
Title: The Great Gatsby
Author: F. Scott Fitzgerald
Year Published: 1925
Status: The book is reserved.

```

 **Sample Input 2** 

```
1984
George Orwell
1949
3

```

 **Sample Output 2** 

```
Enter the book title:
Enter the author:
Enter the year of publication:
Select book status:
1. Available
2. Reserved
3. Borrowed
Book Information:
Title: 1984
Author: George Orwell
Year Published: 1949
Status: The book is borrowed.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:42:51.584Z  

```java
import java.util.*;

abstract class Book {
    protected String title;
    protected String author;
    protected int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    abstract void displayStatus();

    public void displayBookInfo() {
        System.out.println("Book Information:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
    }
}

class AvailableBook extends Book {
    public AvailableBook(String title, String author, int yearPublished) {
        super(title, author, yearPublished);
    }

    @Override
    void displayStatus() {
        System.out.println("Status: The book is available.");
    }
}

class ReservedBook extends Book {
    public ReservedBook(String title, String author, int yearPublished) {
        super(title, author, yearPublished);
    }

    @Override
    void displayStatus() {
        System.out.println("Status: The book is reserved.");
    }
}

class BorrowedBook extends Book {
    public BorrowedBook(String title, String author, int yearPublished) {
        super(title, author, yearPublished);
    }

    @Override
    void displayStatus() {
        System.out.println("Status: The book is borrowed.");
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the book title:");
        String title = sc.nextLine();

        System.out.println("Enter the author:");
        String author = sc.nextLine();

        System.out.println("Enter the year of publication:");
        int yearPublished = sc.nextInt();

        System.out.println("Select book status:");
        System.out.println("1. Available");
        System.out.println("2. Reserved");
        System.out.println("3. Borrowed");

        int status = sc.nextInt();

        Book book;

        if (status == 1) {
            book = new AvailableBook(title, author, yearPublished);
        } else if (status == 2) {
            book = new ReservedBook(title, author, yearPublished);
        } else {
            book = new BorrowedBook(title, author, yearPublished);
        }

        book.displayBookInfo();
        book.displayStatus();

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/abstraction-library-management-system-for-book-details-and-borrowing-status/problem)