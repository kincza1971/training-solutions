package math;

public class Game {
    public static void main(String[] args) {
        Point warriorPosition = new Point( 11,10);
        Point enemyPosition = new Point( 15,19);

        Warrior warrior = new Warrior("Conan",warriorPosition);
        Warrior enemy = new Warrior("Wulfgar",enemyPosition);
        int i = 1;
        System.out.println(i + ". kör:");
        System.out.println(warrior.toString());
        System.out.println(enemy.toString());

        do {
            if ((warrior.getPosition().getX() != enemy.getPosition().getX()) || (warrior.getPosition().getY() != enemy.getPosition().getY())) {
                warrior.move(enemy.getPosition());
                enemy.move(warrior.getPosition());
            } else{
                warrior.attack(enemy);
                if (warrior.isAlive() && enemy.isAlive()) enemy.attack(warrior);
            }
            i++;
            System.out.println();

            System.out.println(i + ". kör:");
            System.out.println(warrior.toString());
            System.out.println(enemy.toString());

        } while (warrior.isAlive() && enemy.isAlive());

        System.out.println();

        System.out.println("Végeredmény kihirdetése:");
        System.out.println(warrior.toString());
        System.out.println(enemy.toString());
        System.out.println("A győztes: " + (warrior.isAlive() ? warrior.toString() : enemy.toString())+ "!");
    }
}
