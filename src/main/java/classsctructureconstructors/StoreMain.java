package classsctructureconstructors;

import java.sql.SQLOutput;

public class StoreMain {
    public static void main(String[] args) {
        Store store = new Store("Sarló");
        Store store2 = new Store("Kalapács");

        System.out.println(store.getProduct() + "; " + store.getStock());
        System.out.println(store2.getProduct() + "; " + store2.getStock());

        store.store(19);
        store2.store(21);

        System.out.println(store.getProduct() + "; " + store.getStock());
        System.out.println(store2.getProduct() + "; " + store2.getStock());

        store.dispatch(7);
        store2.dispatch(19);

        System.out.println(store.getProduct() + "; " + store.getStock());
        System.out.println(store2.getProduct() + "; " + store2.getStock());

    }
}
