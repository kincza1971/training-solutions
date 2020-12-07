package interacedefaultmethods.print;

public class ColoredPage {

    private String page;
    private String color;

    public String getPage() {
        return page;
    }

    public String getColor() {
        return color;
    }

    public ColoredPage(String page, String color) {
        this.page = page;
        this.color = color;
    }
}
