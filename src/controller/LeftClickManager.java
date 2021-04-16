package controller;

import model.SquareManager;
import view.WindowGame;

public class LeftClickManager {
    private SquareManager squareManager;

    public void setSquareManager(SquareManager squareManager) {
        this.squareManager = squareManager;
    }

    public void clickOnCoordinates(int x, int y)
    {
        int letter = (x * 8) / WindowGame.WINDOW_SIZE;
        int number = (y * 8) / WindowGame.WINDOW_SIZE;

        squareManager.leftClickOnSquare(letter, number);
    }
}
