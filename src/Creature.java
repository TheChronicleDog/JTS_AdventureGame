import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Creature {
    int maxHealth,currentHealth, attack, defense, speed, luck;
    BufferedImage image;
    String name;

    Creature() throws IOException {
        this("N/A", 1, 1, 1, 1, 1,null);
    }

    Creature(String n, int h, int a, int d, int s, int l, File imageFile) throws IOException {
        setName(n);
        setHealth(h);
        setAttackMax(a);
        setDefense(d);
        setSpeed(s);
        setLuck(l);
        currentHealth = maxHealth;
        if (imageFile != null) {
            image = ImageIO.read(imageFile);
        }
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int h) {
        maxHealth = h;
    }

    public int getHealth() {
        return maxHealth;
    }

    public void setAttackMax(int a) {
        attack = a;
    }

    public int getAttackMax() {

        return attack;
    }

    public void setDefense(int d) {
        defense = d;
    }

    public int getDefense() {
        return defense;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public int getSpeed() {
        return speed;
    }

    public void setLuck(int l) {
        luck = l;
    }

    public int getLuck() {
        return luck;
    }

    public int CalculateAttack() {
        Random rand = new Random();
        int randomNum = rand.nextInt(attack) + 1;
        return randomNum;
    }

    public Boolean CalculateMiss() {
        Random rand = new Random();
        int missVal = rand.nextInt(100);
        return luck >= missVal;
    }

    public void attackOther(Creature victim) {
        int attack = CalculateAttack();
        int difference = attack - victim.getDefense();
        boolean miss = CalculateMiss();
        printAttack(attack,miss);
        if (miss && difference > 0) {
            victim.setCurrentHealth(victim.getCurrentHealth() - difference);
        }
    }

    public void printAttack(int attack,boolean miss) {
        System.out.printf("%nName: %s%n Attack : %d %n Hit : %b %n",name ,attack, miss);
    }

    public void printAllStats() {
        System.out.println(" ");
        System.out.printf("Name: %s %n Health: %d %n Attack Max: %d %n Defense: %d %n Speed: %d %n Luck: %d %n",
                name, maxHealth, attack, defense, speed, luck);
    }

    public void equip(Item equipmentItem) {
        if (equipmentItem.getEquipStatus() == false) {
            setHealth(getHealth() + equipmentItem.getHealth());
            setAttackMax((getAttackMax() + equipmentItem.getAttackMax()));
            setDefense(getDefense() + equipmentItem.getDefense());
            setSpeed(getSpeed() + equipmentItem.getSpeed());
            setLuck(getLuck() + equipmentItem.getLuck());
            equipmentItem.setEquipStatus(true);
        }
    }

    public void dequip(Item equipmentItem) {
        if (equipmentItem.getEquipStatus()) {
            setHealth(getHealth() - equipmentItem.getHealth());
            setAttackMax((getAttackMax() - equipmentItem.getAttackMax()));;
            setDefense(getDefense() - equipmentItem.getDefense());
            setSpeed(getSpeed() - equipmentItem.getSpeed());
            setLuck(getLuck() - equipmentItem.getLuck());
            equipmentItem.setEquipStatus(false);
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}
