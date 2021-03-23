package practicebeforeexam;

public class DeveloperSoftware extends Software {

    public DeveloperSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        this.price = price * 1.1;
    }

}
