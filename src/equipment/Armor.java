package equipment;

public class Armor {
    protected double armorDef;
    protected String name;

    public Armor(String name, double armorDef) {
        this.name = name;
        this.armorDef = armorDef;
    }

    public String geName() {
        return this.name;
    }

    public double getArmorDef() {
        return this.armorDef;
    }

    public void setArmorDef(double armorDef) {
        this.armorDef = armorDef;
    }

    public void setName(String name) {
        this.name = name;
    }
}
