package lesson_8;

import javax.swing.*;
import java.awt.*;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    static final int MODE_H_VS_AI = 0;
    static final int MODE_H_VS_H = 0;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.BLUE);
    }
}
