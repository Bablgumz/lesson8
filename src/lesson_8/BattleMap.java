package lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    static final int MODE_H_VS_AI = 0;
    static final int MODE_H_VS_H = 1;

    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;


    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.gameFinished) {
                    Logic.humanTurn(cellX, cellY);

                }
                repaint();
            }
        });
    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;
        repaint();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        cellHeight = getHeight() / fieldSize;
        cellWidth = getWidth() / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j] == Logic.DOT_X){
                    drawX(g, j, i);
                }

                for (int k = 0; k < Logic.SIZE; k++) {
                    for (int l = 0; l < Logic.SIZE; l++) {
                        if (Logic.map[i][j] == Logic.DOT_X){
                            draw0(g, k, l);
                        }

                    }

                }
            }
        }
    }

    private void drawX(Graphics g, int j, int i) {
        ((Graphics2D) g).setStroke(new BasicStroke(0));
        g.setColor(Color.CYAN);
        g.drawLine(j * cellWidth, i * cellHeight,
                (j + 1 ) * cellWidth, (i + 1) * cellHeight);
    }

    private void draw0(Graphics g, int k, int l) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.MAGENTA);
        g.drawLine(k * cellWidth, l * cellHeight,
                (k + 1) * cellWidth, (l + 1) * cellHeight);
    }
}


