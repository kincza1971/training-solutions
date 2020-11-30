package methodpass.toopers;

public class Validator {


    public static void isValidTrooperName(String trooperName) {
        if (trooperName == null || trooperName.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
    }

    public static void isValidPosition(double posX, double posY) {
//        if (posX<0 || posY <0 ) {
//            throw new IllegalArgumentException("Invalid coordinates + (" + posX + ";" + posY +")");
//        }
    }
}
