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
