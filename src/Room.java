import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Room {
    String roomName;
    Creature enemy;
    Item item;
    String information;
    File music;
    BufferedImage image;
    Room() throws IOException {
        this("empty",null,null,"empty",null,null);
    }
    Room(String roomName,Creature enemy, Item item,String information, File music,File imageFile) throws IOException {
        this.roomName = roomName;
        this.enemy = enemy;
        this.item = item;
        this.information = information;
        this.music = music;
        if(imageFile != null) {
            image = ImageIO.read(imageFile);
        }
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

    public BufferedImage getImage() {
        return image;
    }
}



