package view;

import java.awt.event.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import model.*;

public class JavamonWindowAdapter extends WindowAdapter {

    String fileName;

    ScoreBoard board;// win,loss

    public JavamonWindowAdapter(ScoreBoard board, String fileName) {

        this.board = board;
        this.fileName = fileName;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.board);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
