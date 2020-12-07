package view;

import javax.swing.*;
import java.awt.*;
import model.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class StartScreen extends JPanel {
    private int WIDTH = 800;
    private int HEIGHT = 600;
    private int fontSize = 30;

    private int winCount;
    private int loseCount;

    JButton startButton;
    JLabel wins;
    JLabel losses;
    JButton help;
    JButton charizard;
    JButton magikarp;

    public StartScreen() {       

        winCount = 0;
        loseCount = 0;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.decode("#FFDE00"));

        startButton = new JButton("Start Game");
        startButton.setFont(new Font(startButton.getName(), Font.ROMAN_BASELINE, fontSize + 10));
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(Color.RED);
        startButton.setFocusable(false);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);
        int startButtonWidth = WIDTH / 3;
        int startButtonHeight = HEIGHT / 6;
        startButton.setBounds(WIDTH / 2 + startButtonWidth / 3, (int) (HEIGHT / 1.23) - startButtonHeight / 2 + 15,
                startButtonWidth, startButtonHeight);

        help = new JButton("Rules");
        help.setFont(new Font(help.getName(), Font.PLAIN, fontSize + 10));
        help.setForeground(Color.WHITE);
        help.setBackground(Color.RED);
        help.setFocusable(false);
        help.setOpaque(true);
        help.setBorderPainted(false);
        int helpButtonHeight = HEIGHT / 6;
        help.setBounds(250, (int) (HEIGHT / 1.23) - helpButtonHeight / 2 + 15, 215, helpButtonHeight);

        charizard = new JButton("");
        int charizardButtonHeight = HEIGHT/3;
        int charizardButtonWidth = WIDTH/5; 
        charizard.setBounds( (int) (WIDTH * 70 / 100), (HEIGHT - charizardButtonHeight)/2, 
            charizardButtonWidth, charizardButtonHeight);
        charizard.setOpaque(false);
        charizard.setContentAreaFilled(false);
        charizard.setBorderPainted(false);


        magikarp = new JButton("");
        int magikarpButtonHeight = HEIGHT/5;
        int magikarpButtonWidth = WIDTH/2 + 50;
        magikarp.setBounds( WIDTH/10,HEIGHT/2,magikarpButtonWidth,magikarpButtonHeight);
        magikarp.setOpaque(false);
        magikarp.setContentAreaFilled(false);
        magikarp.setBorderPainted(false);

        JLabel stats = new JLabel("Score Board");
        stats.setFont(new Font(stats.getName(), Font.BOLD, fontSize));
        stats.setBounds(10, HEIGHT - (6 * fontSize) + 25, 300, fontSize + 5);

        wins = new JLabel("Wins: " + String.valueOf(winCount));
        wins.setFont(new Font(wins.getName(), Font.PLAIN, fontSize - 2));
        wins.setBounds(10, HEIGHT - 4 * fontSize + 15, 300, fontSize);

        losses = new JLabel("Losses: " + String.valueOf(loseCount));
        losses.setFont(new Font(losses.getName(), Font.PLAIN, fontSize - 2));
        losses.setBounds(10, HEIGHT - 2 * fontSize - 25 + 15, 300, fontSize);
 
        JLabel startBackground = new JLabel(new ImageIcon(getClass().getResource("images/StartBackground.png")));
        startBackground.setBounds(0, 0, 800, 600);

        this.add(startButton);
        this.add(help);
        this.add(charizard);
        this.add(magikarp);

        this.add(stats);
        this.add(wins);
        this.add(losses);
        this.add(startBackground);

    }

    public void updateScoreBoard(ScoreBoard board) {
        String w = "0";
        String l = "0";

        if (board != null) {
            w = board.getWins();
            l = board.getLosses();
        }

        wins.setText("Wins: " + w);
        losses.setText("Losses: " + l);
    }

    public void setStartButtonListener(ActionListener l) {
        startButton.addActionListener(l);
    }

    public void setViewHelpListener(ActionListener l) {
        help.addActionListener(l);
    }

    public void setCharizardButtonListener(ActionListener l) {
        charizard.addActionListener(l);
    }

    public void setMagikarpButtonListener(ActionListener l) {
        magikarp.addActionListener(l);
    }
}
