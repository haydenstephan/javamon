package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class SelectScreen extends JPanel
{
    private int WIDTH = 800;
    private int HEIGHT = 600;
    private int fontSize = 30;
    JButton buttonBulbasaur;
    JButton buttonCharmander;
    JButton buttonSquirtle;
    JButton buttonPikachu;

    private class choiceButton extends JButton
    {
        public choiceButton(String s)
        {
            super(s);
            this.setFont(new Font("Arial", Font.PLAIN, fontSize));
            this.setForeground(Color.WHITE);
            this.setBackground(Color.decode("#FF0000"));
            this.setFocusable(false);
            this.setOpaque(true);
            this.setBorderPainted(false);
        }

    }

    public SelectScreen()
    {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.decode("#FFDE00"));

        buttonBulbasaur = new choiceButton("Bulbasaur");
        buttonCharmander = new choiceButton("Charmander");
        buttonSquirtle = new choiceButton("Squirtle");  
        buttonPikachu = new choiceButton("Pikachu");        
        
        int buttonWidth = 220;
        int buttonHeight = 70;

        buttonBulbasaur.setBounds(100, 225, buttonWidth, buttonHeight);
        buttonCharmander.setBounds(450, 470, buttonWidth, buttonHeight);
        buttonSquirtle.setBounds(100, 470, buttonWidth, buttonHeight); 
        buttonPikachu.setBounds(450, 225, buttonWidth, buttonHeight); 
      
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("images/SelectBackground.png")));
        background.setBounds(0, 0, 800, 600);

        this.add(buttonBulbasaur);
        this.add(buttonCharmander);
        this.add(buttonSquirtle);
        this.add(buttonPikachu);
        this.add(background);

    }

    public void setPikachuButtonListener(ActionListener l)
    {
        buttonPikachu.addActionListener(l);
    }

    public void setCharmanderButtonListener(ActionListener l)
    {
        buttonCharmander.addActionListener(l);
    }

    public void setBulbasuarButtonListener(ActionListener l)
    {
        buttonBulbasaur.addActionListener(l);
    }

    public void setSquirtleButtonListener(ActionListener l)
    {
        buttonSquirtle.addActionListener(l);
    }

    

}
