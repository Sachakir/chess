package model;

import view.FrontWindow;

import java.util.LinkedList;
import java.util.List;

public class ChessBoardManager {
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
            Square square = new Square(letter, number);
            if (position.isWhiteMove())
            {
                if (position.getPiece(square).isWhite && position.getPiece(square).type != PieceType.EMPTY)
                {
                    selectedSquare = new Square(letter, number);

                    ChessRules chessRules = new ChessRules(position, selectedSquare);
                    possibleMoves = chessRules.possiblePawnMoves();

                    frontWindow.setSelected(selectedSquare);
                    frontWindow.setPossibleMoves(possibleMoves);
                }
            }
            else
            {
                if (false == position.getPiece(square).isWhite)
                {
                    selectedSquare = new Square(letter, number);

                    ChessRules chessRules = new ChessRules(position, selectedSquare);
                    possibleMoves = chessRules.possiblePawnMoves();

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
                Square dest = new Square(letter, number);
                frontWindow.makeMove(selectedSquare, dest);
                position.setWhiteMove(!position.isWhiteMove());

                PieceEntity destPieceType = position.getPiece(selectedSquare);
                position.setSquare(dest.number, dest.letter, destPieceType);
                position.setSquare(selectedSquare.number, selectedSquare.letter, new PieceEntity());
            }
            selectedSquare = null;
        }
    }

    public void rightClick()
    {
        selectedSquare = null;
        possibleMoves.clear();
        frontWindow.setSelected(null);
        frontWindow.setPossibleMoves(possibleMoves);
    }
}
