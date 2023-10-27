package game;

import entity.enemy.Boss;
import entity.enemy.Common;
import entity.enemy.Enemy;
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
                monsterList = area.monsters.get(0);
                encounterEnemy(randomizerEnemy(monsterList));                
                break;
            case "Ruin of Asvangald":
                monsterList = area.monsters.get(0);
                encounterEnemy(randomizerEnemy(monsterList));                
                break;
            case "Niddrulenn":
                monsterList = area.monsters.get(0);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Etterfrost":
                monsterList = area.monsters.get(0);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Beorggwnis":
                monsterList = area.monsters.get(0);
                encounterEnemy(randomizerEnemy(monsterList));
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
                monsterList = area.monsters.get(1);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Ruin of Asvangald":
                 monsterList = area.monsters.get(1);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Niddrulenn":
                 monsterList = area.monsters.get(1);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Etterfrost":
                 monsterList = area.monsters.get(1);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Beorggwnis":
                 monsterList = area.monsters.get(1);
                encounterEnemy(randomizerEnemy(monsterList));
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
                monsterList = area.monsters.get(2);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Niddrulenn":
                monsterList = area.monsters.get(2);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Etterfrost":
                monsterList = area.monsters.get(2);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Beorggwnis":
                monsterList = area.monsters.get(2);
                encounterEnemy(randomizerEnemy(monsterList));
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
                monsterList = area.monsters.get(3);
                encounterEnemy(randomizerEnemy(monsterList));
                break;
            case "Ruin of Asvangald":
                monsterList = area.monsters.get(3);
                encounterEnemy(randomizerEnemy(monsterList));   
                break;
            case "Niddrulenn":
                monsterList = area.monsters.get(3);
                encounterEnemy(randomizerEnemy(monsterList));   
                break;
            case "Etterfrost":
                monsterList = area.monsters.get(3);
                encounterEnemy(randomizerEnemy(monsterList));   
                break;
            case "Beorggwnis":
                monsterList = area.monsters.get(3);
                encounterEnemy(randomizerEnemy(monsterList));   
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
                west.add(new Common("Gargoyle"));
                west.add(new Common("Vampire"));
                // east
                ArrayList<Enemy> east = new ArrayList<Enemy>();
                east.add(new Boss("Alucard Van Gogh"));
                east.add(new MiniBoss("Mighty Dullahan"));
                east.add(new Common("Pumpkin King"));
                east.add(new Common("Headless Horseman"));
                east.add(new Common("Deadly Jester"));
                // north
                ArrayList<Enemy> north = new ArrayList<Enemy>();
                north.add(new Boss("Alucard Van Gogh"));
                north.add(new MiniBoss("Elder Lich"));
                north.add(new Common("Mummy"));
                north.add(new Common("Zombie"));
                north.add(new Common("Undead"));
                // south
                ArrayList<Enemy> south = new ArrayList<Enemy>();
                south.add(new Boss("Alucard Van Gogh"));
                south.add(new MiniBoss("Dark Warlock"));
                south.add(new Common("Banshee"));
                south.add(new Common("Screaming Soul"));
                south.add(new Common("Lost Spirit"));

                // add to monster list area
                area.monsters.add(west);
                area.monsters.add(east);
                area.monsters.add(north);
                area.monsters.add(south);
                
                // to acces miniboss of west
                // area.monsters.get(0).get(1);
                break;
            case "Greimog Forest":
                area = new Area("Greimog Forest");

                // west
                west = new ArrayList<Enemy>();
                west.add(new Boss("Eldritch the Ancient"));
                west.add(new MiniBoss("Warbear"));
                west.add(new Common("Griffon"));
                west.add(new Common("Dire Wolf"));
                west.add(new Common("Dark Horse"));
                // east
                east = new ArrayList<Enemy>();
                east.add(new Boss("Eldritch the Ancient"));
                east.add(new MiniBoss("Queen Dryad"));
                east.add(new Common("Nature Fae"));
                east.add(new Common("Walking Snapdragon"));
                east.add(new Common("Mud Slime"));
                // north
                north = new ArrayList<Enemy>();
                north.add(new Boss("Eldritch the Ancient"));
                north.add(new MiniBoss("Corrupted Druid"));
                north.add(new Common("Treant"));
                north.add(new Common("Bear Lion"));
                north.add(new Common("Wendigo"));
                // south
                south = new ArrayList<Enemy>();
                south.add(new Boss("Eldritch the Ancient"));
                south.add(new MiniBoss("Green Dragon"));
                south.add(new Common("Giant"));
                south.add(new Common("Troll"));
                south.add(new Common("Goblin"));

                // add to monster list area
                area.monsters.add(west);
                area.monsters.add(east);
                area.monsters.add(north);
                area.monsters.add(south);
                break;
            case "Ruin of Asvangald":
                area = new Area("Ruin of Asvangald");

                // west
                west = new ArrayList<Enemy>();
                west.add(new Boss("Wall of Destiny"));
                west.add(new MiniBoss("Minotaur"));
                west.add(new Common("Arachne"));
                west.add(new Common("Lamia"));
                west.add(new Common("Gorgon"));
                // east
                east = new ArrayList<Enemy>();
                east.add(new Boss("Wall of Destiny"));
                east.add(new MiniBoss("Stone Basilisk"));
                east.add(new Common("Lizardian"));
                east.add(new Common("Serpent"));
                east.add(new Common("Two Headed Snake"));
                // north
                north = new ArrayList<Enemy>();
                north.add(new Boss("Wall of Destiny"));
                north.add(new MiniBoss("Guardian Statue"));
                north.add(new Common("Golem"));
                north.add(new Common("Elemental"));
                north.add(new Common("Boulder"));
                // south
                south = new ArrayList<Enemy>();
                south.add(new Boss("Wall of Destiny"));
                south.add(new MiniBoss("The Revenant"));
                south.add(new Common("Undead"));
                south.add(new Common("Howl"));
                south.add(new Common("Grimm"));

                // add to monster list area
                area.monsters.add(west);
                area.monsters.add(east);
                area.monsters.add(north);
                area.monsters.add(south);
                break;
            case "Niddrulenn":
                area  = new Area("Niddrulenn");

                // west
                west = new ArrayList<Enemy>();
                west.add(new Boss("Lord Kzaroth"));
                west.add(new MiniBoss("Azogg The Destroyer"));
                west.add(new Common("Orc Warrior"));
                west.add(new Common("Orc Berserker"));
                west.add(new Common("Orc Shadow"));
                // east
                east = new ArrayList<Enemy>();
                east.add(new Boss("King Nadurill"));
                east.add(new MiniBoss("Lanoir The Bright"));
                east.add(new Common("Elven Drow"));
                east.add(new Common("Dark Elf"));
                east.add(new Common("Elf Archer"));
                // north
                north = new ArrayList<Enemy>();
                north.add(new Boss("Lord Kzaroth"));
                north.add(new MiniBoss("Gorloth The Fallen"));
                north.add(new Common("Orc Shaman"));
                north.add(new Common("Orc Necromancer"));
                north.add(new Common("Orc Warlock"));
                // south
                south = new ArrayList<Enemy>();
                south.add(new Boss("King Nadurill"));
                south.add(new MiniBoss("Tirnanill The Ascended"));
                south.add(new Common("ELf Assasin"));
                south.add(new Common("Priest Elf"));
                south.add(new Common("Elf Magus"));

                // add to monster list area
                area.monsters.add(west);
                area.monsters.add(east);
                area.monsters.add(north);
                area.monsters.add(south);                
                break;
            case "Etterfrost":
                area = new Area("Etterfrost");

                // west
                west = new ArrayList<Enemy>();
                west.add(new Boss("Jack Frost"));
                west.add(new MiniBoss("Yuki Onna"));
                west.add(new Common("Yeti"));
                west.add(new Common("Snowman"));
                west.add(new Common("Snow Wolf"));
                // east
                east = new ArrayList<Enemy>();
                east.add(new Boss("Jack Frost"));
                east.add(new MiniBoss("Aurora Arboreal"));
                east.add(new Common("Glacial Elemental"));
                east.add(new Common("Polar Bear"));
                east.add(new Common("Frost Giant"));
                // north
                north = new ArrayList<Enemy>();
                north.add(new Boss("Jack Frost"));
                north.add(new MiniBoss("Cryomancer"));
                north.add(new Common("Moving Blizzard"));
                north.add(new Common("Frostbite Phantom"));
                north.add(new Common("Frozen Undead"));
                // south
                south = new ArrayList<Enemy>();
                south.add(new Boss("Jack Frost"));
                south.add(new MiniBoss("Frost Dragon"));
                south.add(new Common("Frozen Spirit"));
                south.add(new Common("Ice Phantom"));
                south.add(new Common("Arctic Fox"));

                // add to monster list area
                area.monsters.add(west);
                area.monsters.add(east);
                area.monsters.add(north);
                area.monsters.add(south);
                break;
            case "Beorggwnis":
                area = new Area("Beorggwnis");

                // west
                west = new ArrayList<Enemy>();
                west.add(new Boss("Azarok Ignia"));
                west.add(new MiniBoss("Ascended Nine Tails"));
                west.add(new Common("Lava Golem"));
                west.add(new Common("Fire Imp"));
                west.add(new Common("Hell Cat"));
                // east
                east = new ArrayList<Enemy>();
                east.add(new Boss("Azarok Ignia"));
                east.add(new MiniBoss("Pyromancer"));
                east.add(new Common("Lava Spirit"));
                east.add(new Common("Flame Elemental"));
                east.add(new Common("Ashen Undead"));
                // north
                north = new ArrayList<Enemy>();
                north.add(new Boss("Azarok Ignia"));
                north.add(new MiniBoss("Ancient Phoenix"));
                north.add(new Common("Hell Hound"));
                north.add(new Common("Volcanic Elemental"));
                north.add(new Common("Obsidian Guardian"));
                // south
                south = new ArrayList<Enemy>();
                south.add(new Boss("Azarok Ignia"));
                south.add(new MiniBoss("Red Dragon"));
                south.add(new Common("Salamander"));
                south.add(new Common("Wyvern"));
                south.add(new Common("Dragonling"));

                // add to monster list area
                area.monsters.add(west);
                area.monsters.add(east);
                area.monsters.add(north);
                area.monsters.add(south);
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
            case 2:
                areaName = "Greimog Forest";
                break;
            case 3:
                areaName = "Ruin of Asvangald";
                break;
            case 4:
                areaName = "Niddrulenn";
                break;
            case 5:
                areaName = "Etterfrost";
                break;
            case 6:
                areaName = "Beorggwnis";
                break;
        }

        return areaName;
    }

    

}
