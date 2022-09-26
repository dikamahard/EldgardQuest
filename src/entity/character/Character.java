package entity.character;
import entity.Creature;
import entity.enemy.Enemy;
import feature.Experience;

public abstract class Character extends Creature {
    protected double baseAtk;
    protected double pAtk;
    protected double mAtk;
    protected double pDef;
    protected double mDef;
    protected double currentHp;
    protected double totalHp;
    protected Experience exp;

    public Character(String name) {
        super(name);
        this.baseAtk = 20;
        this.pDef = 1;
        this.mDef = 1;
        this.exp = new Experience(100, 1, 0);
    }

    public Experience getExp() {
        return this.exp;
    }

    public double getCurrentHp() {
        return this.currentHp;
    }

    public double getTotalHp() {
        return this.totalHp;
    }

    public double getBaseAtk() {
        return this.baseAtk;
    }

    public double getBaseHp() {
        return this.baseHp;
    }

    public double getPAtk() {
        return this.pAtk;
    }

    public double getMAtk() {
        return this.mAtk;
    }

    public double getPDef() {
        return this.mDef;
    }

    public double getMDef() {
        return this.mDef;
    }

    public void setPAtk(double pAtk) {
        this.pAtk = pAtk;
    }

    public void setMAtk(double mAtk) {
        this.mAtk = mAtk;
    }

    public void setPDef(double pDef) {
        this.pDef = pDef;
    }

    public void setMDef(double mDef) {
        this.mDef = mDef;
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
        System.out.println(this.name + " is attacking " + foe.getName());
        foe.defendingFrom(this);
        if(foe.getCurrentHp() <= 0) {
            //this for exp gain and levelup and anything you will get from killing the enemy
            System.out.println(this.name + " got " + foe.getExp().getExpDrop() + " experience\n");
            this.exp.gainExp(foe.getExp().getExpDrop());
             
        }
    }

    public void defendingFrom(Enemy foe) {
        System.out.println(this.name + " got damaged by " + foe.getName() + " for "  + foe.getAtkDamage(this.pDef, this.mDef) + "damage\n");
        this.healthReduceBy(foe.getAtkDamage(this.pDef, this.mDef));
        
    }

    public void showStatus() {
        System.out.println("Character Name : " + this.name);
        System.out.println("Character Hp : " + this.currentHp + "/" + this.totalHp);
        System.out.println("Character Base Attack : " + this.baseAtk);
        System.out.println("Caharacter Level : " + this.exp.getLvl());
        System.out.println("Character Exp : " + this.exp.getCurrentExp() + "/" + this.exp.getExpCap() + "\n");
    }

    // attack damage formulation will be difference depending on each race
    public abstract double getAtkDamage(double enemyPDef, double enemyMDef);


    // Damage Formula
    public double calculateDamage(double baseAtk, double mAtk, double pAtk, double enemyPDef, double enemyMDef) {
        double e1 = (enemyPDef + enemyMDef) / baseAtk;
        double e2 = enemyPDef / pAtk;
        double e3 = enemyMDef / mAtk;
        return (baseAtk / Math.pow(2, e1)) + (pAtk / Math.pow(2, e2)) + (mAtk / Math.pow(2, e3));
    }
        

}
