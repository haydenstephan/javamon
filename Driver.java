import view.*;
import model.*;
import controller.*;
import java.awt.event.*;
import java.io.File;
import sounds.*;

public class Driver {
    public static void main(String[] args) {
        GameWindow gameGUI = new GameWindow();

        boolean playMusic = true;

        if(playMusic)
        SoundPlayer.startMusic();

        Controller controller = new Controller(gameGUI);

        try {
            if (args.length == 1 && args[0].equals("newGame")) {
                gameGUI.setScoreBoard(new ScoreBoard(0, 0));
            } else {
                File tempFile = new File("scores.dat");
                boolean exists = tempFile.exists();
                if (exists) {
                    gameGUI.setScoreBoard(ScoreBoard.loadFromFile("scores.dat"));
                } else {
                    gameGUI.setScoreBoard(new ScoreBoard(0, 0));
                }
            }
        } catch (Exception e) {
            gameGUI.setScoreBoard(new ScoreBoard(0, 0));
        }

        gameGUI.updateStartScreen();

        //----------------start screen buttons----------------//
        gameGUI.setStartButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onStartGame();
            }
        });

        gameGUI.viewHelpButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onViewHelp();
            }
        });

        gameGUI.setCharizardButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onPlayerSelectsJavamon(JavamonFactory.makeCharizard(true));
            }
        });

        gameGUI.setMagikarpButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onPlayerSelectsJavamon(JavamonFactory.makeMagikarp(true));
            }
        });
        
        //----------------help screen button----------------//
        gameGUI.setBackButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onBack();
            }
        });

        //----------------select screen buttons----------------//
        gameGUI.setBulbasuarButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onPlayerSelectsJavamon(JavamonFactory.makeBulbasaur(true));
            }
        });

        gameGUI.setPikachuButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onPlayerSelectsJavamon(JavamonFactory.makePikachu(true));
            }
        });

        gameGUI.setCharmanderButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onPlayerSelectsJavamon(JavamonFactory.makeCharmander(true));
            }
        });

        gameGUI.setSquirtleButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onPlayerSelectsJavamon(JavamonFactory.makeSquirtle(true));
            }
        });
        
        //----------------battle screen buttons----------------//
        gameGUI.setMove1ButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onMoveSelected(controller.getPlayerJavamon().getMove1());
            }
        });

        gameGUI.setMove2ButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onMoveSelected(controller.getPlayerJavamon().getMove2());
            }
        });

        gameGUI.setMove3ButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onMoveSelected(controller.getPlayerJavamon().getMove3());
            }
        });

        gameGUI.setMove4ButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onMoveSelected(controller.getPlayerJavamon().getMove4());
            }
        });

        gameGUI.setNextButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onNextButton();
            }
        });


        //window adapter updates scoreboard when window is closed
        JavamonWindowAdapter windowAdapter = new JavamonWindowAdapter(gameGUI.getScoreBoard(), "scores.dat");
        gameGUI.addOnCloseListener(windowAdapter);

    }
}
