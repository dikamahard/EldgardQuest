package entity.character;

import entity.Creature;
import entity.enemy.Enemy;
import equipment.Armor;
import equipment.Equipment;
import equipment.Weapon;
import feature.Experience;
import feature.Inventory;

public abstract class Character extends Creature {
    protected double baseAtk;
    protected double pAtk;
    protected double mAtk;
    protected double pDef;
    protected double mDef;
    protected double currentHp;
    protected double totalHp;
    protected Experience exp;
    protected Inventory inventory;
    // -> equipment
    // armor
    // weapon
    protected Weapon weapon;
    protected Armor armor;

    public Character(String name) {
        super(name);
        this.baseAtk = 20;
        this.pDef = 1;
        this.mDef = 1;
        this.exp = new Experience(100, 1, 0);
        this.inventory = new Inventory(10);
    }

    public Experience getExp() {
        return this.exp;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void equipWeapon(Equipment weapon) {
        this.weapon = (Weapon)weapon;
        this.pAtk += this.weapon.getPAtk();
        this.mAtk += this.weapon.getMAtk();      
    }

    public void equipArmor(Equipment armor) {
        this.armor = (Armor)armor;
        this.pDef += this.armor.getPDef();
        this.mDef += this.armor.getMDef();      
    }

    public Weapon getWeapon() {
        return this.weapon;
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

    // plus dice rolll
    public void attacking(Enemy foe) {
        if(this.currentHp > 0 ) {
            int diceRolled = dice.rollDice();
            // System.out.println(this.name + " is attacking " + foe.getName());
            System.out.println(this.name + " rolled the dice for " + diceRolled);
            foe.defendingFrom(this, diceRolled);
            if(foe.getCurrentHp() <= 0) {
                //this for exp gain and levelup and anything you will get from killing the enemy
                System.out.println(this.name + " got " + foe.getExp().getExpDrop() + " experience\n");
                this.exp.gainExp(foe.getExp().getExpDrop());
                
                // hp back to full
                this.currentHp = this.totalHp;
            }
        }
        
    }

    public void defendingFrom(Enemy foe, int diceRolled) {
        System.out.println(this.name + " got damaged by " + foe.getName() + " for "  + foe.getAtkDamage(this.pDef, this.mDef, diceRolled) + "damage\n");
        this.healthReduceBy(foe.getAtkDamage(this.pDef, this.mDef, diceRolled));
        
    }

    public void showStatus() {
        System.out.println("Character Name : " + this.name);
        System.out.println("Character Hp : " + this.currentHp + "/" + this.totalHp);
        System.out.println("Character Base Attack : " + this.baseAtk);
        System.out.println("Character Physical Attack : " + this.pAtk);
        System.out.println("Character Magical Attack : " + this.mAtk);
        System.out.println("Character Physical Deffense : " + this.pDef);
        System.out.println("Character Magical Deffense : " + this.mDef);
        System.out.println("Caharacter Level : " + this.exp.getLvl());
        System.out.println("Character Exp : " + this.exp.getCurrentExp() + "/" + this.exp.getExpCap() + "\n");
       
        // NEED NULL SAFETY
        System.out.println("Equipped Weapon : " + (this.weapon != null ?  this.weapon.getName() + ", pAtk : " + this.weapon.getPAtk() + ", mAtk : " + this.weapon.getMAtk() : "None"));
        System.out.println("Equipped Armor : " + (this.armor != null ?  this.armor.getName() + ", pDef : " + this.armor.getPDef() + ", mDef : " + this.armor.getMDef() : "None"));
    }

    // attack damage formulation will be difference depending on each race
    public abstract double getAtkDamage(double enemyPDef, double enemyMDef, int diceRolled);


    // Damage Formula
    public double calculateDamage(double baseAtk, double mAtk, double pAtk, double enemyPDef, double enemyMDef) {
        double e1 = (enemyPDef + enemyMDef) / baseAtk;
        double e2 = enemyPDef / pAtk;
        double e3 = enemyMDef / mAtk;
        return (baseAtk / Math.pow(2, e1)) + (pAtk / Math.pow(2, e2)) + (mAtk / Math.pow(2, e3));
    }    

}
