import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    List<Book> books;

    public Library() {

        this.books = new ArrayList<>();
    }

    public Library(List<Book> books)
    {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
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
