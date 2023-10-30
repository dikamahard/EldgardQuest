package entity.enemy;
import feature.Dice;
import java.util.Random;


public class Boss extends Enemy{
    public Boss(String name){
        super(name);
        this.totalHp = this.baseHp * 10;
        this.currentHp = this.totalHp;
        this.setExpDrop(500);

        // implement dice rolling mechanic for Boss monster
        this.dice = new Dice(10) {
            @Override
            public int rollDice() {
                Random rand = new Random();
                int diceRolled = rand.nextInt(this.getMaxRange()) + 5;

                return diceRolled;
            }
        };
    }

    @Override
    public double getAtkDamage(double enemyPDef, double enemyMDef, int diceRolled) {
        return calculateDamage(diceRolled * baseAtk, mAtk, pAtk, enemyPDef, enemyMDef);
    }

    @Override
    public int getGoldDrop() {
        Random rand = new Random();
        return 300 + rand.nextInt(200);
    }
}
