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
