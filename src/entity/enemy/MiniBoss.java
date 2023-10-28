package entity.enemy;
import java.util.Random;
import feature.Dice;

public class MiniBoss extends Enemy {
    public MiniBoss(String name){
        super(name);
        this.totalHp = this.baseHp * 5;
        this.currentHp = this.totalHp;
        this.setExpDrop(250);

         // implement dice rolling mechanic for MiniBoss monster
        this.dice = new Dice(8) {
            @Override
            public int rollDice() {
                Random rand = new Random();
                int diceRolled = rand.nextInt(this.getMaxRange()) + 2;

                return diceRolled;
            }
        };
    }

    @Override
    public double getAtkDamage(double enemyPDef, double enemyMDef, int diceRolled) {
        return calculateDamage(diceRolled * baseAtk, mAtk, pAtk, enemyPDef, enemyMDef);
    }
}
