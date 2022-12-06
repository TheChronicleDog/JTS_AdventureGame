import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Room {
    String roomName;
    Creature enemy;
    Item item;
    String information;
    BufferedImage image;
    Clip musicClip;
    Room() throws IOException {
        this("empty",null,null,"empty",null,null);
    }
    Room(String roomName,Creature enemy, Item item,String information, File music,File imageFile) throws IOException {
        this.roomName = roomName;
        this.enemy = enemy;
        this.item = item;
        this.information = information;
        if(music != null) {
            try {
                musicClip = AudioSystem.getClip();
                musicClip.open(AudioSystem.getAudioInputStream(music));
            } catch (UnsupportedAudioFileException | LineUnavailableException e) {
                throw new RuntimeException(e);
            }
        }
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

    public Clip getMusicClip() {
        return musicClip;
    }

    public BufferedImage getImage() {
        return image;
    }
}



