package view;
import javax.swing.*;
import controller.UserInterface;
import model.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameWindow implements UserInterface {
    JFrame frame;
    StartScreen startScreen;
    SelectScreen selectScreen;
    BattleScreen battleScreen;
    HelpScreen help;
    JPanel currentScene;
    private ScoreBoard board;

    public GameWindow() {
        frame = new JFrame("Javamon");
        frame.setPreferredSize(new Dimension(800, 630));

        startScreen = new StartScreen();
        selectScreen = new SelectScreen();
        battleScreen = new BattleScreen();
        help = new HelpScreen();

        currentScene = startScreen;
        setToStartScreen();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        board = new ScoreBoard(0, 0);

    }

    public void setScoreBoard(ScoreBoard board) {
        this.board = board;
    }

    public ScoreBoard getScoreBoard() {
        if (board == null) {
            board = new ScoreBoard(0, 0);
        }
        return board;
    }

    public void setToStartScreen() {
        setScene(startScreen);
    }

    public void setToViewHelpScreen() {
        setScene(help);
    }

    public void setToSelectScreen() {
        setScene(selectScreen);
    }

    public void setToBattleScreen(Javamon player, Javamon computer) {
        battleScreen.setUpNewGame(player, computer);
        setScene(battleScreen);
    }

    public void setScene(JPanel scene) {
        currentScene.setVisible(false);
        frame.add(scene);
        currentScene = scene;
        currentScene.setVisible(true);
        frame.pack();
        frame.setVisible(true);

    }

    public void setStartButtonListener(ActionListener l) {
        startScreen.setStartButtonListener(l);
    }

    public void viewHelpButtonListener(ActionListener l) {
        startScreen.setViewHelpListener(l);
    }

    public void setBackButtonListener(ActionListener l) {
        help.setBackButtonListener(l);
    }

    public void setPikachuButtonListener(ActionListener l) {
        selectScreen.setPikachuButtonListener(l);
    }

    public void setCharmanderButtonListener(ActionListener l) {
        selectScreen.setCharmanderButtonListener(l);
    }

    public void setBulbasuarButtonListener(ActionListener l) {
        selectScreen.setBulbasuarButtonListener(l);
    }

    public void setSquirtleButtonListener(ActionListener l) {
        selectScreen.setSquirtleButtonListener(l);
    }

    public void setCharizardButtonListener(ActionListener l) {
        startScreen.setCharizardButtonListener(l);
    }

    public void setMagikarpButtonListener(ActionListener l) {
        startScreen.setMagikarpButtonListener(l);
    }
    
    public void setMove1ButtonListener(ActionListener l) {
        battleScreen.setMove1ButtonListener(l);
    }

    public void setMove2ButtonListener(ActionListener l) {
        battleScreen.setMove2ButtonListener(l);
    }

    public void setMove3ButtonListener(ActionListener l) {
        battleScreen.setMove3ButtonListener(l);
    }

    public void setMove4ButtonListener(ActionListener l) {
        battleScreen.setMove4ButtonListener(l);
    }

    public void setNextButtonListener(ActionListener l) {
        battleScreen.setNextButtonListener(l);
    }

    public void showBattleResults(boolean playerGoesFirst, String battleText, int playerColorChoice, int rivalColorChoice) {
        battleScreen.showBattleResults(playerGoesFirst, battleText, playerColorChoice, rivalColorChoice);
    }

    public void showWaitingForAction() {
        battleScreen.showWaitingForAction();
    }

    public void showWhoWon(boolean playerWins) {
        battleScreen.showWhoWon(playerWins);
    }

    public void updateStartScreen() {
        startScreen.updateScoreBoard(this.board);
    }

    public void addOnCloseListener(JavamonWindowAdapter windowAdapter) {
        this.frame.addWindowListener(windowAdapter);
    }

}
