package exam03retake01;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void create() {
        Contact contact = new Contact("John Doe", "johndoe@example.com");
        assertEquals("John Doe", contact.getName());
        assertEquals("johndoe@example.com", contact.getEmail());
    }
}