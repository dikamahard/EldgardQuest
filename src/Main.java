import entity.*;
import entity.Character;
import equipment.*;

public class Main {
    public static void main(String[] args) {
        Character p1 = new Human("Argus");
        Enemy f1 = new Goblin("HemoGoblin");
        Weapon sword = new Weapon("Excalibur", 20);

        Human player = (Human)p1;
        player.equipWeapon(sword);

        Goblin foe1 = (Goblin)f1;

        System.out.println(" >>> BATTLEEEE!!!\n");
        player.attacking(foe1);
        foe1.attacking(player);
        player.showStatus();

        player.attacking(foe1);
        foe1.attacking(player);
        player.showStatus();

        player.attacking(foe1);
        foe1.attacking(player);
        player.showStatus();

        player.attacking(foe1);
        foe1.attacking(player);
        player.showStatus();

        player.attacking(foe1);
        foe1.attacking(player);
        player.showStatus();

    }
}
