import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
    // Variables
    Screens screenSet;
    Window gameWindow;
    String buttonName;
    boolean defending = false;

    ButtonHandler(String buttonName, Screens screenSet, Window gameWindow) {
        this.buttonName = buttonName;
        this.screenSet = screenSet;
        this.gameWindow = gameWindow;
    }

    public void actionPerformed(ActionEvent event) {
        chooseAction();
    }

    public void chooseAction() {
        switch (this.buttonName) {
            case "start button":
                startGame();
                break;
            case "test button":
                testGame();
                break;
            case "inspect button":
                checkForEnemy();
                break;
            case "move button":
                openMap();
                break;
            case "attack button":
                playerAttack();
                break;
            case "defend button":
                playerDefend();
                break;
            case "entrance button":
                changeLocation(0);
                break;
            case "lobby button":
                changeLocation(1);
                break;
            case "diamond button":
                changeLocation(2);
                break;
            case "hearts button":
                changeLocation(3);
                break;
            case "clubs button":
                changeLocation(4);
                break;
            case "spades button":
                changeLocation(5);
                break;
            case "hall button":
                changeLocation(6);
                break;
            case "royal flush button":
                changeLocation(7);
                break;
            default:
                break;
        }
    }

    // Start Game button Logic
    public void startGame() {
        screenSet.getScreen("Title").setInvisible();
        screenSet.changeLocationName("Entrance");
        screenSet.getScreen("Room").setVisible();

        refresh();

    }

    // Test button Logic
    public void testGame() {
        screenSet.getScreen("Title").setInvisible();
        screenSet.getScreen("Room").setVisible();
        refresh();
    }

    public void checkForEnemy() {
        if (screenSet.getCurrentRoom().getEnemy() != null) {
            startFight();
        }
    }

    public void startFight() {
        Creature player = screenSet.objects.getPlayer();
        Creature enemy = screenSet.getCurrentRoom().getEnemy();
        String enemyName = screenSet.getCurrentRoom().getEnemy().getName();
        screenSet.setEnemyName(enemyName);
        screenSet.getScreen("Room").setInvisible();
        screenSet.getScreen("Fight").setVisible();
        refresh();
        int playerSpeed = player.getSpeed();
        int enemySpeed = enemy.getSpeed();
        if (enemySpeed > playerSpeed){
            enemyTurn();
        }
    }

    public void playerAttack() {
        Creature player = screenSet.objects.getPlayer();
        Creature enemy = screenSet.getCurrentRoom().getEnemy();
        player.attackOther(enemy);
        if (enemy.getCurrentHealth() <= 0){
            player.setCurrentHealth(player.getHealth());
            screenSet.getCurrentRoom().setEnemy(null);
            screenSet.getScreen("Fight").setInvisible();
            screenSet.getScreen("Room").setVisible();
            Window gameWindow = screenSet.getGameWindow();
            gameWindow.getJFrame().invalidate();
            gameWindow.getJFrame().validate();
            gameWindow.getJFrame().repaint();
        }
        else {
            enemyTurn();
        }
    }

    public void playerDefend() {
        defending = true;
        enemyTurn();
    }
    public void enemyTurn(){
        Creature player = screenSet.objects.getPlayer();
        Creature enemy = screenSet.getCurrentRoom().getEnemy();
        int oldAttackMax = enemy.getAttackMax();
        if (defending){
            enemy.setAttackMax(1);
        }
        enemy.attackOther(player);
        screenSet.setPlayerHealth("Health : "+player.getCurrentHealth()+"/"+player.getHealth());
        enemy.setAttackMax(oldAttackMax);
        defending = false;
        if(!(player.getCurrentHealth() > 0)){
            screenSet.getScreen("Fight").setInvisible();
            screenSet.getScreen("Gameover").setVisible();
            refresh();
            player.setCurrentHealth(player.getHealth());
            enemy.setCurrentHealth(enemy.getHealth());
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
        refresh();
    }

    // Refreshing the Screen after any changes
    public void refresh() {
        gameWindow.getJFrame().invalidate();
        gameWindow.getJFrame().validate();
        gameWindow.getJFrame().repaint();
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
