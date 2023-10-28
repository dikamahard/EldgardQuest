package entity.enemy;
import entity.Creature;
import entity.character.Character;
import feature.Experience;

public abstract class Enemy extends Creature {
    protected double baseAtk;
    protected double pAtk;
    protected double mAtk;
    protected double pDef;
    protected double mDef;
    protected double currentHp;
    protected double totalHp;
    protected Experience exp;
    

    public Enemy(String name) {
        super(name);
        this.baseAtk = 2.5;
        this.pDef = 1;
        this.mDef = 1;
        this.exp = new Experience(0, 1, 100);
    }

    public Experience getExp() {
        return this.exp;
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
        if(this.currentHp > 0) {
            int diceRolled = dice.rollDice();

            System.out.println(this.name + " rolled the dice for " + diceRolled) ;
            foe.defendingFrom(this, diceRolled);
        }
        
    };

    public void setExpDrop(long expDrop) {
        this.exp.setExpDrop(expDrop);
    }
        
    public void defendingFrom(Character foe, int diceRolled) {
        System.out.println(this.name + " got damaged by " + foe.getName() + " for " + foe.getAtkDamage(this.pDef, this.mDef, diceRolled) + "damage\n");
        this.healthReduceBy(foe.getAtkDamage(this.pDef, this.mDef, diceRolled));
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
    public abstract double getAtkDamage(double enemyPDef, double enemyMDef, int diceRolled);

    public double calculateDamage(double baseAtk, double mAtk, double pAtk, double enemyPDef, double enemyMDef) {
        double e1 = (enemyPDef + enemyMDef) / baseAtk;
        double e2 = enemyPDef / pAtk;
        double e3 = enemyMDef / mAtk;
        return (baseAtk / Math.pow(2, e1)) + (pAtk / Math.pow(2, e2)) + (mAtk / Math.pow(2, e3));
    }

    // Dice roll
    // int rollDice() {
    //     Random rand = new Random();
    //     int diceRolled = rand.nextInt(6) + 1;

    //     return diceRolled;
    // }

}
