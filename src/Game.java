import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
public class Game {
    public static void main(String[] args) {

        Window gameWindow = new Window(1400, 1050, JFrame.EXIT_ON_CLOSE, Color.black);
        gameWindow.getJFrame().setLocationRelativeTo(null);
        Container con = gameWindow.getCon();
        Screens screenSet = new Screens(con,gameWindow);
        gameWindow.getJFrame().setResizable(false);
        gameWindow.getJFrame().setTitle("Heart of the Cards");
        screenSet.getScreen("Title").setVisible();
    }
}