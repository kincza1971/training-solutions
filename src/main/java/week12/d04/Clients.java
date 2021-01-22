package week12.d04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Clients {
    Map<String,Client> clientMap = new TreeMap<>();


    public Client findByRegNumber(String regNumber) {
        checkString(regNumber, "registration number ");
        Client client;
        client = clientMap.get(regNumber.toUpperCase());
        if (client == null) {
            throw new IllegalArgumentException("Registration number does not exists");
        }
        return client;
    }

    public List<Client> findByName(String namePart) {
        checkString(namePart, "Name part ");
        List<Client> foundList = new ArrayList<>();
        for (Client client : clientMap.values()) {
            if (client.getName().toUpperCase().contains(namePart.toUpperCase())) {
                foundList.add(client);
            }
        }
        if (foundList.isEmpty()) {
            throw new IllegalArgumentException("Client not found with this name part");
        }
        return foundList;
    }

    private void checkString (String toCheck, String paramName) {
        if (toCheck == null || toCheck.isBlank()) {
            throw new IllegalArgumentException(paramName + " must not null or empty");
        }
    }

    public Clients(Map<String, Client> clientMap) {
        this.clientMap = clientMap;
    }
}

//    Írj egy Clients osztályt, mely az ügyfeleket tartja nyilván.
// Regisztrációs szám alapján le kell tudni kérdezni egy ügyfelet a findByRegNumber(String) metódussal.
// Dobjon IllegalArgumentException-t, ha nincs. Fontos, hogy nagyon gyors legyen a lekérdezés a regisztrációs szám alapján!
// Ezen kívül legyen benne egy List<Client> findByName(String) metódus is, ami pedig névtöredék alapján keres! Ez lehet lassabb.
