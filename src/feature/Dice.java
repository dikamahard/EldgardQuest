package feature;

import java.util.Random;

public class Dice {
    private int maxRange;

    public Dice(int max) {
        this.maxRange = max;
    }

    public int getMaxRange() {
        return this.maxRange;
    }

    // this should implemeted differently from each class
    public int rollDice() {
        Random rand = new Random();
        int diceRolled = rand.nextInt(this.maxRange) + 1;

        return diceRolled;
    }
}
