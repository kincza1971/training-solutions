package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{
    private final String title;
    private final List<String> composers;
    private final int length;
    private final List<String> performers;

    private void checkTittle(String tittle) {
        if (Validators.isBlank(tittle)) {
            throw new IllegalArgumentException("Tittle cannot be null or empty (" + tittle + ")");
        }
    }

    private void checkLength(int length) {
        if (length<1) {
            throw new IllegalArgumentException("Length cannot be less than 1 (" + length +")");
        }
    }

    private void checkComposers (List<String> composers) {
        if (Validators.isEmpty(composers)) {
            throw new IllegalArgumentException("List of composers cannot be null or empty");
        }
    }

    private void checkPerformers (List<String> performers) {
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("List of performers cannot be null or empty");
        }
    }

    private void checkValidation(String tittle, int length, List<String> performers, List<String> composers) {
        checkTittle(tittle);
        checkComposers(composers);
        checkLength(length);
        checkPerformers(performers);
    }

    private void checkValidation(String tittle, int length, List<String> performers) {
        checkTittle(tittle);
        checkLength(length);
        checkPerformers(performers);
    }

    public int getLength() {
        return length;
    }

    public AudioFeatures(String tittle, int length, List<String> performers) {
        checkValidation(tittle,length,performers);
        this.title = tittle;
        this.composers = null;
        this.length = length;
        this.performers = performers;
    }

    public AudioFeatures(String tittle, int length, List<String> performers, List<String> composers) {
        checkValidation(tittle, length, performers, composers);
        this.title = tittle;
        this.composers = composers;
        this.length = length;
        this.performers = performers;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        if ((composers!=null)) {
            result.addAll(composers);
        }
        result.addAll(performers);
        return List.copyOf(result);
    }


}
