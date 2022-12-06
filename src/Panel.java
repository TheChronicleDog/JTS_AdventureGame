import java.awt.*;
import javax.swing.*;

public class Panel {
    int x, y, width, height;
    double multiplier=1.75;
    Color bgColor, textColor;
    String label;
    JLabel panelLabel;
    Font font;
    JPanel panel;
    static Font baseFont = new Font("Times New Roman", Font.PLAIN, (int)(28));

    Panel() {
        this(100, 100, 600, 150, Color.blue, Color.white, "N/A", baseFont);
    }

    Panel(int x, int y, int width, int height, Color bgColor) {
        this(x, y, width, height, bgColor, Color.white, "", baseFont);
    }

    Panel(int x, int y, int width, int height, Color bgColor, Color textColor, String label) {
        this(x, y, width, height, bgColor, textColor, label, baseFont);
    }

    Panel(int x, int y, int width, int height, Color bgColor, Color textColor, String label, Font font) {
        this.x = (int) (x*multiplier);
        this.y = (int)(y*multiplier);
        this.width = (int)(width*multiplier);
        this.height = (int)(height*multiplier);
        this.bgColor = bgColor;
        this.textColor = textColor;
        this.label = label;
        this.font = font;
        this.panel = new JPanel();
        createPanel();
    }

    public void createPanel() {
        panel.setBounds(x, y, width, height);
        panel.setBackground(bgColor);
        panelLabel = new JLabel(label);
        panelLabel.setForeground(textColor);
        panelLabel.setFont(font);
        panel.setVisible(true);
        panel.add(panelLabel);

    }
    public void setVisibility(boolean isVisible) {
        panel.setVisible(isVisible);
    }
    public JPanel getJPanel() {
        return panel;
    }
    public void setLabel(String label) {
        panelLabel.setText(label);
    }
}