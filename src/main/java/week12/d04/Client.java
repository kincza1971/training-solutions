package week12.d04;

public class Client {
    private String name;
    private String regNumber;

    private void checkString (String toCheck, String paramName) {
        if (toCheck == null || toCheck.isBlank()) {
            throw new IllegalArgumentException(paramName + " must not null or empty");
        }
    }


    public Client(String name, String regNumber) {
        checkString(name, "Client name ");
        checkString(regNumber, "Registration number ");
        this.name = name;
        this.regNumber = regNumber.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public String getRegNumber() {
        return regNumber;
    }
}

//A Client osztály reprezentál egy ügyfelet name és regNumber attribútummal (String). Az második a regisztrációs száma,
// mely egyedileg azonosít egy ügyfelet.  Írj egy Clients osztályt, mely az ügyfeleket tartja nyilván.
// Regisztrációs szám alapján le kell tudni kérdezni egy ügyfelet a findByRegNumber(String) metódussal.
// Dobjon IllegalArgumentException-t, ha nincs. Fontos, hogy nagyon gyors legyen a lekérdezés a regisztrációs szám alapján!
// Ezen kívül legyen benne egy List<Client> findByName(String) metódus is, ami pedig névtöredék alapján keres! Ez lehet lassabb.
