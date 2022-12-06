import java.io.File;

public class Room {
    String roomName;
    Creature enemy;
    Item item;
    String information;
    File music;
    Room(){
        this("empty",null,null,"empty",null);
    }
    Room(String roomName,Creature enemy, Item item,String information, File music){
        this.roomName = roomName;
        this.enemy = enemy;
        this.item = item;
        this.information = information;
        this.music = music;
    }

    public void setEnemy(Creature enemy) {
        this.enemy = enemy;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Creature getEnemy() {
        return enemy;
    }

    public Item getItem() {
        return item;
    }

    public String getInformation() {
        return information;
    }

    public String getRoomName() {
        return roomName;
    }

    public File getMusic() {
        return music;
    }
}


