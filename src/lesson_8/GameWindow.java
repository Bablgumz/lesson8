package lesson_8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_X = 600;
    static final int WINDOW_Y = 400;
    static final int WINDOW_WIDHT = 505;
    static final int WINDOW_HEIGHT = 555;

    public GameWindow() {
        setBounds(WINDOW_X,WINDOW_Y, WINDOW_WIDHT, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton btnStartNewGame = new JButton("StartNewGame");
        panel.add(btnStartNewGame);
        JButton btnExit = new JButton("Exit");
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);

        btnExit.addActionListener(e ->{
            System.exit(0);
        });

        setVisible(true);
    }
}
