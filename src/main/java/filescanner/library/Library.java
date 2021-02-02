package filescanner.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    List<Book> books = new ArrayList<>();

    public void loadFromFile() {
        try (Scanner loader = new Scanner(Library.class.getResourceAsStream("/books.csv")).useDelimiter(";|(\\r\\n)")) {
            String aBook;
            String[] data;// = new String[4];
            while (loader.hasNextLine()) {
                aBook=loader.nextLine();
                data = aBook.split(";");
                try {
                    books.add(new Book(data[0],data[1],data[2],Integer.parseInt(data[3])));
                } catch (Exception ex) {
                    System.out.println("hibás sor" + data);
                }
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
