package controller;

import model.SquareManager;

public class RightClickManager {
    private SquareManager squareManager;

    public void setSquareManager(SquareManager squareManager) {
        this.squareManager = squareManager;
    }

    public void clickOnCoordinates(int x, int y)
    {
        squareManager.rightClickOnSquare();
    }
}
