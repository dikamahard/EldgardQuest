package entity.enemy;

public class Common extends Enemy{
    public Common(String name){
        super(name);
        this.totalHp = this.baseHp * 2;
        this.currentHp = this.totalHp;
    }

    @Override
    public double getAtkDamage(double enemyPDef, double enemyMDef) {
        return calculateDamage(baseAtk, mAtk, pAtk, enemyPDef, enemyMDef);
    }
}
