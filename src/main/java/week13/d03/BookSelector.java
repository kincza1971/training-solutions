package week13.d03;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class BookSelector {

    private String findAuthorWithMostPages(Map<String, Integer> authorMap) {
        int maxPages = 0;
        String author = null;
        for (Map.Entry<String, Integer> entry : authorMap.entrySet()) {
            if (entry.getValue() > maxPages) {
                maxPages= entry.getValue();
                author = entry.getKey();
            }
        }
        return author;
    }


    public String getAuthorWithMostPages(List<Book> books) {
        Map <String,Integer> authorMap = new TreeMap<>();
        for (Book book : books) {
            addBookToMap(authorMap, book);
        }
        return findAuthorWithMostPages(authorMap);
    }

    private void addBookToMap(Map<String, Integer> authorMap, Book book) {
        if (authorMap.containsKey(book.getAuthor())) {
            authorMap.put(book.getAuthor(), authorMap.get(book.getAuthor()) + book.getNumberOfPage());
        } else {
            authorMap.put(book.getAuthor(), book.getNumberOfPage());
        }
    }
}
