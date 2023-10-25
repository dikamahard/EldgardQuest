package game;

import entity.enemy.Enemy;
import entity.enemy.Goblin;

import java.util.Scanner;

import entity.character.Character;
import entity.character.Human;

public class GameFunc {
    // some idea
    // we add character here, so this class can modified player
    // without passing it as an argument because we put the player on this constructor
    // and ofcourse add this class as an antribute for menu class and at the constructor too
    Character player;

    public GameFunc(Character player) {
        this.player = player;
    }

    public void createCharacter(Character player) {
        Scanner input = new Scanner(System.in);
        System.out.print("Your name : ");
        player.setName(input.nextLine());
        System.out.println("Available race : ");
        System.out.println("1. Human");
        System.out.println("2. to be added...");
        System.out.println("Choose your race : ");
        int race = input.nextInt();
        chooseRace(race, player);
    }

    public void chooseRace(int race, Character player) {
        switch(race) {
            case 1:
                // human race
                player = new Human(player.getName());
                break;
            case 2:
                // to be added
                break;
            default:
        
        }
    }

    public void encounterEnemy(Enemy mob) {
        Scanner input = new Scanner(System.in);
        System.out.println("You have encountered " + mob.getName() + "!!!");
        System.out.println("What are you gonna do ? ");
        System.out.println("1. Fight now");
        System.out.println("2. Run ");
        System.out.println("------------------------");
        System.out.println(">> ");
        int act = input.nextInt();
        if(act == 1) {
            fight(mob);
        }else if(act == 2) {
            run();
        }
        return;
    }

    // WHY THIS FUNCTION ISNT UPDATED!!!!
    public void fight(Enemy mob) {
        System.out.println("FIGHTING GOO");
        while((mob.getCurrentHp() > 0) && (this.player.getCurrentHp() > 0)) {
            this.player.attacking(mob);
            mob.attacking(player);
        }
        return;
    }

    public void run() {
        System.out.println(this.player.getName() + " cowardly choose to run");
    }






    // generate enemy function here 
    public void generateEnemy(int area, int compass) {
       
        switch(compass) {
            case 1:
                 // north
                 northeEnemyGenerate(area);
                break;
            case 2:
                // south
                southEnemyGenerate(area);
                break;
            case 3:
                // west
                westEnemyGenerate(area);
                break;
            case 4:
                // east
                eastEnemyGenerate(area);
                break;
            default:
        }
    }

    public void northeEnemyGenerate(int area) {
        switch(area){
            case 1:
                // Castle of Fantanir
                break;
            case 2:
                // to be added...
                break;
            default:
                System.out.println("Unknown area...");

        }
    }

    public void southEnemyGenerate(int area) {
        switch(area){
            case 1:
                // Castle of Fantanir
                break;
            case 2:
                // to be added...
                break;
            default:
                System.out.println("Unknown area...");

        }
    }

    public void westEnemyGenerate(int area) {
        switch(area){
            case 1:
                // Castle of Fantanir
                Enemy goblin = new Goblin("Hemogoblin");
                // should be random but for now this is fine
                encounterEnemy(goblin);
                break;
            case 2:
                // to be added...
                break;
            default:
                System.out.println("Unknown area...");

        }
    }

    public void eastEnemyGenerate(int area) {
        switch(area){
            case 1:
                // Castle of Fantanir
                break;
            case 2:
                // to be added...
                break;
            default:
                System.out.println("Unknown area...");

        }
    }

    void randomizerEnemy() {
        // to be implemented to randomize the enemy generator
    }

}
