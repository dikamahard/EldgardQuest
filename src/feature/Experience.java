package feature;

public class Experience {
    private long expCap;
    private long currentExp;
    private int lvl;
    private long expDrop;

    public Experience() {
        this.expCap = 100;
        this.lvl = 1;
        this.expDrop = 0;
    }

    public Experience(long expCap, int lvl, long expDrop) {
        this.expCap = expCap;
        this.lvl = lvl;
        this.expDrop = expDrop;
    }

    public void levelUp() {
        System.out.println("!! LEVEL UP !!");
        this.expCap *= 2; 
        this.lvl++;
        this.currentExp = 0;
    }

    public int getLvl() {
        return this.lvl;
    }

    public long getExpDrop() {
        return this.expDrop;
    }

    public long getCurrentExp() {
        return this.currentExp;
    }

    public long getExpCap() {
        return this.expCap;
    }

    public void setExpDrop(long expDrop) {
        this.expDrop = expDrop;
    }


    public void gainExp(long exp) {
        this.currentExp += exp;
        if(this.currentExp > expCap) {
            long tempXp = currentExp % expCap;
            this.levelUp();
            this.currentExp = tempXp;
        } else if(this.currentExp == expCap) {
            this.levelUp();
        }
    }

}
