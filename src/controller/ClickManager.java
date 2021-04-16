package controller;

import model.ChessBoardManager;
import view.WindowGame;

public class ClickManager {
    private ChessBoardManager chessBoardManager;

    public void setSquareManager(ChessBoardManager chessBoardManager) {
        this.chessBoardManager = chessBoardManager;
    }

    public void leftClickOnCoordinates(int x, int y)
    {
        int letter = (x * 8) / WindowGame.WINDOW_SIZE;
        int number = (y * 8) / WindowGame.WINDOW_SIZE;

        chessBoardManager.leftClickOnSquare(letter, number);
    }

    public void rightClickOnCoordinates() { chessBoardManager.rightClick(); }
}
