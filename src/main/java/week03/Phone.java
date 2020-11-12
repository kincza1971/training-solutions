package week03;

public class Phone {
    private String prefix;
    private String number;

    public Phone(String phoneString) {
        this.prefix = phoneString.substring(0,2);
        this.number = phoneString.substring(3,phoneString.length());

    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
