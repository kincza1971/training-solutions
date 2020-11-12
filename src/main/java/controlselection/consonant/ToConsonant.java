package controlselection.consonant;

public class ToConsonant {

    private char toConsonant(char aLetter) {
            switch (aLetter) {
                case 'a':
                    return 'b';
                case'A':
                    return 'B';
                case 'e':
                    return 'f';
                case 'E':
                    return 'F';
                case 'i':
                    return 'j';
                case 'I':
                    return 'J';
                case 'o':
                    return 'p';
                case 'O':
                    return 'P';
                case 'u':
                    return 'v';
                case 'U':
                    return 'V';
                default: throw new IllegalArgumentException("Nem magánhangzó: " + aLetter);
            }
    }
}
