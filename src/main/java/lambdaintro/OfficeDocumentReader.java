package lambdaintro;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class OfficeDocumentReader {
    private static final String REGEXP = ".*\\.(docx|xlsx|pptx)$";

    public List<File> listOfficeDocuments(File path) {
        List<File> files= Arrays.asList(path.listFiles(a -> a.isFile() && a.toString().matches(REGEXP)));
        files.sort(Comparator.comparing(File::getName));
        return files;
    }

    //OfficeDocumentReader osztályt, abba egy List<File> listOfficeDocuments(File path) metódust,
    // mely visszaadja a paraméterként átadott könyvtárban található összes docx, pptx és xlsx kiterjesztésű fájlt,
    // név szerint sorbarendezve.
}
