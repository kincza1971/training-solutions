package interacedefaultmethods.print;

public interface Printable {

    int getLength();
    String getPage(int pageNumber);
    default String getColor(int page) {
        return "#000000";
    }
    //Printable interfészt a getLength(), getPage(), és getColor() metódusokkal. A getColor() metódus default implementációja,
    // hogy mindig feketét ad vissza, ami az interfészben egy konstans #000000 érték.
}
