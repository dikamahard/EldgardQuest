package equipment;

public class Armor {
    protected double pDef;
    protected double mDef;
    protected String name;

    public Armor(String name, double pDef) {
        this.name = name;
        this.pDef = pDef;
    }

    public String getName() {
        return this.name;
    }

    public double getPDef() {
        return this.pDef;
    }

    public double getMDef() {
        return this.pDef;
    }

    public void setPDef(double pDef) {
        this.pDef = pDef;
    }

    public void setMDef(double mDef) {
        this.mDef = mDef;
    }

    public void setName(String name) {
        this.name = name;
    }
}
