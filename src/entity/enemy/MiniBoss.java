package entity.enemy;

public class MiniBoss extends Enemy {
    public MiniBoss(String name){
        super(name);
        this.totalHp = this.baseHp * 5;
        this.currentHp = this.totalHp;
    }

    @Override
    public double getAtkDamage(double enemyPDef, double enemyMDef) {
        return calculateDamage(baseAtk, mAtk, pAtk, enemyPDef, enemyMDef);
    }
}
