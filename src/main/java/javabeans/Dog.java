package javabeans;

public class Dog {
    private final String name;
    private int age;
    private final boolean pedigree;
    private int weight;

    public Dog(String name, int age, boolean pedigree, int weight) {
        this.name = name;
        this.age = age;
        this.pedigree = pedigree;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isPedigree() {
        return pedigree;
    }

    public int getWeight() {
        return weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
