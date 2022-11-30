public class Item {
    int health, attack, defense, speed, luck;
    String name;
    Boolean isEquipped;

    Item() {
        this("N/A", 0, 0, 0, 0, 0, false);
    }

    Item(String name) {
        this(name, 0, 0, 0, 0, 0, false);
    }

    Item(String n, int h, int a, int d, int s, int l, boolean equipped) {
        setName(n);
        setHealth(h);
        setAttackMax(a);
        setDefense(d);
        setSpeed(s);
        setLuck(l);
        setEquipStatus(equipped);
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int h) {
        health = h;
    }

    public int getHealth() {
        return health;
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

    public void setEquipStatus(Boolean equip) {
        isEquipped = equip;
    }

    public boolean getEquipStatus() {
        return isEquipped;
    }

}