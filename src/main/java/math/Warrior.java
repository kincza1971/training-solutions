package math;

import java.util.Random;

public class Warrior {
    private String name;
    private int stamina;
    private double skill;
    private Point position;

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        this.stamina = new Random().nextInt(101)-80;
        this.skill = new Random().nextFloat();
    }

    public Point getPosition() {
        return position;
    }

    public void move(Point destination) {
        int x = 0;
        if (position.getX() > destination.getX()) {
            x= position.getX()-1;
        } else {
            x = position.getX()==destination.getX() ? position.getX() : position.getX()+1;
        }
        int y = 0;
        if (position.getY() > destination.getY()) {
            x= position.getY()-1;
        } else {
            x = position.getY()==destination.getY() ? position.getY() : position.getY()+1;
        }
        position = new Point(x,y);
    }

    public void attack(Warrior enemy) {
        if (new Random().nextFloat() < skill) {
            enemy.skill = enemy.skill - (new Random().nextInt(3)+1);
        }
    }

    public boolean isAlive() {
        return stamina > 0;
    }
}
