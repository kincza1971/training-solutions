package week09.d03;

import java.util.Random;

public class Person {
    private final String name;
    private final int age;
    private final Random rnd;
    private Present present;


    public boolean isBelowFifteen(){
        return age<=14;
    }

    private void checkParams(String name, int age, Random rnd) {
        if (rnd == null) {
            throw new IllegalArgumentException("Random must not be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not null or blank, (" + name+")");
        }
        if (age <0 || age > 120) {
            throw  new IllegalArgumentException("Age must be between 0 and 120, ("+age+")");
        }
    }

    public Person(String name, int age, Random rnd) {
        checkParams(name,age,rnd);
        this.rnd = rnd;
        this.name = name;
        this.age = age;
    }

    public void setPresent() {
        int presNum;
        if (isBelowFifteen()) {
            presNum= rnd.nextInt(Present.values().length-1);
        } else {
            presNum = rnd.nextInt(Present.values().length-1)+1;
        }
        this.present = Present.values()[presNum];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }
}
