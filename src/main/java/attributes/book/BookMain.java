package attributes.book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("So long and thanks for all the fish");
        book.setTitle("Hitch hiker's guide to the Galaxy");
        System.out.println(book.getTitle());
    }
}
