import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library implements Serializable {
    private static final long serialVersionUID = 4978985073481394526L;
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public static Book addBook(Scanner sc) {
            System.out.println("Введите название книги");
            String title = sc.next();
            System.out.println("Введите автора книги");
            String author = sc.next();
            int bookReleaseYear = 0;
            while (true) {
                try {
                    System.out.println("Введите год издания");
                    bookReleaseYear = Integer.parseInt(sc.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введен не год, введите год");
                }
            }

            return new Book(title, author, bookReleaseYear);
        }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static void showLibrary(Library library) {
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }
}
