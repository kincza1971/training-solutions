package abstractclass.gamecharacter;

import java.util.Random;

public class BattleField {

    private int round;

    private boolean oneHit(Character attacker, Character defender) {
        if (attacker.isAlive() && defender.isAlive()) {
            attacker.primaryAttack(defender);
            if (!defender.isAlive()) return false;
        }
        attacker.secondaryAttack(defender);
        return defender.isAlive();
    }

    public int getRound() {
        return round;
    }

    public Character fight(Character one, Character other){
        boolean isBothAlive = true;
        while (isBothAlive && round <1000) {
            if (isBothAlive != (oneHit(one,other))) {
                return one;
            }

            if (isBothAlive != (oneHit(other,one))) {
                return other;
            }
            round++;
        }
        return null;
    }

    public static void main(String[] args) {
        BattleField battlefield = new BattleField();
        Random random = new Random();
        System.out.println(battlefield.fight(
                new Archer(new Point(4,3),random),
                new AxeWarrior(new Point(3,3),random))
        );
    }

    //    round, hány kör van még (int típusú).
//    generálj egy gettert a round attribútumra.
//    hozz létre egy private boolean oneHit(Character attacker, Character defender) metódust, amely igazzal tér vissza,
//    ha mindkét karakter él. Törzsében meghívja a támadó (attacker) primaryAttack() majd secondaryAttack() metódusait,
//    melyeknek paramétere a védekező defender, ha még mindkettő él.
//    hozz létre egy public Character fight(Character one, Character other) metódust, amely visszatér az élve maradt karakterrel.
//    Törzsében
//    mindaddig hívja a privát oneHit metódust felváltva a támadó és védekező szerepeket, amíg valamelyik meg nem hal.
//    Minden körben először a one támadja az other-t, majd az other a one-t.
//    közben növeli a round attribútum értékét.
//    végül visszatért az élő karakter referenciával.
}
