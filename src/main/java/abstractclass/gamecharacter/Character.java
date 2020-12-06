package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

    private Point position;
    private int hitPoint= 100;
    private Random random;

    public boolean isAlive() {
        return hitPoint >0;
    }
    protected int getActualPrimaryDamage() {
        return random.nextInt(10)+1;
    }

    private int getActualDefence() {
        return random.nextInt(6);
    }

    private void decreaseHitPoint(int realDmg) {
        hitPoint-=realDmg;
    }

    protected void hit(Character enemy, int damage) {
        int def = getActualDefence();
        if (damage > def) {
            decreaseHitPoint(damage-def);
        }
    }

    public void primaryAttack(Character enemy) {
        int dmg = getActualPrimaryDamage();
        enemy.hit(this,dmg);
    }

    abstract public void secondaryAttack(Character enemy);

    public int getHitPoint() {
        return hitPoint;
    }

    public Point getPosition() {
        return position;
    }

    public Random getRandom() {
        return random;
    }

    public Character(Point position, Random random) {
        this.random = random;
        this.position = position;
    }

    //    szükséges attribútumok
//    position, hol van a karakter (Point típusú).
//    hitPoint, mennyi életereje van még a karakternek (int típus), alapértelmezett értéke 100.
//    random, Random típus, véletlenszámok generálásához.
//    Hozz létre még egy isAlive metódust, amely igazzal tér vissza, ha még él a karakter, azaz a hitPoint nagyobb, mint 0 (egyébként hamis).
//    protected getActualPrimaryDamage metódus, amely visszaad egy egy és tíz közötti véletlen értéket (egész).
//    private getActualDefence metódus, amely visszaad egy nulla és 5 közötti véletlen értéket (egész).
//    protected void hit(Character enemy, int damage) metódus,
//    amely lekérdezi az aktuális védelmet (használva a getActualDefence metódust).
//    Ha gyengébb a védelem, mint a sebzés (damage paraméter), akkor levonja a sebzés értékét az életerőből, hívja a decreaseHitPoint private metódust.
//    public void primaryAttack(Character enemy), amely csak továbbhívja a hit metódust a saját enemy paraméterével, és a getActualPrimaryDamage metódus visszatérési értékével.
//    private void decreaseHitPoint(int diff), amely levonja a diff paraméter értékét az életerő (hitPoint attribútum) értékéből.
//    deklarálj egy abstract public void secondaryAttack(Character enemy) metódust, melyet a leszármazott konkrét osztályok implementálnak majd.

}
