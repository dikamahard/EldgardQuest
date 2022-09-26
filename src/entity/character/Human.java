package entity.character;
import equipment.Weapon;

public class Human extends Character{

    // -> equipment
    // armor
    // weapon
    private Weapon weapon;

    public Human(String name) {
        super(name);
        this.totalHp = this.baseHp; //baseHp + armordefense
        this.currentHp = this.totalHp;
    }

    public Human(String name, Weapon weapon) {
        super(name);
        this.totalHp = baseHp;
        this.weapon = weapon;
    }

    //damage for human will be 2 * baseAtk
    @Override
    public double getAtkDamage(double enemyPDef, double enemyMDef) {
        return calculateDamage(2*baseAtk, mAtk, pAtk, enemyPDef, enemyMDef);
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

//    @Override
//    protected void getTotalDamage() {

//    }

}
