package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance(19.7,false);
        System.out.println("Távolság: " + distance.getDistanceInKm() + "Km " + (distance.isExact()==true ? "Pontos" : "Nem pontos"));
        int i = (int) distance.getDistanceInKm();
        System.out.println(i);
    }
}
