package model;

import java.util.LinkedList;
import java.util.List;

public class ChessRules {
    private Position position;
    private Square selected;

    public ChessRules(Position position, Square selected)
    {
        this.position = position;
        this.selected = selected;
    }

    boolean isInCheck()
    {
        // TODO
        return false;
    }

    public List<Square> possiblePawnMoves()
    {
        List<Square> moves = new LinkedList<Square>();
        if (position.getPiece(selected).type != PieceType.PAWN)
        {
            return moves;
        }

        int whiteSense = 1;
        if (!position.isWhiteMove())
        {
            whiteSense = -1;
        }

        Square potentialSquare1 = new Square(selected.letter-1,selected.number-1*whiteSense);
        if (potentialSquare1.insideBoard() && !position.getPiece(potentialSquare1).isWhite &&
                position.getPiece(potentialSquare1).type != PieceType.EMPTY)
        {
            moves.add(potentialSquare1);
        }
        Square potentialSquare2 = new Square(selected.letter+1,selected.number-1*whiteSense);
        if (potentialSquare2.insideBoard() && !position.getPiece(potentialSquare2).isWhite &&
                position.getPiece(potentialSquare2).type != PieceType.EMPTY)
        {
            moves.add(potentialSquare2);
        }
        Square potentialSquare3 = new Square(selected.letter, selected.number-1*whiteSense);
        if (potentialSquare3.insideBoard() && position.getPiece(potentialSquare3).type == PieceType.EMPTY)
        {
            moves.add(potentialSquare3);
        }
        Square potentialSquare4 = new Square(selected.letter, selected.number - 2*whiteSense);
        int startingLine = 1;
        if (position.isWhiteMove())
        {
            startingLine = 6;
        }
        if (potentialSquare4.insideBoard() && selected.number == startingLine && position.getPiece(potentialSquare4).type == PieceType.EMPTY)
        {
            moves.add(potentialSquare4);
        }

        // check for legal moves TODO


        return moves;
    }
}
