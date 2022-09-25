package entity;
import feature.Experience;

public abstract class Enemy extends Creature {
    protected double baseAtk;
    protected double currentHp;
    protected double totalHp;
    protected Experience exp;
    

    public Enemy(String name) {
        super(name);
        this.baseAtk = 2.5;
        this.exp = new Experience(0, 1, 100);
    }

    public double getBaseAtk() {
        return this.baseAtk;
    }

    public double getCurrentHp() {
        return this.currentHp;
    }

    public void setBaseAtk(double baseAtk) {
        this.baseAtk = baseAtk;
    }

    public void attacking(Character foe) {
        System.out.println(this.name + " is attacking " + foe.name) ;
        foe.defendingFrom(this);
    };
        
    public void defendingFrom(Character foe) {
        System.out.println(this.name + " got damaged by " + foe.name + " for " + foe.getAtkDamage() + "damage\n");
        this.healthReduceBy(foe.getAtkDamage());
        // if(this.currentHp <= 0) {
        //     System.out.println(foe.name + " got " + this.exp.getExpDrop() + " experience\n");
        //     foe.exp.gainExp(this.exp.getExpDrop());
        // }
    };

    public void healthReduceBy(double damage) {
        this.currentHp -= damage;
        if(this.currentHp <= 0) {
            System.out.println(this.name + " has already fallen to DEATH\n" );
        } else {
            this.showHpStatus();
        }
    }

    public void showHpStatus() {
        System.out.println(this.name + " HP : " + this.currentHp + "/" + this.totalHp + "\n");
    };

    // attack damage
    public abstract double getAtkDamage();

}
