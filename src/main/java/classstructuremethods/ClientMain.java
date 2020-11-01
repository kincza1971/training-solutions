package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        client.setName("Németh Szilárd");
        client.setAddress("H-9751 Battonya, Burgonya utca 21/A");
        client.setYear(1987);
        System.out.println(client.getName() + ", " + client.getYear() + ", " + client.getAddress());
        client.migrate("H-2040 Budaörs, Felsőhegyi út 84");
        System.out.println(client.getAddress());
    }
}
