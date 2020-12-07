package controller;
import javax.swing.JPanel;
import model.*;

public interface UserInterface 
{
    public void setScoreBoard(ScoreBoard board);

    public ScoreBoard getScoreBoard();

    public void setToStartScreen();

    public void setToViewHelpScreen();

    public void setToSelectScreen();

    public void setToBattleScreen(Javamon player, Javamon computer);

    public void showBattleResults(boolean playerGoesFirst, String battleText, int playerColorChoice, int rivalColorChoice);
   
    public void showWaitingForAction();

    public void showWhoWon(boolean playerWins);

    public void updateStartScreen();
}
