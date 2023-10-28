package feature;
import java.util.ArrayList;
import equipment.Equipment;

public class Inventory {
    private int maxSlot;
    private int gold;
    private ArrayList<Equipment> equipments = new ArrayList<Equipment>();
    
    public Inventory(int initialSlot) {
        this.maxSlot = initialSlot;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addItem(Equipment newEquipment) {
        if (equipments.size() < maxSlot) {
            this.equipments.add(newEquipment);
            System.out.println("Succesfully added " + newEquipment.getName() + " to inventory");
        }else {
            System.out.println("Inventory full !!!");
        }
    }

    // Need real sell item function get gold and not just delete the iteam, instead we get gold

    public void removeItem(int index) {
        if (index >= 0 && index < equipments.size()) {
            this.equipments.remove(index);
        }
    }

    public void printListEquipments() {
        System.out.println("Inventory List : ");
        for(int i=0; i<this.equipments.size(); i++) {
            System.out.println(i+1+ ". " + this.equipments.get(i).getName());
        }
    }

    public Equipment getEquipment(int index) {
        return equipments.get(index);
    }

    public int getGold() {
        return this.gold;
    }

    public int getMaxSlot() {
        return this.maxSlot;
    }

    public int getCurrSlot() {
        return this.equipments.size();
    }


}
