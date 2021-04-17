package model;

public class PieceEntity {
    public PieceEntity()
    {
        isWhite = true;
        type = PieceType.EMPTY;
    }
    public boolean isWhite = true;
    public PieceType type = PieceType.EMPTY;
}
