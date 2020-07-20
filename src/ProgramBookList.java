import java.io.*;
import java.util.Scanner;


public class ProgramBookList {
    public static void main(String[] args) {
        String libraryFileName = "BooksList.txt";
        Library library = deSerializeLibrary(libraryFileName);
        Scanner sc = new Scanner(System.in);

        deSerializeLibrary(libraryFileName);

        boolean exit = false;
        do {
            System.out.println("1 - добавить книгу");
            System.out.println("2 - показывать список книг");
            System.out.println("3 - выход");
            switch (sc.nextInt()) {
                case 1: {
                    library.addBook(addBook(sc));
                }
                break;
                case 2:
                    Library.showLibrary(library);
                    break;
                case 3:
                    exit = true;
                    break;
            }
        } while (!exit);

        serializeLibrary(library, libraryFileName);
    }

    public static Book addBook(Scanner sc) {
        System.out.println("Введите название книги");
        String title = sc.next();
        System.out.println("Введите автора книги");
        String author = sc.next();
        int bookYear = 0;
        while (true) {
            try {
                System.out.println("Введите год издания");
                bookYear = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введен не год, введите год");
            }
        }
        return new Book(title, author, bookYear);
    }

    private static Library deSerializeLibrary(String libraryFileName) {
        Library library = new Library();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(libraryFileName))) {
            library = (Library) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("В библиотеке нет книг");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return library;
    }

    private static void serializeLibrary(Library library, String file) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            os.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
