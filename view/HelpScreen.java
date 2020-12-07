package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class HelpScreen extends JPanel {

    JButton back;
    private int fontSize = 30;
    private int WIDTH = 800;
    private int HEIGHT = 600;

    HelpScreen() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.decode("#FFDE00"));

        back = new JButton("Back");
        back.setFont(new Font(back.getName(), Font.PLAIN, fontSize + 10));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.RED);
        back.setFocusable(false);
        back.setOpaque(true);
        back.setBorderPainted(false);
        int backHeight = HEIGHT / 6;
        back.setBounds(280, (int) (HEIGHT / 1.23) - backHeight / 2 + 15, 220, backHeight);
        back.setVisible(true);

        JLabel helpBackground = new JLabel(new ImageIcon(getClass().getResource("images/HelpScreen.png")));
        helpBackground.setBounds(0, 0, 800, 600);


        this.add(helpBackground);
        this.add(back);

        this.repaint();
        this.setVisible(true);

    }

    public void setBackButtonListener(ActionListener l) {
        back.addActionListener(l);
    }

}
