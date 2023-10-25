package entity.enemy;

public class Franken extends Enemy{
    
    public Franken(String name) {
        super(name);
        this.totalHp = this.baseHp * 5;
        this.currentHp = this.totalHp;
    }

    @Override
    public double getAtkDamage(double enemyPDef, double enemyMDef) {
        return calculateDamage(baseAtk, mAtk, pAtk, enemyPDef, enemyMDef);
    }
}
