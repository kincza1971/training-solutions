package interacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable{

    private List<String> pages = new ArrayList<>();

    @Override
    public int getLength() {
        return pages.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return pages.get(pageNumber);
    }
}
