package entity;

public abstract class Creature {
    protected double baseHp;
    protected String name;


    public Creature(String name) {
        this.baseHp = 100;
        this.name = name;
    }

    public void setBaseHp(double baseHp) {
        this.baseHp = baseHp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public double getBaseHp() {
        return this.baseHp;
    }

}
