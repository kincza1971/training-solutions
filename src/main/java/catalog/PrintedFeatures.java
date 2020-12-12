package catalog;

import java.util.List;

public class PrintedFeatures implements Feature{

    private List<String> authors;
    private int numberOfPages;
    private String title;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        return List.copyOf(authors);
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getTittle() {
        return title;
    }

    private void checkTittle(String tittle) {
        if (Validators.isBlank(tittle)) {
            throw new IllegalArgumentException("Empty title");
        }
    }

    private void checkNumberOfPages(int numberOfPages) {
        if (numberOfPages<1) {
            throw new IllegalArgumentException("Length cannot be less than 1 (" + numberOfPages +")");
        }
    }

    private void checkAuthors (List<String> authors) {
        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("List of composers cannot be null or empty");
        }
    }


    private void checkValidation(String tittle, int numberOfPages, List<String> authors) {
        checkTittle(tittle);
        checkNumberOfPages(numberOfPages);
        checkAuthors(authors);
    }

    public PrintedFeatures( String tittle, int numberOfPages, List<String> authors) {
        checkValidation(tittle,numberOfPages,authors);
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = tittle;
    }
}
