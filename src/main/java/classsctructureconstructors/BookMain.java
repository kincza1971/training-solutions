package classsctructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book1=new Book("Szabó Magda","Ókút");
        Book book2=new Book("Orvos-Tóth Noémi","Bennünk kódolt jövő");
        System.out.println(book1.getBookData());
        System.out.println(book2.getBookData());
        book1.register("Sz48/2020");
        book2.register("O19/2020");
        System.out.println(book1.getBookData());
        System.out.println(book2.getBookData());
        System.out.println(book1.getAuthor()+"; "+book1.getTitle()+"; "+book1.getRegNumber());
        System.out.println(book2.getAuthor()+"; "+book2.getTitle()+"; "+book2.getRegNumber());
    }
}
