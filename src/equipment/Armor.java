package equipment;

public class Armor extends Equipment{
    protected double pDef;
    protected double mDef;

    public Armor(String name, double pDef, double mDef) {
        this.name = name;
        this.pDef = pDef;
        this.mDef = mDef;
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
}
