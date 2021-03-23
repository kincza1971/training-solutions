package practicebeforeexam;

public class OfficeSoftware extends Software {

    public OfficeSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        this.price = price * 1.05;
    }
}
