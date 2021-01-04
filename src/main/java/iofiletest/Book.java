package iofiletest;

public class Book {
    private final String author;
    private final String title;

    public boolean isEqual(Book book) {
        return getBookData().toLowerCase().equals(book.getBookData().toLowerCase());
    }

    public String getBookData() {
        return author+";"+title;
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }
}
