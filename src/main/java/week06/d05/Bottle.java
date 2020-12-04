package week06.d05;

public class Bottle {


    private BottleType bottleType;
    private int filledUntil;


    public void fill(int fillAmount) {
        if (bottleType.getMaximumAmount() < filledUntil+fillAmount) {
            throw new IllegalArgumentException("A palackba nem fér ennyi folyadék!");
        }
        filledUntil+=fillAmount;
    }

    public int getFilledUntil() {
        return filledUntil;
    }

    public Bottle(BottleType bottleType) {
        this.bottleType = bottleType;
    }

    public static Bottle of(BottleType bottleType) {
        return new Bottle(bottleType);
    }
}
