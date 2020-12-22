package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog_save {
    private List<CatalogItem> catalogItems = new ArrayList<>();

    private boolean isFulFillTitleCriteria(CatalogItem catalogItem,SearchCriteria searchCriteria){
        if (searchCriteria.hasTitle()) {
            List<String> titles = catalogItem.getTitles();
            String title = searchCriteria.getTitle();
            return titles.contains(title);
        }
        return false;
    }

    private boolean isFulFillContributorCriteria(CatalogItem catalogItem, SearchCriteria searchCriteria) {
        if (searchCriteria.hasContributor()){
            return  (catalogItem.getContributors().contains(searchCriteria.getContributor()));
        }
        return false;
    }

    private boolean fulFillCriteria(CatalogItem catalogItem, SearchCriteria searchCriteria){
        return isFulFillContributorCriteria(catalogItem,searchCriteria) || isFulFillTitleCriteria(catalogItem, searchCriteria);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> selected = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (fulFillCriteria(catalogItem, searchCriteria)) {
                selected.add(catalogItem);
            }
        }
        return List.copyOf(selected);
    }

    public int getFullLength() {
        List<CatalogItem> audioItems = getAudioLibraryItems();
        int fullLength=0;
        for (CatalogItem catalogItem : audioItems) {
            fullLength += catalogItem.fullLengthAtOneItem();
        }
        return fullLength;
    }

    private void checkNumberParam(int param) {
        if (param <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
    }

    private void checkCounter(int counter) {
       if (counter == 0) {
           throw new IllegalArgumentException("No page");
       }

    }

    public double averagePageNumberOver(int minimum){
        checkNumberParam(minimum);
        List<CatalogItem> printedItems = getPrintedLibraryItems();
        int counter = 0;
        int sumPages = 0;
        int pages;
        for (CatalogItem printedItem : printedItems) {
            pages = printedItem.numberOfPagesAtOneItem();
            if (pages>minimum) {
                counter ++;
                sumPages += pages;
            }
        }
        checkCounter(counter);
        return (double) sumPages/counter;
    }

    public int getAllPageNumber() {
        int pageNumber = 0;
        for (CatalogItem catalogItem : catalogItems) {
            pageNumber += catalogItem.numberOfPagesAtOneItem();
        }
        return pageNumber;
    }

    public List<CatalogItem> getAudioLibraryItems(){
        List<CatalogItem> audioLibraryItems = new ArrayList<>();
        for(CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                audioLibraryItems.add(catalogItem);
            }
        }
        return List.copyOf(audioLibraryItems);
    }

    public List<CatalogItem> getPrintedLibraryItems(){
        List<CatalogItem> printedLibraryItems = new ArrayList<>();
        for(CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                printedLibraryItems.add(catalogItem);
            }
        }
        return List.copyOf(printedLibraryItems);
    }


    private void checkRegNum(String regNum) {
        if (Validators.isBlank(regNum)) {
            throw new IllegalArgumentException("Registration Number cannot be null or empty");
        }
        if (Validators.isEmpty(catalogItems)) {
            throw new IllegalStateException("Catalog is empty");
        }
    }


    public void deleteItemByRegistrationNumber(String regNum) {
        checkRegNum(regNum);
        for (CatalogItem ci : catalogItems) {
            if (ci.getRegistrationNumber().equals(regNum)) {
                catalogItems.remove(ci);
                break;
            }
        }
    }

    private void checkItemValidation(CatalogItem item) {
        if (item == null) {
            throw new  IllegalArgumentException("Item cannot be null");
        }
    }

    public void addItem(CatalogItem item) {
        checkItemValidation(item);
        catalogItems.add(item);
    }

    public List<CatalogItem> getCatalogItems() {
        return List.copyOf(catalogItems);
    }
}
