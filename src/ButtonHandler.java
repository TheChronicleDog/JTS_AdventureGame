import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ButtonHandler implements ActionListener {
    // Variables
    Screens screenSet;
    Window gameWindow;
    String buttonName;
    boolean defending = false;
    Graphics g;
    File music;
    Clip musicClip;

    ButtonHandler(String buttonName, Screens screenSet, Window gameWindow) {
        this.buttonName = buttonName;
        this.screenSet = screenSet;
        this.gameWindow = gameWindow;
    }

    public void actionPerformed(ActionEvent event) {
        try {
            chooseAction();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chooseAction() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        switch (this.buttonName) {
            case "start button" -> startGame();
            case "test button" -> testGame();
            case "inspect button" -> checkForEnemy();
            case "move button" -> openMap();
            case "attack button" -> playerAttack();
            case "defend button" -> playerDefend();
            case "entrance button" -> changeLocation(0);
            case "lobby button" -> changeLocation(1);
            case "diamond button" -> changeLocation(2);
            case "hearts button" -> changeLocation(3);
            case "clubs button" -> changeLocation(4);
            case "spades button" -> changeLocation(5);
            case "hall button" -> changeLocation(6);
            case "royal flush button" -> changeLocation(7);
            case "back button" -> goBack();
            default -> {
            }
        }
    }

    // Start Game button Logic
    public void startGame() {
        screenSet.getScreen("Title").setInvisible();
        screenSet.changeLocationName("Entrance");
        screenSet.getScreen("Room").setVisible();
        updatePictureImage();

        refresh();

    }

    // Test button Logic
    public void testGame() {
        screenSet.getScreen("Title").setInvisible();
        screenSet.getScreen("Room").setVisible();
        updatePictureImage();
        refresh();
    }

    public void checkForEnemy() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (screenSet.getCurrentRoom().getEnemy() != null) {
            startFight();
        } else {
            inspect();
        }
    }

    public void goBack() {
        screenSet.getScreen("Inspect").setInvisible();
        screenSet.getScreen("Room").setVisible();
        updatePictureImage();
        refresh();
    }

    public void inspect() {
        screenSet.setInspectInfoPanelText(screenSet.getCurrentRoom().getInformation());
        screenSet.getScreen("Room").setInvisible();
        screenSet.getScreen("Inspect").setVisible();

        refresh();
    }

    public void startFight() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        music = screenSet.getCurrentRoom().getMusic();
        musicClip = AudioSystem.getClip();
        musicClip.open(AudioSystem.getAudioInputStream(music));
        musicClip.start();

        Creature player = screenSet.objects.getPlayer();
        Creature enemy = screenSet.getCurrentRoom().getEnemy();
        screenSet.setPlayerHealth("Health : " + player.getCurrentHealth() + "/" + player.getHealth());
        String enemyName = enemy.getName();
        screenSet.setEnemyName(enemyName);
        screenSet.getScreen("Room").setInvisible();
        screenSet.getScreen("Fight").setVisible();
        updateEnemyImage();
        refresh();
        int playerSpeed = player.getSpeed();
        int enemySpeed = enemy.getSpeed();
        if (enemySpeed > playerSpeed) {
            enemyTurn();
        }
    }

    public void playerAttack() {
        Creature player = screenSet.objects.getPlayer();
        Creature enemy = screenSet.getCurrentRoom().getEnemy();
        player.attackOther(enemy);
        if (enemy.getCurrentHealth() <= 0) {
            screenSet.setInspectInfoPanelText(screenSet.getCurrentRoom().getInformation());
            screenSet.getScreen("Fight").setInvisible();
            screenSet.getScreen("Inspect").setVisible();
            enemyReward();
            player.setCurrentHealth(player.getHealth());
            screenSet.getCurrentRoom().setEnemy(null);
            refresh();
            stopMusic();

        } else {
            enemyTurn();
        }
    }

    public void enemyReward() {
        String enemyName = screenSet.getCurrentRoom().getEnemy().getName();
        switch (enemyName) {
            case "?????", "Royal Flush" -> {
                screenSet.getScreen("Inspect").setInvisible();
                screenSet.getScreen("Win").setVisible();
            }
        }
        if (screenSet.getCurrentRoom().getItem() != null) {
            screenSet.objects.getPlayer().equip(screenSet.getCurrentRoom().getItem());
        }
    }

    public void playerDefend() {
        defending = true;
        enemyTurn();
    }

    public void enemyTurn() {
        Creature player = screenSet.objects.getPlayer();
        Creature enemy = screenSet.getCurrentRoom().getEnemy();
        int oldAttackMax = enemy.getAttackMax();
        int playerOldHealth = player.getCurrentHealth();
        Clip clip = null;
        if (defending) {
            enemy.setAttackMax(1);
        }
        enemy.attackOther(player);

        if (playerOldHealth != player.getCurrentHealth()) {
            File damageSound = new File(System.getProperty("user.dir") + "\\src\\damageEffect.wav");
            AudioInputStream damageStream;
            {
                try {
                    damageStream = AudioSystem.getAudioInputStream(damageSound);
                } catch (UnsupportedAudioFileException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            try {
                clip.flush();
                clip.setFramePosition(0);
                clip.open(damageStream);
                clip.start();
            } catch (LineUnavailableException | IOException e) {
                throw new RuntimeException(e);
            }

        }
        screenSet.setPlayerHealth("Health : " + player.getCurrentHealth() + "/" + player.getHealth());
        enemy.setAttackMax(oldAttackMax);
        defending = false;
        if (!(player.getCurrentHealth() > 0)) {
            screenSet.getScreen("Fight").setInvisible();
            screenSet.getScreen("Gameover").setVisible();
            refresh();
            player.setCurrentHealth(player.getHealth());
            enemy.setCurrentHealth(enemy.getHealth());
            stopMusic();
        }

    }

    public void openMap() {

        screenSet.getScreen("Room").setInvisible();
        screenSet.getScreen("Map").setVisible();
        refresh();

    }

    public void changeLocation(int roomNumber) {

        screenSet.setCurrentRoom(screenSet.getObjects().getRoomArray()[roomNumber]);
        String locationName = screenSet.getCurrentRoom().getRoomName();
        screenSet.changeLocationName(locationName);
        screenSet.getScreen("Map").setInvisible();
        screenSet.getScreen("Room").setVisible();
        updatePictureImage();


        refresh();
    }

    // Refreshing the Screen after any changes
    public void refresh() {
        gameWindow.getJFrame().invalidate();
        gameWindow.getJFrame().validate();
        gameWindow.getJFrame().repaint();
    }

    public void stopMusic() {
        try {
            musicClip.stop();
            System.out.println(musicClip.isRunning());
        } catch (NullPointerException e) {
            System.out.println("There is no music playing");
        }
    }
    public void updatePictureImage(){
        if (screenSet.getCurrentRoom().getImage()!= null) {
            screenSet.getLocationPanel().getJPanel().removeAll();
            JLabel picLabel = new JLabel(new ImageIcon(screenSet.getCurrentRoom().getImage()));
            picLabel.setBounds(new Rectangle(730, 350));
            screenSet.getLocationPanel().getJPanel().add(picLabel,BorderLayout.CENTER);
        }
    }
    public void updateEnemyImage(){
        if(screenSet.getCurrentRoom().getEnemy() != null &&screenSet.getCurrentRoom().getEnemy().getImage()!= null){
            screenSet.getEnemyPanel().getJPanel().removeAll();
            JLabel picLabel = new JLabel(new ImageIcon(screenSet.getCurrentRoom().getEnemy().getImage()));
            picLabel.setBounds(new Rectangle(730, 350));
            screenSet.getEnemyPanel().getJPanel().add(picLabel,BorderLayout.CENTER);
        }
    }
}
/*
 * So, you have your screen all set up and your buttons and panels added to it,
 * now you just need to give a 'brain' to your buttons...?
 * Well lucky for you that information is right Here!
 *
 * Setting Up The Logic of a button
 *
 *
 *
 *
 *
 */
