package entity;
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

    //damage
    @Override
    public double getAtkDamage() {
        return this.baseAtk + weapon.getWeaponAtk();
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

   

}
