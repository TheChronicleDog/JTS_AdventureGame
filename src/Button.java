import javax.swing.*;
import java.awt.*;

public class Button {

   // Variables
   static Font titleFont = new Font("Times New Roman", Font.PLAIN, (int)(28*1.75));
   static Game game;
   int x, y, width, height; // Location, and Dimensions
   double multiplier = 1.75;
   String buttonName; // Name of Button for Button Handler
   String buttonText; // Text on the Button
   Color bgColor, textColor; // Colors of BackGround and Text
   Font buttonFont; // Font of button text
   Boolean isVisible; // Visibility Modifier
   ButtonHandler tsHandler; // Necessary Handler
   JPanel panel; // Panel The Button is on
   JButton button; // JPanel button Represents
   Screens screenSet;
   Window gameWindow;

   // Creating Button (No Information Given)
   Button(Screens screenSet) {
      this("test button", 0, 0, 80, 80, "Placeholder", Color.black, Color.white, titleFont,null,null);
   }
   // Creating Button Providing all parts
   Button(String buttonName, int x, int y, int width, int height, String buttonText, Color bgColor, Color textColor,
         Font buttonFont,Screens screenSet,Window gameWindow) {

      // Providing Name
      this.buttonName = buttonName;

      // Providing Size and Location
      this.x = (int) (x*multiplier);
      this.y = (int)(y*multiplier);
      this.width = (int)(width*multiplier);
      this.height = (int)(height*multiplier);

      // Changing button text and colors
      this.bgColor = bgColor;
      this.buttonText = buttonText;
      this.textColor = textColor;
      this.buttonFont = buttonFont;
      this.screenSet = screenSet;
      this.gameWindow = gameWindow;
   
      panel = new JPanel();
      panel.setVisible(true);
      createButton();
   }

   public void createButton() {

      //Creating Button and Handler
      button = new JButton(buttonText);
      ButtonHandler bHandler = new ButtonHandler(buttonName,screenSet,gameWindow);
      button.addActionListener(bHandler);

      //Setting Attributes
      button.setLayout(null);
      button.setBackground(bgColor);
      button.setForeground(textColor);
      button.setFont(buttonFont);
      button.setVisible(true);
      
      //Creating Panel and Adding Button to it
      createPanel();
      panel.add(button);
   }

   //Creating Button
   public void createPanel() {
      panel.setBounds(x, y, width, height);
      panel.setBackground(bgColor);
      panel.setVisible(true);
   }

   //Getters and Setters
   public JPanel getJPanel() {
      return panel;
   }

   public JButton getButton() {
      return button;
   }

   public String getButtonName() {
      return buttonName;
   }
   public int getX() {
       return x;
   }
   public int getY() {
       return y;
   }
   public void setIsVisible(Boolean isVisible) {
      this.isVisible = isVisible;
      panel.setVisible(isVisible);
   }
   public void setFontSize(int fontSize) {
      buttonFont = new Font("Times New Roman", Font.PLAIN, fontSize);
      button.setFont(buttonFont);
   }

   /*
Want to make a new Button? Heres How you do it:

For Information on how to create a new Button, Go to the 'Screens' File, Comment At the bottom

For Information on Creating Button Logic (What happens when you Press the button) Go to the 'ButtonHandler' File, Comment At the bottom

*/


}
