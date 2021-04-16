package model;

import view.FrontWindow;
import view.WindowGame;

import java.util.ArrayList;

public class SquareManager {
    private Position position;

    public void setWindowGame(FrontWindow frontWindow)
    {
        this.frontWindow = frontWindow;
    }
    private FrontWindow frontWindow;

    public void leftClickOnSquare(int letter, int number)
    {
        Square square = new Square();
        square.letter = letter;
        square.number = number;
        frontWindow.setSelected(square);
        ArrayList<Square> possibleMoves = new ArrayList<>();
        int nextNumber = number + 1;
        int moves = 0;
        while (nextNumber < 8 && moves < 2)
        {
            Square squareNext = new Square();
            squareNext.letter = letter;
            squareNext.number = nextNumber;
            possibleMoves.add(squareNext);
            nextNumber++;
            moves++;
        }
        frontWindow.setPossibleMoves(possibleMoves);
    }

    public void rightClickOnSquare()
    {
        frontWindow.setSelected(null);
        frontWindow.setPossibleMoves(new ArrayList<Square>());
    }
}
