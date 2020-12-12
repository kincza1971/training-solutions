package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {
    private final List<Feature> features;
    private final int price;
    private final String registrationNumber;

    private PrintedFeatures getPrintedFeature() {
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                return ((PrintedFeatures) feature);
            };
        }
        return null;
    }

    public boolean hasAudioFeature() {
        for (Feature feature : features) {
            if(feature instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }
    public boolean hasPrintedFeature() {
        for (Feature feature : features) {
            if(feature instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    private List<AudioFeatures> getAudioFeatures() {
        List<AudioFeatures> result = new ArrayList<>();
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                result.add((AudioFeatures) feature);
            };
        }
        return result;
    }


    public int fullLengthAtOneItem() {
        List<AudioFeatures> afs = getAudioFeatures();
        int fulLength = 0;
        for (AudioFeatures audioFeatures : afs) {
            fulLength += audioFeatures.getLength();
        }
        return fulLength;
    }

    public int numberOfPagesAtOneItem() {
        PrintedFeatures pf = getPrintedFeature();
        if ( pf == null) {
            return 0;
        }
        return pf.getNumberOfPages();
    }

//    public int numberOfPagesAtOneItem() {
//        List<PrintedFeatures> pfs = getPrintedFeatures();
//        int result = 0;
//        for (PrintedFeatures pf : pfs) {
//            result += pf.getNumberOfPages();
//        }
//        return result;
//    }

    public String getTitle() {
        return features.get(0).getTitle();
    }

    private List<PrintedFeatures> getPrintedFeatures() {
        List<PrintedFeatures> result = new ArrayList<>();
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                result.add((PrintedFeatures) feature);
            };
        }
        return result;
    }

    public List<String> getTitles() {
        List<String> result = new ArrayList<>();
        for (Feature pf : features) {
            result.add(pf.getTitle());
        }
        return result;
    }

    public List<String> getContributors() {
        List <String> result = new ArrayList<>();
        for (Feature f : features) {
            result.addAll(f.getContributors());
        }
        return List.copyOf(result);
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
    private void checkRegistrationNumber(String tittle) {
        if (Validators.isBlank(tittle)) {
            throw new IllegalArgumentException("Empty registration number");
        }
    }

    private void checkPrice(int numberOfPages) {
        if (numberOfPages<1) {
            throw new IllegalArgumentException("Length cannot be less than 1 (" + numberOfPages +")");
        }
    }

    private void checkFeatures (List<Feature> features) {
        if (Validators.isEmpty(features)) {
            throw new IllegalArgumentException("List of composers cannot be null or empty");
        }
    }

    private void checkValidation(int price, String registrationNumber, List<Feature> features) {
        checkFeatures(features);
        checkPrice(price);
        checkRegistrationNumber(registrationNumber);

    }

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        checkValidation(price, registrationNumber, Arrays.asList(features));
        this.features = Arrays.asList(features);
        this.price = price;
        this.registrationNumber = registrationNumber;
    }
}
