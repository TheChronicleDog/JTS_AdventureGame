
//Imports

import java.awt.*;
import java.util.HashMap;

public class Screens {
    Container con; // Game Window Container
    Objects objects = new Objects();
    Window gameWindow;
    Room currentRoom = objects.getRoomArray()[0];

    // Fonts
    static Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
    HashMap<String, Screen> screenMap = new HashMap<>();
    Panel locationName, enemyName, playerHealth;

    Screens(Container con, Window gameWindow) {

        this.con = con;

        this.gameWindow = gameWindow;

        // Title Screen
        Screen titleScreen = new Screen(gameWindow);

        Panel titlePanel = new Panel(100, 100, 600, 150, Color.black, Color.white, "Heart of the Cards", titleFont);
        Button startButton = new Button("start button", 300, 400, 200, 100, "START", Color.black, Color.white,
                normalFont, this, gameWindow);

        titleScreen.add(titlePanel);
        titleScreen.add(startButton);
        add(titleScreen);

        screenMap.put("Title", titleScreen);
        // Game Over Screen
        Screen gameOverScreen = new Screen(gameWindow);

        Panel gameOverPanel = new Panel(100, 100, 600, 150, Color.black, Color.white, "Game Over", titleFont);
        //Button gameOverButton = new Button("game over button", 300, 400, 200, 100, "Restart?", Color.black, Color.white,normalFont, this, gameWindow);

        gameOverScreen.add(gameOverPanel);
        //gameOverScreen.add(gameOverButton);
        add(gameOverScreen);

        screenMap.put("Gameover", gameOverScreen);


        // Test Screen
        Screen testScreen = new Screen(gameWindow);

        Panel testPanel = new Panel(100, 100, 600, 150, Color.black, Color.white, "Test", titleFont);
        Button testButton = new Button("test button", 300, 400, 200, 100, "Test Me", Color.black, Color.white,
                normalFont, this, gameWindow);

        testScreen.add(testPanel);
        testScreen.add(testButton);
        add(testScreen);

        screenMap.put("Test", testScreen);

        // Rooms Screen
        Screen roomScreen = new Screen(gameWindow);
        Panel locationPanel = new Panel(30, 50, 730, 350, Color.blue);
        Button inspectButton = new Button("inspect button", 55, 420, 360, 200, "Inspect", Color.black, Color.white,
                normalFont, this, gameWindow);
        Button moveButton = new Button("move button", 425, 420, 300, 200, "Move", Color.black, Color.white,
                normalFont, this, gameWindow);
        locationName = new Panel(30, 10, 730, 50, Color.black, Color.white, "Location", normalFont);
        int roomFontSize = 80;
        inspectButton.setFontSize(roomFontSize);
        moveButton.setFontSize(roomFontSize);

        roomScreen.add(locationName);
        roomScreen.add(locationPanel);
        roomScreen.add(inspectButton);
        roomScreen.add(moveButton);
        add(roomScreen);

        screenMap.put("Room", roomScreen);
        //Fight Screen
        Screen fightScreen = new Screen(gameWindow);
        enemyName = new Panel(30, 10, 730, 50, Color.black, Color.white, "enemy", normalFont);
        playerHealth = new Panel(30, 400, 730, 50, Color.black, Color.white, "Health : "+objects.getPlayer().getCurrentHealth()+"/"+objects.getPlayer().getHealth(), normalFont);
        Panel enemyPanel = new Panel(30, 70, 730, 330, Color.blue);
        Button attackButton = new Button("attack button", 55, 445, 360, 200, "Attack", Color.black, Color.white,
                normalFont, this, gameWindow);
        Button defendButton = new Button("defend button", 425, 445, 300, 200, "Defend", Color.black, Color.white,
                normalFont, this, gameWindow);

        attackButton.setFontSize(roomFontSize);
        defendButton.setFontSize(roomFontSize);
        fightScreen.add(playerHealth);
        fightScreen.add(enemyName);
        fightScreen.add(enemyPanel);
        fightScreen.add(attackButton);
        fightScreen.add(defendButton);
        add(fightScreen);

        screenMap.put("Fight", fightScreen);
        //Map Screen
        Screen mapScreen = new Screen(gameWindow);

        Button entranceButton = new Button("entrance button", 10, 10, 100, 50, "Entrance", Color.black, Color.white, normalFont, this, gameWindow);
        Button lobbyButton = new Button("lobby button", 120, 10, 100, 50, "Lobby", Color.black, Color.white, normalFont, this, gameWindow);
        Button diamondButton = new Button("diamond button", 10, 70, 100, 50, "King of Diamonds Room", Color.black, Color.white, normalFont, this, gameWindow);
        Button heartsButton = new Button("hearts button", 120, 70, 100, 50, "Queen of Hearts Room", Color.black, Color.white, normalFont, this, gameWindow);
        Button clubsButton = new Button("clubs button", 10, 130, 100, 50, "Jack of Clubs Room", Color.black, Color.white, normalFont, this, gameWindow);
        Button spadesButton = new Button("spades button", 120, 130, 100, 50, "Ace of Spades Room", Color.black, Color.white, normalFont, this, gameWindow);
        Button hallButton = new Button("hall button", 10, 190, 100, 50, "Hallway", Color.black, Color.white, normalFont, this, gameWindow);
        Button royalFlushButton = new Button("royal flush button", 120, 190, 100, 50, "???? Room", Color.black, Color.white, normalFont, this, gameWindow);

        mapScreen.add(entranceButton);
        mapScreen.add(lobbyButton);
        mapScreen.add(diamondButton);
        mapScreen.add(heartsButton);
        mapScreen.add(clubsButton);
        mapScreen.add(spadesButton);
        mapScreen.add(hallButton);
        mapScreen.add(royalFlushButton);
        add(mapScreen);
        screenMap.put("Map", mapScreen);

    }

    public void add(Screen fillerScreen) {
        con.add(fillerScreen.getScreen());
    }

    public Screen getScreen(String keyString) {
        return screenMap.get(keyString);
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Objects getObjects() {
        return objects;
    }

    public void changeLocationName(String locationString) {
        locationName.setLabel(locationString);
}
    public void setEnemyName(String enemyString) {
        enemyName.setLabel(enemyString);
    }

    public void setPlayerHealth(String playerHealthString) {
        playerHealth.setLabel(playerHealthString);
    }

    public Window getGameWindow() {
        return gameWindow;
    }
}
/*
 * -Creating a New Screen (Panels and Buttons Included)-
 *
 * So you want to Make a new, or modify an existing, screen, huh? Well you've
 * come to the right Place!
 *
 * If you want to make a new Screen Hop down to the section titled 'New Screens
 * and You' on this file
 *
 * If you want to make / modify (Add a Button or Panel to) an existing Screen
 * Hop down to the section titled 'Modifying Screens' on this file
 *
 *
 * New Screens and You
 * Ahh I see, so it looks like you're ready to make a whole new screen of the
 * game, huh? Sounds Fun! Let's get started
 *
 * 1. Go to the constructor above, and below the last screen made, create a new
 * comment with the name of your new Screen
 *
 * 2. Create a 'Screen' object with the format 'Screen "screen name here" = new
 * Screen(con);' (If confused as to why, contact IT Support Doug)
 *
 * 3. Add what objects (Buttons or Panels) to your Screen With these Formats:
 *
 * Button : Button "button name here" = new Button(Button
 * name,x,y,width,height,Background Color, text Color, Text on button, Font)
 *
 * Panel : Panel "panel name here" = new Panel(x,y,height,width,Background
 * color, text color, text, text font)
 * Note: If you are creating a panel with no text, omit the text variables
 *
 * To add buttons : "screen name here".addButton("button name here")
 * To add Panels : "screen name here".addPanel("panel name here")
 *
 * 4. Finally, add your Screen to the HashMap:
 * screenMap.put("Screen name as a string","Screen Name")
 *
 * And you're done! For information on buttons utilize your screen, go to the
 * ButtonHandler file, comment at the bottom
 *
 * Modifying Screens
 * So you're all done with the hard part of making the screen, and now you want
 * to change it?
 * Well that's the easy bit, using step three of the 'New Screens and You'
 * section, modify the information of the buttons and panels provided, to match
 * your new desires!
 * Just remember to add any new panels or buttons to the screen, before adding
 * them to the ScreenMap, otherwise they won't show up!
 *
 *
 */
