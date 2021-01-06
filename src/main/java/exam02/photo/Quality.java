package exam02.photo;

public enum Quality {

    NO_STAR(0), ONE_STAR(1), TWO_STAR(2);

    private int stars;

    Quality(int stars) {
    }

    int getStars() {
        return stars;
    }
}
