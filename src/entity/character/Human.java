package entity.character;
import equipment.Weapon;
import feature.Dice;


public class Human extends Character{

    // -> equipment
    // armor
    // weapon
    // private Weapon weapon;

    public Human(String name) {
        super(name);
        this.totalHp = this.baseHp; //baseHp + armordefense
        this.currentHp = this.totalHp;

        // implement dice rolling mechanic for human
        this.dice = new Dice(6);
    }

    public Human(String name, Weapon weapon) {
        super(name);
        this.totalHp = baseHp;
        this.weapon = weapon;
    }

    //damage for human will be 2 * baseAtk
    @Override
    public double getAtkDamage(double enemyPDef, double enemyMDef, int diceRolled) {
        return calculateDamage(diceRolled * baseAtk, mAtk, pAtk, enemyPDef, enemyMDef);
    }


//    @Override
//    protected void getTotalDamage() {

//    }

}
