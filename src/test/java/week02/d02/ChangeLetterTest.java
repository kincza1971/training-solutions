package week02.d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeLetterTest {

    @Test
    public void changeVowelsEquals() {
        Assertions.assertEquals("*m*l*t*s k*mm*ncs*k m*nd*g l*ss*n m*z*gn*k",
                ChangeLetter.changeVowels2("Emeletes kommancsok mindig lassan mozognak"));
        Assertions.assertEquals("ÁRVÍZTŰRŐ TÜKÖRFÚRÓGÉP M*NDM*G*TT*",
                ChangeLetter.changeVowels2("ÁRVÍZTŰRŐ TÜKÖRFÚRÓGÉP MINDMEGETTE"));
    }
}
