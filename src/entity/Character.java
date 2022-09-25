package entity;
import feature.Experience;

public abstract class Character extends Creature {
    protected double baseAtk;
    protected double currentHp;
    protected double totalHp;
    protected Experience exp;

    public Character(String name) {
        super(name);
        this.baseAtk = 5;
        this.exp = new Experience(100, 1, 0);
    }

    public double getBaseAtk() {
        return this.baseAtk;
    }

    public double getBaseHp() {
        return this.baseHp;
    }

    public void healthReduceBy(double damage) {
        this.currentHp -= damage;
        if(this.currentHp <= 0) {
            System.out.println(this.name + " has already fallen to DEATH\n" );
        } else {
            this.showHpStatus();
        }
    }

    public void showHpStatus() {
        System.out.println("HP : " + this.currentHp + "/" + this.totalHp + "\n");
    };

    public void attacking(Enemy foe) {
        System.out.println(this.name + " is attacking " + foe.name);
        foe.defendingFrom(this);
        if(foe.getCurrentHp() <= 0) {
            //this for exp gain and levelup and anything you will get from killing the enemy
            System.out.println(this.name + " got " + foe.exp.getExpDrop() + " experience\n");
            this.exp.gainExp(foe.exp.getExpDrop());
             
        }
    }

    public void defendingFrom(Enemy foe) {
        System.out.println(this.name + " got damaged by " + foe.name + " for "  + foe.getAtkDamage() + "damage\n");
        this.healthReduceBy(foe.getAtkDamage());
        
    }

    public void showStatus() {
        System.out.println("Character Name : " + this.name);
        System.out.println("Character Hp : " + this.currentHp + "/" + this.totalHp);
        System.out.println("Character Base Attack : " + this.baseAtk);
        System.out.println("Caharacter Level : " + this.exp.getLvl());
        System.out.println("Character Exp : " + this.exp.getCurrentExp() + "/" + this.exp.getExpCap() + "\n");
    }

    // attack damage
    public abstract double getAtkDamage();

}
