package week03;

public class PhoneParser {

    public static void main(String[] args) {
        Phone phone = new Phone("20-113451");
        System.out.println(phone.getPrefix() + " : " + phone.getNumber());
    }
}
