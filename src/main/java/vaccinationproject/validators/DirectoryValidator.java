package vaccinationproject.validators;

import java.io.File;
import java.util.function.Predicate;

public class DirectoryValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        File file = new File(s);
        return file.isDirectory();
    }

}

