package equipment;

public class Weapon extends Equipment{
    protected double pAtk;
    protected double mAtk;

    public Weapon(String name, int pAtk, int mAtk){
        this.pAtk = pAtk;
        this.mAtk = mAtk;
        this.name = name;
    }

    public double getPAtk() {
        return this.pAtk;
    }

    public double getMAtk() {
        return this.mAtk;
    }

    public void setPAtk(double pAtk) {
        this.pAtk = pAtk;
    }

    public void setMAtk(double mAtk) {
        this.mAtk = mAtk;
    }

}
