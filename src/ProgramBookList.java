import java.io.*;
import java.util.Scanner;


public class ProgramBookList {
    public static void main(String[] args) {
        String libraryFileName = "BooksList.txt";
        Library library = serializeLibrary(libraryFileName);
        Scanner sc = new Scanner(System.in);

        serializeLibrary(libraryFileName);

        boolean exit = false;
        do {
            System.out.println("1 - добавить книгу");
            System.out.println("2 - показывать список книг");
            System.out.println("3 - выход");
            switch (sc.nextInt()) {
                case 1: {
                    library.addBook(Library.addBook(sc));
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

        serializeYourLibrary(library, libraryFileName);
    }

    private static Library serializeLibrary(String libraryFileName) {
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

    private static void serializeYourLibrary(Library library, String file) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            os.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
