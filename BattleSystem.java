
import java.util.Random;

// 1. Base Class (Parent)
abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
        System.out.println(this.name + " takes " + damage + " damage! (HP: " + this.health + ")");
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public abstract void specialMove(Character opponent);
}

// 2. Child Class 1: Warrior
class Warrior extends Character {
    private int shieldStrength;

    public Warrior(String name, int health, int attackPower, int shieldStrength) {
        super(name, health, attackPower);
        this.shieldStrength = shieldStrength;
    }

    @Override
    public void specialMove(Character opponent) {
        // Every time Warrior attacks, he calls Battle Cry first
        battleCry(); 
        System.out.println(this.name + " uses 'Shield Bash'!");
        opponent.takeDamage(this.attackPower + (shieldStrength / 2));
    }

    public void battleCry() {
        System.out.println(this.name + " yells: 'FOR GLORY!'");
    }
}

// 3. Child Class 2: Wizard
class Wizard extends Character {
    private int mana;

    public Wizard(String name, int health, int attackPower, int mana) {
        super(name, health, attackPower);
        this.mana = mana;
    }

    @Override
    public void specialMove(Character opponent) {
        // If mana is empty, call recharge
        if (this.mana <= 0) {
            recharge();
        }
        System.out.println(this.name + " casts 'Fireball'!");
        opponent.takeDamage(this.attackPower + (mana / 5));
        this.mana -= 10; // Use mana
    }

    public void recharge() {
        this.mana += 20;
        System.out.println(this.name + " is out of mana! Restoring 20 mana...");
    }
}

// 4. Child Class 3: Archer
class Archer extends Character {
    private int arrowCount;

    public Archer(String name, int health, int attackPower, int arrowCount) {
        super(name, health, attackPower);
        this.arrowCount = arrowCount;
    }

    @Override
    public void specialMove(Character opponent) {
        // If arrows are finished, call reload
        if (this.arrowCount <= 0) {
            reload();
        }
        
        System.out.println(this.name + " fires a 'Triple Shot'!");
        opponent.takeDamage(this.attackPower + 12);
        this.arrowCount -= 3;
    }

    public void reload() {
        this.arrowCount += 10;
        System.out.println(this.name + " is out of arrows! Reloading 10 arrows...");
    }
}

// 5. Main Class
public class BattleSystem {
    public static void main(String[] args) {
        // Start Robin with low arrows to show the 'reload' trigger quickly
        Warrior p1 = new Warrior("Arthur", 100, 15, 20);
        Archer p2 = new Archer("Robin", 90, 18, 3); 

        System.out.println("--- Battle Start: " + p1.name + " vs " + p2.name + " ---\n");

        Random rand = new Random();

        while (p1.isAlive() && p2.isAlive()) {
            // Player 1 (Warrior)
            if (rand.nextBoolean()) {
                p1.specialMove(p2);
            } else {
                p1.battleCry(); // Call battle cry even on normal attack
                System.out.println(p1.name + " attacks normally.");
                p2.takeDamage(p1.attackPower);
            }

            if (!p2.isAlive()) break;

            // Player 2 (Archer)
            if (rand.nextBoolean()) {
                p2.specialMove(p1);
            } else {
                System.out.println(p2.name + " attacks normally.");
                p1.takeDamage(p2.attackPower);
            }
            System.out.println("--------------------");
        }

        System.out.println("\n--- Winner: " + (p1.isAlive() ? p1.name : p2.name) + " ---");
    }
}
