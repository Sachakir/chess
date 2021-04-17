package view;

import controller.ClickManager;
import model.PieceEntity;
import model.Position;
import model.PieceType;
import model.Square;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class WindowGame extends BasicGame {
    public static final int WINDOW_SIZE = 640;

    private ImageLoader imageLoader;
    private GameContainer container;
    private Position position = new Position();
    private Square selectedSquare = null;
    private List<Square> possiblesMoves = new ArrayList<Square>();

    private ClickManager clickManager;

    public WindowGame() { super("Chess game"); }

    public void setController(ClickManager clickManager)
    {
        this.clickManager = clickManager;
    }

    public void makeMove(Square from, Square to) {
        PieceEntity destPieceType = position.getPiece(from);
        position.setSquare(to.number, to.letter, destPieceType);
        position.setSquare(from.number, from.letter, new PieceEntity());
    }

    public void setPossiblesMoves(List<Square> possiblesMoves) { this.possiblesMoves = possiblesMoves; }

    public void setSelectedSquare(Square selectedSquare) {
        this.selectedSquare = selectedSquare;
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        this.container = container;
        container.setShowFPS(false);
        imageLoader = new ImageLoader();
    }

    @Override
    public void render(GameContainer container, Graphics g) {
        g.drawImage(imageLoader.getBoard(),0, 0);
        if (selectedSquare != null)
        {
            g.drawImage(imageLoader.getSelected(), selectedSquare.letter * WINDOW_SIZE/8, selectedSquare.number * WINDOW_SIZE/8);
        }
        drawPieces(g);
        for (Square s : possiblesMoves)
        {
            g.drawImage(imageLoader.getSelected(), s.letter * WINDOW_SIZE/8, s.number * WINDOW_SIZE/8);
        }
    }

    @Override
    public void update(GameContainer container, int delta) {}

    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        if (button == 0)
        {
            clickManager.leftClickOnCoordinates(x, y);
        }
        if (button == 1)
        {
            clickManager.rightClickOnCoordinates();
        }
    }

    private void drawPieces(Graphics g)
    {
        for (int line = 0; line < Position.BOARD_SIZE; line++)
        {
            for (int column = 0; column < Position.BOARD_SIZE; column++)
            {
                Square square = new Square(column, line);
                if (position.getPiece(square).type == PieceType.ROOK &&
                        position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getwRook(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.KNIGHT &&
                        position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getwKnight(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.BISHOP &&
                        position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getwBishop(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.KING &&
                        position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getwKing(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.QUEEN &&
                        position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getwQueen(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.PAWN &&
                        position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getwPawn(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.ROOK &&
                        !position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getbRook(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.KNIGHT &&
                        !position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getbKnight(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.BISHOP &&
                        !position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getbBishop(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.KING &&
                        !position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getbKing(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.QUEEN &&
                        !position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getbQueen(), column * 80, line * 80);
                }
                if (position.getPiece(square).type == PieceType.PAWN &&
                        !position.getPiece(square).isWhite)
                {
                    g.drawImage(imageLoader.getbPawn(), column * 80, line * 80);
                }
            }
        }
    }
}