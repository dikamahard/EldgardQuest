package equipment;

public class Weapon {
    protected double weaponAtk;
    protected String name;

    public Weapon(String name, int weaponAtk){
        this.weaponAtk = weaponAtk;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getWeaponAtk() {
        return this.weaponAtk;
    }

    public void setWeaponAtk(double weaponAtk) {
        this.weaponAtk = weaponAtk;
    }

    public void setName(String name) {
        this.name = name;
    }
}
