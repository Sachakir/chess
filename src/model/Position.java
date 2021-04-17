package model;

public class Position {
    public static final int BOARD_SIZE = 8;
    private boolean whiteMove = true;

    private PieceEntity[][] board;

    public Position() {
        board = new PieceEntity[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0;i < BOARD_SIZE; i++)
        {
            for (int j = 0; j < BOARD_SIZE; j++)
            {
                board[i][j] = new PieceEntity();
            }
        }

        board[0][0].type = PieceType.ROOK;
        board[0][0].isWhite = false;
        board[0][1].type = PieceType.KNIGHT;
        board[0][1].isWhite = false;
        board[0][2].type = PieceType.BISHOP;
        board[0][2].isWhite = false;
        board[0][3].type = PieceType.QUEEN;
        board[0][3].isWhite = false;
        board[0][4].type = PieceType.KING;
        board[0][4].isWhite = false;
        board[0][5].type = PieceType.BISHOP;
        board[0][5].isWhite = false;
        board[0][6].type = PieceType.KNIGHT;
        board[0][6].isWhite = false;
        board[0][7].type = PieceType.ROOK;
        board[0][7].isWhite = false;

        board[7][0].type = PieceType.ROOK;
        board[7][1].type = PieceType.KNIGHT;
        board[7][2].type = PieceType.BISHOP;
        board[7][3].type = PieceType.QUEEN;
        board[7][4].type = PieceType.KING;
        board[7][5].type = PieceType.BISHOP;
        board[7][6].type = PieceType.KNIGHT;
        board[7][7].type = PieceType.ROOK;

        for (int column = 0; column < BOARD_SIZE; column++)
        {
            board[1][column].type = PieceType.PAWN;
            board[1][column].isWhite = false;
            board[6][column].type = PieceType.PAWN;
            board[2][column].type = PieceType.EMPTY;
            board[3][column].type = PieceType.EMPTY;
            board[4][column].type = PieceType.EMPTY;
            board[5][column].type = PieceType.EMPTY;
        }
    }

    public PieceEntity getPiece(Square square)
    {
        return board[square.number][square.letter];
    }

    public void setSquare(int line, int column, PieceEntity square)
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
