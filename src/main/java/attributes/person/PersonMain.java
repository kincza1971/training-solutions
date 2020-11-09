package attributes.person;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Trainer András","201943 QT");
        person.moveTo("Egypt","Cairo","Khofru str. 117/4","EG-74510");
        System.out.println(person.personToString() +  " addr: " + person.getAddress());
    }
}
