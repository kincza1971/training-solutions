package testelek;

public class Husky extends Dog {

    public Husky(String name) {
        super(name);
    }

    @Override
    public void feed() {
        addToHappiness(4);
    }

    @Override
    public void play(int hours) {
        addToHappiness(hours * 3);
    }

}

////Ha meghívod a Husky feed() metódusát, akkor a boldágságértéke néggyel nőjjön! Ha a play() metódusát,
//// akkor a paraméterként átadott órák száma szorozva hárommal nőjjön a boldogságértéke!
////
