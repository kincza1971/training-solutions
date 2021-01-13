package week11.d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharCounterTest {
    String[] strings = {"aaabz","dddadgz","sssppaz","azspklld","zazazazaz","ptptptptpzppa"};

    @Test
    public void countTest() {
        CharCounter cc = new CharCounter();
        int count = cc.countChars(strings);
        Assertions.assertEquals(2,count);
    }
}
