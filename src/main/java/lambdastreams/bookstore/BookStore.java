package lambdastreams.bookstore;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public int getNumberOfBooks() {
        return books.stream().mapToInt(Book::getStock).sum();
    }

    public Optional<Book> findNewestBook() {
        OptionalInt optionalInt;
        optionalInt = books.stream().mapToInt(Book::getYearOfPublish).max();
        if (optionalInt.isPresent()) {
            return books.stream().filter(m-> m.getYearOfPublish()==optionalInt.getAsInt()).findFirst();
        }
        return Optional.empty();
    }

    public int getTotalValue() {
        return books.stream().mapToInt(Book::getStockValue).sum();
    }

    public List<Book> getByYearOfPublish(int year) {
        List<Book> result = books.stream()
                                .filter(m -> (m.getYearOfPublish()==year))
                                .collect(Collectors.toList());
        if (result.size() >0) {
            return result;
        }else {
            return null;
        }
    }

    public List<Book> getBooksByYearOfPublish(int year) {
        Map<Integer,List<Book>> booksByYearOfPublish =
                books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish));
        return booksByYearOfPublish.get(year);
    }
}
