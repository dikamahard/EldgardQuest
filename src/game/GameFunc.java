package game;

import entity.enemy.Alucard;
import entity.enemy.Boss;
import entity.enemy.Common;
import entity.enemy.Enemy;
import entity.enemy.Franken;
import entity.enemy.Goblin;
import entity.enemy.MiniBoss;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entity.character.Character;
import entity.character.Human;

public class GameFunc {
    // some idea
    // we add character here, so this class can modified player
    // without passing it as an argument because we put the player on this constructor
    // and ofcourse add this class as an antribute for menu class and at the constructor too
    Character player;
    //ArrayList<Enemy> monsters = new ArrayList<Enemy>();

    public class Area{
        String name;
        ArrayList<ArrayList<Enemy>> monsters = new ArrayList<ArrayList<Enemy>>();

        public Area(String name) {
            this.name = name;
        }
    }


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
        System.out.println("FIGHTING GO !!!");
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

    /* 
    public void generateEnemy(int area, int compass) {
        Area objArea = generateArea(area);

        switch(compass) {
            case 1:
                // west
                westEnemyGenerate(area); // area can be changed to objArea and so on
                break;
            case 2:
                // east
                eastEnemyGenerate(area);
                break;
            case 3:
                 // north
                 northeEnemyGenerate(area);
                break;
            case 4:
                // south
                southEnemyGenerate(area);
                break;
            default:
        }
    } */

    public void generateEnemy(int area, int compass) {

        //convert int area to obj
        Area objArea = generateArea(getAreaName(area));

        switch(compass) {
            case 1:
                // west
                westEnemyGenerate(objArea); 
                break;
            case 2:
                // east
                eastEnemyGenerate(objArea);
                break;
            case 3:
                 // north
                 northeEnemyGenerate(objArea); // EXPERIMENTAL
                break;
            case 4:
                // south
                southEnemyGenerate(objArea);
                break;
            default:
        }
    }

    public void westEnemyGenerate(Area area) {
        ArrayList<Enemy> monsterList = new ArrayList<>();
        switch(area.name){
            case "Castle of Fantanir":
                monsterList = area.monsters.get(0);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Greimog Forest":
                // to be added...
                break;
            case "Ruin of Asvangald":
                // to be added...
                break;
            case "Niddrulenn":
                // to be added...
                break;
            case "Etterfrost":
                // to be added...
                break;
            case "Beorggwnis":
                // to be added...
                break;
            default:
                System.out.println("Unknown area...");

        }
    }

    public void eastEnemyGenerate(Area area) {
        ArrayList<Enemy> monsterList = new ArrayList<>();
        switch(area.name){
            case "Castle of Fantanir":
                monsterList = area.monsters.get(1);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Greimog Forest":
                // to be added...
                break;
            case "Ruin of Asvangald":
                // to be added...
                break;
            case "Niddrulenn":
                // to be added...
                break;
            case "Etterfrost":
                // to be added...
                break;
            case "Beorggwnis":
                // to be added...
                break;
            default:
                System.out.println("Unknown area...");
        }
    }

    public void northeEnemyGenerate(Area area) {
        ArrayList<Enemy> monsterList = new ArrayList<>();
        switch(area.name){
            case "Castle of Fantanir":
                // mob list
                //ArrayList<Enemy> monsterList = area.monsters.get(2);
                monsterList = area.monsters.get(2);
                // randomize encounter
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Greimog Forest":
                monsterList = area.monsters.get(2);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Ruin of Asvangald":
                // to be added...
                break;
            case "Niddrulenn":
                // to be added...
                break;
            case "Etterfrost":
                // to be added...
                break;
            case "Beorggwnis":
                // to be added...
                break;
            default:
                System.out.println("Unknown area...");

        }
    }

/* 
    public void northeEnemyGenerate(int area) {
        switch(area){
            case 1:
                // Castle of Fantanir
                // mob list
                // randomize func encounter
                // encounter   
                break;
            case 2:
                // to be added...
                break;
            default:
                System.out.println("Unknown area...");

        }
    } */

    public void southEnemyGenerate(Area area) {
        ArrayList<Enemy> monsterList = new ArrayList<>();
        switch(area.name){
            case "Castle of Fantanir":   
                monsterList = area.monsters.get(3);
                encounterEnemy(randomizerEnemy(monsterList));            
                break;
            case "Greimog Forest":
                // to be added...
                break;
            case "Ruin of Asvangald":
                // to be added...
                break;
            case "Niddrulenn":
                // to be added...
                break;
            case "Etterfrost":
                // to be added...
                break;
            case "Beorggwnis":
                // to be added...
                break;
            default:
                System.out.println("Unknown area...");
        }
    }

    Enemy randomizerEnemy(ArrayList<Enemy> monsterList) {
        Enemy boss = monsterList.get(0);
        Enemy miniBoss = monsterList.get(1);
        Random rand = new Random();

        // Generate a random number between 0 and 1
        double randomValue = rand.nextDouble();

        Enemy result = null;
        if(randomValue < 0.01) {    // 1% chance
            result = boss;
        }else if(randomValue < 0.01 + 0.05) {   // 5% chance
            result = miniBoss;
        }else {     // 94% chance
            // get the common monster list excluding boss + miniboss
            ArrayList<Enemy> commonMonster = new ArrayList<Enemy>(monsterList.subList(2, monsterList.size()));
            
            // get random monster from the common list
            Integer index = rand.nextInt(commonMonster.size());
            result = commonMonster.get(index);
        }
        System.out.println(result.toString());

        return result;
    }

    Area generateArea(String name) {
        Area area = null;
        switch(name) {
            case "Castle of Fantanir": 
                area = new Area("Castle of Fantanir");

                // west
                ArrayList<Enemy> west = new ArrayList<Enemy>();
                west.add(new Boss("Alucard Van Gogh"));
                west.add(new MiniBoss("Dr Franken"));
                west.add(new Common("Werewolf"));
                // east
                ArrayList<Enemy> east = new ArrayList<Enemy>();
                east.add(new Boss("Alucard Van Gogh"));
                east.add(new MiniBoss("Mighty Dullahan"));
                east.add(new Common("Vampire"));
                // north
                ArrayList<Enemy> north = new ArrayList<Enemy>();
                north.add(new Boss("Alucard Van Gogh"));
                north.add(new MiniBoss("Elder Lich"));
                north.add(new Common("Mummy"));
                // south
                ArrayList<Enemy> south = new ArrayList<Enemy>();
                south.add(new Boss("Alucard Van Gogh"));
                south.add(new MiniBoss("Dark Warlock"));
                south.add(new Common("Banshee"));

                // add to monster list area
                area.monsters.add(west);
                area.monsters.add(east);
                area.monsters.add(north);
                area.monsters.add(south);
                
                // to acces miniboss of west
                // area.monsters.get(0).get(1);
                break;
            case "Greimog Forest":
                // to be added...
                break;
            case "Ruin of Asvangald":
                // to be added...
                break;
            case "Niddrulenn":
                // to be added...
                break;
            case "Etterfrost":
                // to be added...
                break;
            case "Beorggwnis":
                // to be added...
                break;
        }

        return area;
    }

    String getAreaName(int choosen) {
        String areaName = "";
        switch(choosen) {
            case 1:
                areaName = "Castle of Fantanir";
                break;
        }

        return areaName;
    }

    

}
