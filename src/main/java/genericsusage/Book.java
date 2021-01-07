package genericsusage;

public class Book {
    private String title;
    private String author;

    public Book(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Not a book");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
