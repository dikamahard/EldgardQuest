package entity;

public class Goblin extends Enemy{
    

    public Goblin(String name) {
        super(name);
        this.totalHp = this.baseHp;
        this.currentHp = this.totalHp;
    }


    @Override
    public double getAtkDamage() {
        return this.baseAtk;
    }


}
