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
