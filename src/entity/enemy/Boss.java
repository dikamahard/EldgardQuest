package entity.enemy;

public class Boss extends Enemy{
    public Boss(String name){
        super(name);
        this.totalHp = this.baseHp * 10;
        this.currentHp = this.totalHp;
    }

    @Override
    public double getAtkDamage(double enemyPDef, double enemyMDef) {
        return calculateDamage(baseAtk, mAtk, pAtk, enemyPDef, enemyMDef);
    }
}
