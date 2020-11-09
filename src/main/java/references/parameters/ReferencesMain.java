package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person p1 = new Person("Egyeske Tamás", 21);
        Person p2 = new Person("Ketteske Péter", 27);
        p1 = new Person("Hárhaska Herold", 33);
        p2=p1;
        p2.setName("Namostmilesz András");
        System.out.println(p1.getName() + ", " + p1.getAge());
        System.out.println(p2.getName() + ", " + p2.getAge());

        int egy = 24;
        int ketto = egy;
        ketto++;
        System.out.println(egy + " " + ketto);

    }
}
