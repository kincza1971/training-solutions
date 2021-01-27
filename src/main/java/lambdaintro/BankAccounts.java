package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

    private List<BankAccount> accounts;

    private List<BankAccount> sortAccounts(Comparator<BankAccount> comparator) {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(comparator);
        return sorted;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.naturalOrder());
        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.comparing((a) -> Math.abs(a.getBalance())));
        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return sorted;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        sorted.sort(Comparator.comparing(
                BankAccount::getNameOfOwner,Comparator.nullsFirst(collator))
                .thenComparing(BankAccount::getAccountNumber));
        return sorted;
    }

    public BankAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }
}

//A metódusok rendre új listát készítenek, rendezik a következő szabályok alapján, és adják vissza.
//
//Rendezés bankszámlaszám alapján
//Rendezés rendelkezésre álló összeg alapján, de előjeltől függetlenül
//Rendezés rendelkezésre álló összeg alapján, az előjel számítson, de csökkenő sorrendben
//Név alapján, de ha a név megegyezik, akkor bankszámlaszám alapján. Amennyiben nincs kitöltve a név (értéke null, elől szerepeljen)
//Implementációs javaslat
//Kizárólag lambda kifejezéseket vagy method reference-eket használj.
//
//Használd a következő metódusokat (persze a megfelelő paraméterezéssel):
// Comparator.naturalOrder(), Comparator.comparing(), Comparator.reversed(), Comparator.nullsFirst(), Comparator.thenComparing().
//
//[rating feedback=java-lambdaintro-bankszamlak]
