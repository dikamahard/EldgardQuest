package game;
import java.util.Scanner;

import entity.character.Character;


public class Menu {
    Scanner input;
    GameFunc gameFunc;
    Character player;

    
    public Menu(Character player) {
        input = new Scanner(System.in);
        gameFunc = new GameFunc(player);
        this.player = player;
    }


    // func menu interface

    public Character getCharacter() {
        return this.player;
    }

    public void startMenu() {
       
        System.out.println("=============================");
        System.out.println("===== Eldgard Quest RPG =====");
        System.out.println("=============================\n");
        System.out.println("Welcome to Eldgar Quest, a classical text based RPG game.");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("---------------------");
        System.out.print(">> ");
        
    }
    

    public void mainMenu() {
        System.out.println("==== Main Menu ====");
        System.out.println("1. Explore");
        System.out.println("2. Character Info");
        System.out.println("3. Shop");
        System.out.println("4. Save Game");
        System.out.println("5. Exit Game");
        System.out.println("---------------------");
        System.out.print(">> ");
    }

    public void areaMenu() {
        int area;
        System.out.println("==== Explore the Area ====");
        System.out.println("1. Castle of Fantanir");
        System.out.println("2. Greimog Forest ");
        System.out.println("3. Ruin of Asvangald");
        System.out.println("4. Niddrulenn");
        System.out.println("5. Etterfrost");
        System.out.println("6. Beorgingwnis");
        System.out.println("7. To be added...");
        System.out.println("---------------------");
        System.out.print(">> ");
        area = input.nextInt();
        compassDirection(area);
    } 


    // func choice choosen
    public void newGameChoosen() {
        // maybe some narative intro
        System.out.println("Greetings adventurer, before we start our adventure lets create your character first !");
        // create character
        gameFunc.createCharacter(player);
    }

    public void exploreChoosen() {
        areaMenu();
        return;
    }

    public void characterInfoChoosen() {
        player.showStatus();
        System.out.println("1. Back");
        if(input.nextInt() == 1) {
            mainMenu();
        }else {
            
        }
    }

    public void compassDirection(int area) {
        int compass;
        System.out.println("1. North");
        System.out.println("2. South");
        System.out.println("3. West");
        System.out.println("4. East");
        System.out.println("---------------------");
        System.out.print(">> ");
        compass = input.nextInt();
        gameFunc.generateEnemy(area, compass);
    }






    
    // public void northeEnemyGenerate(int area) {
    //     switch(area){
    //         case 1:
    //             // Castle of Fantanir
    //             break;
    //         case 2:
    //             // to be added...
    //             break;
    //         default:
    //             System.out.println("Unknown area...");

    //     }
    // }

    // public void SouthEnemyGenerate(int area) {
    //     switch(area){
    //         case 1:
    //             // Castle of Fantanir
    //             break;
    //         case 2:
    //             // to be added...
    //             break;
    //         default:
    //             System.out.println("Unknown area...");

    //     }
    // }

    // public void WestEnemyGenerate(int area) {
    //     switch(area){
    //         case 1:
    //             // Castle of Fantanir
    //             Enemy goblin = new Goblin("Hemogoblin");
    //             gameFunc.encounterEnemy(goblin);
    //             break;
    //         case 2:
    //             // to be added...
    //             break;
    //         default:
    //             System.out.println("Unknown area...");

    //     }
    // }

    // public void eastEnemyGenerate(int area) {
    //     switch(area){
    //         case 1:
    //             // Castle of Fantanir
    //             break;
    //         case 2:
    //             // to be added...
    //             break;
    //         default:
    //             System.out.println("Unknown area...");

    //     }
    // }

    
}
