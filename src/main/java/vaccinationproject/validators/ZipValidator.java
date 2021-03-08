package vaccinationproject.validators;

import vaccinationproject.guis.MessagePrinter;
import vaccinationproject.mainfunctions.VaccinationService;

import java.util.function.Predicate;

public class ZipValidator implements Predicate<String> {
    private VaccinationService vaccinationService;
    private MessagePrinter mp;

    public ZipValidator(VaccinationService vaccinationService, MessagePrinter mp) {
        this.vaccinationService = vaccinationService;
        this.mp = mp;
    }

    @Override
    public boolean test(String s) {
        try {
            vaccinationService.checkZip(s);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IllegalStateException e) {
            mp.printRed("Ellenőrzés nem lehetséges, mert az irányítószám tábla üres");
            throw new IllegalStateException("Cities table is empty");
        }
    }
}
