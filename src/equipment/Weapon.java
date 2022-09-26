package equipment;

public class Weapon {
    protected double pAtk;
    protected double mAtk;
    protected String name;

    public Weapon(String name, int pAtk, int mAtk){
        this.pAtk = pAtk;
        this.mAtk = mAtk;
        this.name = name;
    }

    public String getName() {
        return this.name;
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

    public void setName(String name) {
        this.name = name;
    }
}
