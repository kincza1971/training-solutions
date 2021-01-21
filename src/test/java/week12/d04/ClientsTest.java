package week12.d04;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class ClientsTest {
    @Test
    public void testClient() {
        Client client1 = new Client("Mézga Aladár", "MA0001");
        Client client2 = new Client("Mézga Krisztina", "MK0001");
        Client client3 = new Client("Mézga Géza", "MG0001");
        Client client4 = new Client("Mézga Ursula", "MU0001");
        Map<String, Client> testMap = new TreeMap<>();
//        testMap.put(client1)
    }

    public void testClients() {
    }
}
