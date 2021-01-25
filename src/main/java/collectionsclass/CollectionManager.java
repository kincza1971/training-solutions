package collectionsclass;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionManager {

    private List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library=library;
        library.sort(Comparator.naturalOrder());
    }
    public List<Book> createUnmodifiableLibrary() {  //módosíthatatlan listát eredményez
        return (List<Book>) Collections.unmodifiableCollection(library);
    }

    public List<Book> reverseLibrary() {  //az eredeti lista másolatán dolgozik!
        List<Book> reverselibrary = new ArrayList<>(library);
        Collections.reverse(reverselibrary);
        return reverselibrary;
    }
    public Book getFirstBook() { //a legrégebbi (legkisebb id) könyvet adja vissza
        return library.get(0);
    }

    public Book getLastBook() { // a legújabb (legnagyobb id) könyvet adja vissza
        return library.get(library.size()-1);
    }
}
