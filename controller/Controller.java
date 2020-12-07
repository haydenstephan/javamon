package controller;

import model.*;
import sounds.*;
import java.util.*;

public class Controller {

    UserInterface gui;
    Javamon player;
    Javamon rival;
    Random rng;

    String battleText;

    Move playerMove;
    Move rivalMove;

    boolean playerWins;
    boolean gameOver;
    boolean hasWaited;
    boolean doSecondAttack;
    boolean playerIsAttacker;

    public Controller(UserInterface gui) {
        this.gui = gui;
        rng = new Random();
    }

    public void onStartGame() {
        SoundPlayer.playSound("sounds/click.wav");
        gui.setToSelectScreen();
    }

    public void onViewHelp() {
        SoundPlayer.playSound("sounds/click.wav");
        gui.setToViewHelpScreen();
    }

    public void onBack() {
        SoundPlayer.playSound("sounds/click.wav");
        gui.setToStartScreen();
    }

    public void onPlayerSelectsJavamon(Javamon player) {
        SoundPlayer.playSound("sounds/click.wav");
        this.player = player;

        //play sound file if there is one
        if (player.getSoundFileName() != null)
        {
            SoundPlayer.playSound(player.getSoundFileName());
        }

        //choose a random javamon for the computer
        if (player.getJavamonName().equals("Magikarp"))
        {
            rival = JavamonFactory.makeMagikarp(false);
        }
        else
        {
            rival = JavamonFactory.makeRandomJavamon(false);
        }
        gui.setToBattleScreen(this.player, rival);

        //reset booleans
        gameOver = false;
        hasWaited = false;
        doSecondAttack = true;
    }

    public Javamon getPlayerJavamon() {
        return player;
    }

    

    public void onMoveSelected(Move playerMove) {
        SoundPlayer.playSound("sounds/click.wav");
        
        //set the player move
        this.playerMove = playerMove;

        //get a move for the computer
        this.rivalMove = Rules.chooseRivalMove(player, rival);

        //check who is faster
        boolean playerIsFaster = Rules.isJavamonFaster(player, rival);

        //  one move will happen at first when user selects a move
        if (playerIsFaster && !gameOver)
        {
            playerIsAttacker = true;
            javamonDoesAMove(playerMove, player, rival);
        }
        else if (!playerIsFaster && !gameOver)
        {
            playerIsAttacker = false;
            javamonDoesAMove(rivalMove, rival, player);
        }
           
        //if either lose, set game over to true
        if (player.getCurrentHealth() <= 0 || rival.getCurrentHealth() <= 0)
            gameOver = true;
    }





    public void onNextButton() {
        SoundPlayer.playSound("sounds/click.wav");
        
        //game is over don't do another attack
        if (gameOver) {
            gui.showWhoWon(playerWins);
            
            if (!hasWaited) 
            {
                hasWaited = true;
                if (playerWins) {
                    SoundPlayer.playSound("sounds/win.wav");
                } else {
                    SoundPlayer.playSound("sounds/lose.wav");
                }
            } 

            //wait one time before going back to main screen
            else {
                finishBattle();
            }
        }

        //next button should do the next attack      
         else if (doSecondAttack) {
            boolean playerIsFaster = Rules.isJavamonFaster(player, rival);

            if (!playerIsFaster && !gameOver)
            {
                playerIsAttacker = true;
                javamonDoesAMove(playerMove, player, rival);
            }
                
            else if (playerIsFaster && !gameOver)
            {
                playerIsAttacker = false;
                javamonDoesAMove(rivalMove, rival, player);
            }
            

            if (player.getCurrentHealth() <= 0 || rival.getCurrentHealth() <= 0)
                gameOver = true;
            
            System.out.println();
            doSecondAttack = false; //we don't want to do another move when we hit next
        }

        //we have done our second move and we want next button to show waiting results
        else {
            gui.showWaitingForAction();
            doSecondAttack = true;
        }
    }




    private void javamonDoesAMove(Move move, Javamon attacker, Javamon target) {
        int attackerColor = 0;
        int targetColor = 0;
        int playerColor;
        int rivalColor;
        
        //-----ATTACKER IS PARALYZED-----//
        if(attacker.isParalyzed())
        {
            SoundPlayer.playSound("sounds/paralyzed.wav");
            battleText = attacker.getJavamonName() + " tried to use " + move.getName() + " but is paralyzed";
            attacker.changeParalyzeTurns(-1);
        }

        //-----ATTACK PASSED-----//
        else if (Rules.didMovePass(attacker, move)) {
            SoundPlayer.playSound(move.getSoundFileName());
            int damageDone = Rules.calculateDamageDone(move, attacker, target);
            
            //pick colors for health icons
            if(damageDone > 0 || (move.hasEffect() && move.getEffect().isBadForDefender()))
            {
                targetColor = 1;
            }
            if(move.hasEffect() && move.getEffect().isGoodForAttacker())
            {
                attackerColor = 2;
            }

            //-----DO DAMAGE-----//
            target.changeHealth(-damageDone);

            //-----APPLY EFFECT-----//
            Rules.applyEffect(move, attacker, target);

            //-----GET BATTLE TEXT FOR DAMAGE MOVE-----//
            if (!move.hasEffect()) {
                battleText = attacker.getJavamonName() + " used " + move.getName() + " which did " + damageDone + " damage";
            } 
            
            //-----GET BATTLE TEXT FOR EFFECT MOVE-----//
            else {
                battleText = attacker.getJavamonName() + " used " + move.getName() + " "
                        + move.getEffect().getEffectDescription(Rules.getLeechDamage(attacker, target));
                if(damageDone > 0)
                {
                    battleText += " and did " + damageDone + " damage";
                }
                
            }

            //-----TARGET DIES-----//
            if (target.getCurrentHealth() <= 0) {
                if (attacker.getIsPlayer()) {
                    playerWins = true;
                } else {
                    playerWins = false;
                }

                gameOver = true;
            }
        }

        //-----MOVE MISSED-----//
        else {
            SoundPlayer.playSound("sounds/miss.wav");
            battleText = attacker.getJavamonName() + " missed " + move.getName();  
        }
       
        //prepare colors for battle screen
        if(attacker == player)
        {
            playerColor = attackerColor;
            rivalColor = targetColor;
        }
        else
        {
            playerColor = targetColor;
            rivalColor = attackerColor;
        }

        //unempower next move
        if(!(move.hasEffect() && move.getEffect() == Effect.empower))
        attacker.setIsEmpowered(false); 

        //display the results of the attack
        gui.showBattleResults(playerIsAttacker, battleText, playerColor, rivalColor);
        System.out.println(battleText);

    }







    //goes back to main menu
    private void finishBattle() {
        //increment win count
        if (playerWins) {
            gui.getScoreBoard().setWins(Integer.parseInt(gui.getScoreBoard().getWins()) + 1);
            System.out.println("player wins");
        }
        //increment lose count
        else {
            gui.getScoreBoard().setLosses(Integer.parseInt(gui.getScoreBoard().getLosses()) + 1);
            System.out.println("rival wins");
        }

        gui.updateStartScreen();
        gui.setToStartScreen();
    }

}
