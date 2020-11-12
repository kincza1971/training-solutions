package controlselection.consonant;

public class ToConsonant {

    private char toConsonant(char aLetter) {
        int index = "aAeEiIoOuU".indexOf(aLetter);
        if (index>-1) {
            switch (index) {
                case 1:
                    return 'b';
                case 2:
                    return 'B';
                case 3:
                    return 'f';
                case 4:
                    return 'F';
                case 5:
                    return 'j';
                case 6:
                    return 'J';
                case 7:
                    return 'p';
                case 8:
                    return 'P';
                case 9:
                    return 'v';
                case 10:
                    return 'V';
                default: return 'z';
            }
        } else {
            throw new IllegalArgumentException("Nem magánhangzó: " + aLetter);
        }
    }
}
