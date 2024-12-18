package Game;
import java.util.*;
abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int x, y;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.x = 0;
        this.y = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        x += 1;
        y += 1;
    }

    public void attack() {
        System.out.println(name + " attacks!");
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage!");
    }

    @Override
    public String toString() {
        return "Character: " + name + ", Health: " + health + ", Attack Power: " + attackPower + ", Location: (" + x + ", " + y + ")";
    }
}
