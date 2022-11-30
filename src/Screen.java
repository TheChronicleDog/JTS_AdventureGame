import java.awt.Color;

import javax.swing.JPanel;

public class Screen {
    JPanel screen;

    Screen(Window gameWindow) {
        screen = new JPanel();
        screen.setBounds(0,0,gameWindow.getJFrame().getWidth(), gameWindow.getJFrame().getHeight());
        screen.setLayout(null);
        screen.setBackground(Color.black);
        screen.setVisible(false);
        screen.setEnabled(true);
    }

    public void add(Button button) {
        screen.add(button.getJPanel());
    }

    public void add(Panel panel) {
        screen.add(panel.getJPanel());
    }

    public JPanel getScreen() {
        return screen;
    }

    public void setVisible() {
        screen.setVisible(true);
    }

    public void setInvisible() {
        screen.setVisible(false);
    }
}
