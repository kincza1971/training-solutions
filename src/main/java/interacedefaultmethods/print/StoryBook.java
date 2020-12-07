package interacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable{


    List<ColoredPage> pages = new ArrayList<>();

    @Override
    public String getColor(int pageNumber) {
        return pages.get(pageNumber).getColor();
    }

    @Override
    public int getLength() {
        return pages.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return pages.get(pageNumber).getPage();
    }

}
