import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
public class Game {
    public static void main(String[] args) {

        Window gameWindow = new Window(800, 600, JFrame.EXIT_ON_CLOSE, Color.black);
        Container con = gameWindow.getCon();
        Screens screenSet = new Screens(con,gameWindow);

        screenSet.getScreen("Title").setVisible();
    }
}