package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import model.*;

@SuppressWarnings("serial")
public class BattleScreen extends JPanel {
    JPanel topWindow;
    JPanel bottomWindow;
    PanelWithBackground midWindow;

    JLabel javamonPlayerDisplay;
    JLabel javamonOpponentDisplay;

    JButton actionButton1;
    JButton actionButton2;
    JButton actionButton3;
    JButton actionButton4;
    JButton nextButton;

    Javamon playerJavamon;
    Javamon opponentJavamon;

    JLabel playerHealth;
    JLabel opponentHealth;

    JLabel playerName;
    JLabel opponentName;

    JLabel topText;
    JLabel bottomText;

    Random rng;

    public BattleScreen() {
        rng = new Random();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // seperate scene into three sections and initialize them
        topWindow = new JPanel();
        midWindow = new PanelWithBackground(new ImageIcon(getClass().getResource("images/battleBackgrounds/fieldBackground.png")).getImage());
        bottomWindow = new JPanel();
        this.setBackground((Color.decode("#FFDE00")));
        setUpTopWindow();
        setUpMidWindow();
        setUpBottomWindow();

        // add the sections to the main JPanel
        this.add(topWindow);
        this.add(midWindow);
        this.add(bottomWindow);
        this.revalidate();
        this.repaint();
    }

    private void setUpTopWindow() {
        topWindow.setBackground(Color.decode("#FFDE00"));
        topWindow.setPreferredSize(new Dimension(800, 100));
        topWindow.setLayout(new GridLayout(2, 1));

        // text that indicates whose turn it is
        topText = new JLabel("Your Turn", JLabel.CENTER);
        topText.setFont(topText.getFont().deriveFont(32.0f));

        // text that indicates what action is chosen
        bottomText = new JLabel("Choose an action", JLabel.CENTER);
        bottomText.setFont(topText.getFont().deriveFont(18.0f));

        // add elements to topWindow
        topWindow.add(topText);
        topWindow.add(bottomText);
    }

    private void setUpMidWindow() {
        // add a black border to the midWindow and set size
        Border blackline = BorderFactory.createLineBorder(Color.BLACK, 9);
        midWindow.setBorder(blackline);
        midWindow.setPreferredSize(new Dimension(800, 400));
        midWindow.setLayout(null);

        // set the image used to display the Javamon
        javamonPlayerDisplay = new JLabel("placeholder.png");
        javamonOpponentDisplay = new JLabel("placeholder.png");

        // position and scale the images
        javamonPlayerDisplay.setBounds(100, 95, 200, 200);
        javamonOpponentDisplay.setBounds(500, 95, 200, 200);

        // indicates health of Javamon
        playerHealth = new JLabel("placeholder");
        playerHealth.setBounds(130, 295, 500, 50);
        playerHealth.setFont(playerHealth.getFont().deriveFont(20.0f));

        opponentHealth = new JLabel("placeholder");
        opponentHealth.setBounds(528, 295, 500, 50);
        opponentHealth.setFont(opponentHealth.getFont().deriveFont(20.0f));

        // indicate name of Javamon
        playerName = new JLabel("placeholder");
        playerName.setBounds(130, 323, 500, 50);
        playerName.setFont(playerName.getFont().deriveFont(30.0f));

        opponentName = new JLabel("placeholder");
        opponentName.setBounds(528, 323, 500, 50);
        opponentName.setFont(opponentName.getFont().deriveFont(30.0f));

        // add elements to the midWindow
        midWindow.add(javamonPlayerDisplay);
        midWindow.add(javamonOpponentDisplay);
        midWindow.add(playerHealth);
        midWindow.add(opponentHealth);
        midWindow.add(playerName);
        midWindow.add(opponentName);
    }

    private void setUpBottomWindow() {
        bottomWindow.setBackground(Color.decode("#FFDE00"));
        bottomWindow.setPreferredSize(new Dimension(800, 100));

        // create action buttons and give them their action names
        actionButton1 = new JButton("action1");
        actionButton2 = new JButton("action2");
        actionButton3 = new JButton("action3");
        actionButton4 = new JButton("action4");
        nextButton = new JButton("Next");

        // set size of buttons
        actionButton1.setPreferredSize(new Dimension(150, 60));
        actionButton2.setPreferredSize(new Dimension(150, 60));
        actionButton3.setPreferredSize(new Dimension(150, 60));
        actionButton4.setPreferredSize(new Dimension(150, 60));
        nextButton.setPreferredSize(new Dimension(150, 60));

        // set colors of buttons
        actionButton1.setForeground(Color.WHITE);
        actionButton2.setForeground(Color.WHITE);
        actionButton3.setForeground(Color.WHITE);
        actionButton4.setForeground(Color.WHITE);
        nextButton.setForeground(Color.WHITE);

        // lines added to fix compatibility issues
        actionButton1.setOpaque(true);
        actionButton1.setBorderPainted(false);
        actionButton2.setOpaque(true);
        actionButton2.setBorderPainted(false);
        actionButton3.setOpaque(true);
        actionButton3.setBorderPainted(false);
        actionButton4.setOpaque(true);
        actionButton4.setBorderPainted(false);
        nextButton.setOpaque(true);
        nextButton.setBorderPainted(false);

        // add elements to the bottomWindow
        bottomWindow.add(actionButton1);
        bottomWindow.add(actionButton2);
        bottomWindow.add(actionButton3);
        bottomWindow.add(actionButton4);
        bottomWindow.add(nextButton);
    }

    public void setTopText(String t) {
        topText.setText(t);
    }

    public void setBottomText(String t) {
        bottomText.setText(t);
    }

    public void showWhoWon(boolean playerWins)
    {
        disableButtons();
        enableNextButton();

        if(playerWins)
        {
            setTopText("You Win!");
            playerHealth.setForeground(Color.BLACK);
            opponentHealth.setForeground(Color.RED);
        }
        else
        {
            setTopText("Your Rival Wins");    
            if(opponentJavamon.getJavamonName().equals("Magikarp"))
            {
                setTopText("I can't believe you lost to a Magikarp!");    
            }
            playerHealth.setForeground(Color.RED);
            opponentHealth.setForeground(Color.BLACK);
        }

        setBottomText("Press next to continue"); 
    }

    static Color getColorFromChoice(int x)
    {
        Color color;

        if(x == 0)
        {
            color = Color.BLACK;
        }
        else if(x == 1)
        {
            color = Color.RED;
        }
        else
        {
            color = Color.decode("#1248c7");
        }
    
        return color;
    }


    public void showBattleResults(boolean playerGoes, String battleText, int playerColorChoice, int rivalColorChoice) {
        disableButtons();
        enableNextButton();

        if(playerGoes)
        {
            setTopText("Player Attacks");
        }
        else
        {
            setTopText("Rival Attacks");       
        }


        //-------set health colors-------//
        playerHealth.setForeground(getColorFromChoice(playerColorChoice));
        opponentHealth.setForeground(getColorFromChoice(rivalColorChoice));
        updateHealth();
        //updateParalysis();

        setBottomText(battleText);  
        this.revalidate();
        this.repaint();
    }

    public void showWaitingForAction() {
        enableButtons();
        setTopText("Waiting");
        setBottomText("Choose an action");
        playerHealth.setForeground(Color.BLACK);
        opponentHealth.setForeground(Color.BLACK);
        actionButton1.setToolTipText(playerJavamon.getMove1().getToolTipText(playerJavamon));
        actionButton2.setToolTipText(playerJavamon.getMove2().getToolTipText(playerJavamon));
        actionButton3.setToolTipText(playerJavamon.getMove3().getToolTipText(playerJavamon));
        actionButton4.setToolTipText(playerJavamon.getMove4().getToolTipText(playerJavamon));
        
        javamonPlayerDisplay.setToolTipText(playerJavamon.getToolTipText());
        javamonOpponentDisplay.setToolTipText(opponentJavamon.getToolTipText());
        
        disableNextButton();
        this.revalidate();
        this.repaint();
    }

    public void setUpNewGame(Javamon player, Javamon computer) {
        playerJavamon = player;
        opponentJavamon = computer;
        
        try {
            javamonPlayerDisplay.setIcon(new ImageIcon(getClass().getResource(playerJavamon.getImageFileName())));
            javamonOpponentDisplay.setIcon(new ImageIcon(getClass().getResource(opponentJavamon.getImageFileName())));            
        } 
        catch (Exception e) {
            System.out.println("Error: could not load image name " + playerJavamon.getImageFileName() + " or " + opponentJavamon.getImageFileName());
        }
        
        setTopText("Waiting");
        setBottomText("Choose an action");
        
        updateActionButtonTexts();
        disableNextButton();
        enableButtons();

        if(playerJavamon.getJavamonName().equals("Magikarp"))
        {
            setMagikarpBackground();
        }
        else
        {
            setRandomBackgound();
        }
       
        
        playerHealth.setForeground(Color.BLACK);
        opponentHealth.setForeground(Color.BLACK);
        playerName.setForeground(Color.BLACK);
        opponentName.setForeground(Color.BLACK);

        updateHealth();
        playerName.setText(playerJavamon.getName());
        opponentName.setText(opponentJavamon.getName());


        actionButton1.setToolTipText(playerJavamon.getMove1().getToolTipText(playerJavamon));
        actionButton2.setToolTipText(playerJavamon.getMove2().getToolTipText(playerJavamon));
        actionButton3.setToolTipText(playerJavamon.getMove3().getToolTipText(playerJavamon));
        actionButton4.setToolTipText(playerJavamon.getMove4().getToolTipText(playerJavamon));

        javamonPlayerDisplay.setToolTipText(playerJavamon.getToolTipText());
        javamonOpponentDisplay.setToolTipText(opponentJavamon.getToolTipText());

        this.revalidate();
        this.repaint();
    }

    public void setMove1ButtonListener(ActionListener l) {
        actionButton1.addActionListener(l);
    }

    public void setMove2ButtonListener(ActionListener l) {
        actionButton2.addActionListener(l);
    }

    public void setMove3ButtonListener(ActionListener l) {
        actionButton3.addActionListener(l);
    }

    public void setMove4ButtonListener(ActionListener l) {
        actionButton4.addActionListener(l);
    }

    public void setNextButtonListener(ActionListener l) {
        nextButton.addActionListener(l);
    }


    // will reset the action names for the buttons, needed if setting a new Javamon
    private void updateActionButtonTexts() {
        actionButton1.setText(playerJavamon.getMove1().getName());
        actionButton2.setText(playerJavamon.getMove2().getName());
        actionButton3.setText(playerJavamon.getMove3().getName());
        actionButton4.setText(playerJavamon.getMove4().getName());
    }

    private void updateHealth() {
        playerHealth.setText("HP: " + String.valueOf(playerJavamon.getCurrentHealth()));
        opponentHealth.setText("HP: " + String.valueOf(opponentJavamon.getCurrentHealth()));
    }

    private void updateParalysis() {
        if (playerJavamon.getParalyzeTurns() > 0)
        {
            playerName.setText(playerJavamon.getName() + " (PAR)");
        }
        else
        {
            playerName.setText(playerJavamon.getName());
        }
        if (opponentJavamon.getParalyzeTurns() > 0)
        {
            opponentName.setText(opponentJavamon.getName() + " (PAR)");
        }
        else
        {
            opponentName.setText(opponentJavamon.getName());
        }
    }

    private void enableNextButton() {
        nextButton.setEnabled(true);
        nextButton.setBackground(Color.decode("#FF0000"));
    }

    private void disableNextButton() {
        nextButton.setEnabled(false);
        nextButton.setBackground(Color.GRAY);
    }

    private void enableButtons() {
        actionButton1.setEnabled(true);
        actionButton2.setEnabled(true);
        actionButton3.setEnabled(true);
        actionButton4.setEnabled(true);
        actionButton1.setBackground(Color.decode("#FF0000"));
        actionButton2.setBackground(Color.decode("#FF0000"));
        actionButton3.setBackground(Color.decode("#FF0000"));
        actionButton4.setBackground(Color.decode("#FF0000"));
    }

    private void disableButtons() {
        actionButton1.setEnabled(false);
        actionButton2.setEnabled(false);
        actionButton3.setEnabled(false);
        actionButton4.setEnabled(false);
        actionButton1.setBackground(Color.GRAY);
        actionButton2.setBackground(Color.GRAY);
        actionButton3.setBackground(Color.GRAY);
        actionButton4.setBackground(Color.GRAY);
    }


    private void setBackground(String imageName) {
        try {
            midWindow.setImage(new ImageIcon(getClass().getResource(imageName)).getImage());
        } 
        catch (Exception e) {
            System.out.println("Error: could not load image file: " + imageName);
        }
        
    }

    private void setMagikarpBackground()
    {
        String image = "images/battleBackgrounds/magikarpBackground.png";
        this.setBackground(image);
    }

    private void setRandomBackgound() {
        ArrayList<String> images = new ArrayList<String>();
        images.add("images/battleBackgrounds/fieldBackground.png");
        images.add("images/battleBackgrounds/fieldBackground2.png");
        images.add("images/battleBackgrounds/fieldBackground3.png");
        images.add("images/battleBackgrounds/fieldBackground4.png");
        images.add("images/battleBackgrounds/fieldBackground5.png");

        images.add("images/battleBackgrounds/desertBackground.png");
        images.add("images/battleBackgrounds/desertBackground2.png");

        images.add("images/battleBackgrounds/cityBackground.png");
        images.add("images/battleBackgrounds/cityBackground2.png");

        images.add("images/battleBackgrounds/beachBackground.png");
        images.add("images/battleBackgrounds/beachBackground2.png");

        images.add("images/battleBackgrounds/arenaBackground.png");
        images.add("images/battleBackgrounds/arenaBackground2.png");
        

        images.add("images/battleBackgrounds/snowyBackground.png");
        images.add("images/battleBackgrounds/snowyBackground2.png");

        images.add("images/battleBackgrounds/woodsBackground.png");
        
        images.add("images/battleBackgrounds/cavesBackground.png");

        images.add("images/battleBackgrounds/flowerBackground.png");
        images.add("images/battleBackgrounds/mountainsBackground.png");
       
        

        int randomNumber = rng.nextInt(images.size());
        String image = images.get(randomNumber);
        this.setBackground(image);
    }

}
