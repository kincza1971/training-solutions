package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<String> titles = new ArrayList<>();

    public List<String> findAllByPrefix(String prefix) {
        List<String> resultList = new ArrayList<>();
        for (String aBook : titles) {
            if (aBook.substring(0,prefix.length()).equals(prefix)) {
                resultList.add(aBook);
            }
        }
        return resultList;
    }

    public void removeByPrefix(String prefix) {
        List<String> resultList = new ArrayList<>();
        for (String aBook : titles) {
            if (aBook.substring(0, prefix.length()).equals(prefix)) {
                resultList.add(aBook);
            }
        }
        if (resultList.size() > 0) {
            titles.removeAll(resultList);
        }
    }


    public void add(String title) {
        titles.add(title);
    }

    public List<String> getTitles() {
        return titles;
    }

    public static void main(String[] args) {
        Books books = new Books();

        books.add("Haladó Java programozás");
        books.add("Haladó angol");
        books.add("Advanced Java programozás");
        books.add("Kezdő Java programozás");
        books.add("Haladó basic");
        books.add("Pinocchio unchained");

        System.out.println(books.getTitles());

        System.out.println(books.findAllByPrefix("Haladó").toString());

        books.removeByPrefix("Kezdő");
        System.out.println(books.getTitles());

    }
}
