package abstractclass.gamecharacter;

import java.util.Random;

import static java.lang.Math.round;

public class AxeWarrior extends Character{

    private int getActualSecondaryDamage(){
        return (int) round(getActualPrimaryDamage() * getRandom().nextFloat() * 2);
    }

    public AxeWarrior(Point position, Random random) {
        super(position,random);
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if(enemy.getPosition().distance(getPosition())<2){
            enemy.hit(this,getActualSecondaryDamage());
        }
    }

    //    hozz létre egy konstruktort, amely megkapja a harcos pozícióját és erre állítja be a position örökölt attribútumot.
//    hozz létre egy privát getActualSecondaryDamage metódust, ami visszaad egy pozitív véletlen egész értéket amely az
//    elsődleges támadás maximum kétszerese.
//    implementáld az örökölt secondaryAttack metódust úgy,
//    hogy ha az ellenség közelebb van mint két egység (használd a Point distance metódust), akkor meghívja az örökölt
//    hit() metódust, átadva a kapott enemy paramétert és a getActualSecondaryDamage() metódus visszatérési értékét.
}
