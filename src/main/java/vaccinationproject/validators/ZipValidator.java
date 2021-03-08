package vaccinationproject.validators;

import vaccinationproject.dao.CitizenDao;

import java.util.function.Predicate;

public class ZipValidator implements Predicate<String> {
    private final CitizenDao dao;

    public ZipValidator(CitizenDao dao) {
        this.dao = dao;
    }


    @Override
    public boolean test(String s) {
        try {
            return !dao.getZipsByZipcode(s).isEmpty();
        } catch (IllegalArgumentException e) {
            return false;
        } catch (IllegalStateException e) {
            return false;
        }
    }
}
