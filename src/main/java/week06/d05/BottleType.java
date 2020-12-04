package week06.d05;

public enum BottleType {
    GLASS_BOTTLE(25),PET_BOTTLE(4);

    private int maximumAmount;

    public int getMaximumAmount() {
        return maximumAmount;
    }

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }
}
