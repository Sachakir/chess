package model;

import view.FrontWindow;

import java.util.LinkedList;
import java.util.List;

public class SquareManager {
    private Position position = new Position();
    private Square selectedSquare = null;
    private List<Square> possibleMoves = new LinkedList<Square>();

    private FrontWindow frontWindow;

    public void setWindowGame(FrontWindow frontWindow)
    {
        this.frontWindow = frontWindow;
    }

    public void leftClickOnSquare(int letter, int number)
    {
        if (null == selectedSquare)
        {
            if (position.isWhiteMove())
            {
                if (position.getSquare(number, letter) == Piece.W_PAWN ||
                        position.getSquare(number, letter) == Piece.W_ROOK ||
                        position.getSquare(number, letter) == Piece.W_KNIGHT ||
                        position.getSquare(number, letter) == Piece.W_BISHOP ||
                        position.getSquare(number, letter) == Piece.W_QUEEN ||
                        position.getSquare(number, letter) == Piece.W_KING)
                {
                    selectedSquare = new Square();
                    selectedSquare.letter = letter;
                    selectedSquare.number = number;

                    int nextNumber = number - 1;
                    int moves = 0;
                    while (nextNumber >= 0 && moves < 2) {
                        Square squareNext = new Square();
                        squareNext.letter = letter;
                        squareNext.number = nextNumber;
                        possibleMoves.add(squareNext);
                        nextNumber--;
                        moves++;
                    }

                    frontWindow.setSelected(selectedSquare);
                    frontWindow.setPossibleMoves(possibleMoves);
                }
            }
            else
            {
                if (position.getSquare(number, letter) == Piece.B_PAWN ||
                        position.getSquare(number, letter) == Piece.B_ROOK ||
                        position.getSquare(number, letter) == Piece.B_KNIGHT ||
                        position.getSquare(number, letter) == Piece.B_BISHOP ||
                        position.getSquare(number, letter) == Piece.B_QUEEN ||
                        position.getSquare(number, letter) == Piece.B_KING)
                {
                    selectedSquare = new Square();
                    selectedSquare.letter = letter;
                    selectedSquare.number = number;

                    int nextNumber = number + 1;
                    int moves = 0;
                    while (nextNumber >= 0 && moves < 2) {
                        Square squareNext = new Square();
                        squareNext.letter = letter;
                        squareNext.number = nextNumber;
                        possibleMoves.add(squareNext);
                        nextNumber++;
                        moves++;
                    }

                    frontWindow.setSelected(selectedSquare);
                    frontWindow.setPossibleMoves(possibleMoves);
                }
            }
        }
        else
        {
            boolean makeMove = false;
            for (Square square : possibleMoves)
            {
                if (square.letter == letter && square.number == number)
                {
                    makeMove = true;
                    break;
                }
            }

            possibleMoves.clear();
            frontWindow.setSelected(null);
            frontWindow.setPossibleMoves(possibleMoves);
            if (true == makeMove)
            {
                Square dest = new Square();
                dest.number = number;
                dest.letter = letter;
                frontWindow.makeMove(selectedSquare, dest);
                position.setWhiteMove(!position.isWhiteMove());

                Piece destPiece = position.getSquare(selectedSquare.number, selectedSquare.letter);
                position.setSquare(dest.number, dest.letter, destPiece);
                position.setSquare(selectedSquare.number, selectedSquare.letter, Piece.EMPTY);
            }
            selectedSquare = null;
        }
    }

    public void rightClickOnSquare()
    {
        selectedSquare = null;
        possibleMoves.clear();
        frontWindow.setSelected(null);
        frontWindow.setPossibleMoves(possibleMoves);
    }
}
