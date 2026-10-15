# Encapsulation - Library Book Organizer

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A library needs a system to manage its book inventory. Each book in the library has details including the title, author, ISBN number, publication year, and genre. The system should encapsulate these details within a class to restrict direct access and display the book details in a structured format using toString() and String.format().

Program Specifications

Create a class named Book:

Attributes (Private):

- String title: Stores the title of the book.
- String author: Stores the author of the book.
- String isbn: Stores the ISBN number of the book.
- int publicationYear: Stores the year the book was published.
- String genre: Stores the genre of the book.

Constructors:

- Parameterized Constructor: Initializes all attributes when a new book is created.

Methods:

- public String getTitle(): Returns the title of the book.
- public String getAuthor(): Returns the author’s name.
- public String getIsbn(): Returns the ISBN of the book.
- public int getPublicationYear(): Returns the publication year.
- public String getGenre(): Returns the genre of the book.
- public String toString(): Overrides toString() to display book details using String.format() in a structured format.

Create a class named Main:

- Purpose: Captures user input to create a Book object and displays the book’s details using toString().

 **Input Format** 

The program should prompt the user to enter the following details:

1.Book Title (String).

2.Author’s Name (String).

3.ISBN Number (String).

4.Publication Year (int).

5.Genre (String).

 **Constraints** 

NA

 **Output Format** 

Display the book details using the toString() method, with each detail formatted on a new line.

The format should be:

Book Details:

Title: [title]

Author: [author]

ISBN: [isbn]

Publication Year: [publicationYear]

Genre: [genre]

 **Sample Input 0** 

```
Pride and Prejudice
Jane Austen
9780141199078
1813
Fiction

```

 **Sample Output 0** 

```
Enter the book title:
Enter the author's name:
Enter the ISBN number:
Enter the publication year:
Enter the genre:
Book Details:
Title: Pride and Prejudice
Author: Jane Austen
ISBN: 9780141199078
Publication Year: 1813
Genre: Fiction

```

 **Sample Input 1** 

```
Dune
Frank Herbert
9780441013593
1965
Science Fiction

```

 **Sample Output 1** 

```
Enter the book title:
Enter the author's name:
Enter the ISBN number:
Enter the publication year:
Enter the genre:
Book Details:
Title: Dune
Author: Frank Herbert
ISBN: 9780441013593
Publication Year: 1965
Genre: Science Fiction

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:35:27.645Z  

```java
import java.io.*;
import java.util.*;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private String genre;

    public Book(String title, String author, String isbn, int publicationYear, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format(
            "Book Details:%nTitle: %s%nAuthor: %s%nISBN: %s%nPublication Year: %d%nGenre: %s",
            title, author, isbn, publicationYear, genre
        );
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the book title:");
        String title = sc.nextLine();

        System.out.println("Enter the author's name:");
        String author = sc.nextLine();

        System.out.println("Enter the ISBN number:");
        String isbn = sc.nextLine();

        System.out.println("Enter the publication year:");
        int publicationYear = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the genre:");
        String genre = sc.nextLine();

        Book book = new Book(title, author, isbn, publicationYear, genre);
        System.out.println(book);

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/encapsulation-library-book-organizer/problem)