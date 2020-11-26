package lengyeltomi;


import org.junit.jupiter.api.Test;
import schoolrecords.Subject;
import schoolrecords.Tutor;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TutorTest {

    @Test
    public void testTutorTeachingSubject() {
        //Given
        schoolrecords.Tutor tutor = new schoolrecords.Tutor("Nagy Csilla", Arrays.asList(new schoolrecords.Subject("matematika"), new schoolrecords.Subject("fizika")));
        //Then

        assertEquals("Nagy Csilla", tutor.getName());
        assertTrue(tutor.tutorTeachingSubject(new schoolrecords.Subject("fizika")));
    }

    @Test
    public void testTutorDoesNotTeachingSubject() {
        //Given
        schoolrecords.Tutor tutor = new Tutor("Nagy Csilla", Arrays.asList(new schoolrecords.Subject("matematika"), new schoolrecords.Subject("fizika")));
        //Then

        assertFalse(tutor.tutorTeachingSubject(new Subject("biológia")));
    }
}