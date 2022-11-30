import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class Window {
    int width, height, operation;
    Color bgColor;
    JFrame window;
    Container con;

    Window() {
        this(800, 600, JFrame.EXIT_ON_CLOSE, Color.BLACK);
    }

    Window(int width, int height, int operation, Color bgColor) {
        window = new JFrame();
        con = window.getContentPane();
        window.setSize(width, height);
        window.setDefaultCloseOperation(operation);
        window.getContentPane().setBackground(bgColor);
        window.setLayout(null);
        window.setVisible(true);
    }


    public JFrame getJFrame() {
        return this.window;
    }

    public Container getCon() {
        return this.con;
    }
}
