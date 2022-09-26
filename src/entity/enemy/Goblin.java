package entity.enemy;

public class Goblin extends Enemy{
    

    public Goblin(String name) {
        super(name);
        this.totalHp = this.baseHp;
        this.currentHp = this.totalHp;
    }


    @Override
    public double getAtkDamage(double enemyPDef, double enemyMDef) {
        return calculateDamage(baseAtk, mAtk, pAtk, enemyPDef, enemyMDef);
    }


}
