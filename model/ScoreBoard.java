package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

@SuppressWarnings("serial")
public class ScoreBoard implements java.io.Serializable {
    int wins;
    int losses;

    public ScoreBoard(int wins, int losses) {
        this.wins = wins;
        this.losses = losses;
    }

    public String getWins() {
        return String.valueOf(wins);
    }

    public String getLosses() {
        return String.valueOf(losses);
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    
    public static ScoreBoard loadFromFile(String fileName) {
        ScoreBoard board = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            board = (ScoreBoard) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Error reading from file");
            System.out.println(e.getMessage());
        }
        // the readObject method of ObjectInputStream may throw
        // ClassNotFoundException
        catch (ClassNotFoundException e) {
            System.out.println("Error loading scoreboard");
            System.out.println(e.getMessage());
        }
        return board;
    }



}
