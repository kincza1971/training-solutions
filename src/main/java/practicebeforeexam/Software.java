package practicebeforeexam;

public abstract class Software {

    protected String name;
    protected double price;

    public Software(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void increasePrice();
}

//Mégiscsak egy kis gyakorlás a vizsgára: Hozzatok létre egy Software osztályt, melynek van egy name  attribútuma! 
// Legyen egy price attribútuma is! Ne lehessen példányosítani! Legyen egy  void increasePrice() metódusa! 
// Legyen konstruktora, mely a két attribútum értékét várja! Kell getter is a két attribútumhoz. Hozzatok létre egy 
// OfficeSoftware és egy DeveloperSoftware osztályt, mely a Software leszármazottja. Legyen egy increatePrice() metódusa,
// mely OfficeSoftware  esetén az árat 5%-kal, a DeveloperSoftware árát 10%-kal emeli. Írj a két leszármazotthoz teszteseteket!