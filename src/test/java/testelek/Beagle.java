package testelek;

public class Beagle extends Dog {
    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
        addToHappiness(2);
    }

    @Override
    public void play(int hours) {
        addToHappiness(hours * 2);
    }
}

// Ha meghívod a Beagle feed() metódusát, akkor a boldágságértéke kettővel nőjjön!
// Ha a play() metódusát, akkor a paraméterként átadott órák száma szorozva kettővel nőjjön a boldogságértéke!
//

