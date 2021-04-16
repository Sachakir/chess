package model;

import java.util.Arrays;

public class Position {
    public static final int BOARD_SIZE = 8;
    private boolean whiteMove = true;

    private Piece[][] board;

    public Position() {
        board = new Piece[BOARD_SIZE][BOARD_SIZE];

        board[0][0] = Piece.B_ROOK;
        board[0][1] = Piece.B_KNIGHT;
        board[0][2] = Piece.B_BISHOP;
        board[0][3] = Piece.B_QUEEN;
        board[0][4] = Piece.B_KING;
        board[0][5] = Piece.B_BISHOP;
        board[0][6] = Piece.B_KNIGHT;
        board[0][7] = Piece.B_ROOK;

        board[7][0] = Piece.W_ROOK;
        board[7][1] = Piece.W_KNIGHT;
        board[7][2] = Piece.W_BISHOP;
        board[7][3] = Piece.W_QUEEN;
        board[7][4] = Piece.W_KING;
        board[7][5] = Piece.W_BISHOP;
        board[7][6] = Piece.W_KNIGHT;
        board[7][7] = Piece.W_ROOK;

        for (int column = 0; column < BOARD_SIZE; column++)
        {
            board[1][column] = Piece.B_PAWN;
            board[6][column] = Piece.W_PAWN;
            board[2][column] = Piece.EMPTY;
            board[3][column] = Piece.EMPTY;
            board[4][column] = Piece.EMPTY;
            board[5][column] = Piece.EMPTY;
        }
    }

    public void print()
    {
        for (int line = 0; line < BOARD_SIZE; line++)
        {
            for (int column = 0; column < BOARD_SIZE; column++)
            {
                System.out.print(board[line][column] + " ");
            }
            System.out.print("\n");
        }
    }
    public Piece getSquare(int line, int column)
    {
        return board[line][column];
    }

    public void setSquare(int line, int column, Piece square)
    {
        board[line][column] = square;
    }

    public boolean isWhiteMove() {
        return whiteMove;
    }

    public void setWhiteMove(boolean whiteMove) {
        this.whiteMove = whiteMove;
    }
}
