package catalog;

public class SearchCriteria {
    private String contributor;
    private String title;

    public boolean hasContributor() {
        return !Validators.isBlank(contributor);
    }

    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }

    public static SearchCriteria createByBoth(String title,String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Contributor cannot be null or empty");
        }
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        return new SearchCriteria(contributor,title);
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        return new SearchCriteria(null,title);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Contributor cannot be null or empty");
        }
        return new SearchCriteria(contributor,null);
    }

    private SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
}
