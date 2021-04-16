package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader {
    private Image board;
    private Image wRook;
    private Image wKnight;
    private Image wBishop;
    private Image wKing;
    private Image wQueen;
    private Image wPawn;
    private Image bRook;
    private Image bKnight;
    private Image bBishop;
    private Image bKing;
    private Image bQueen;
    private Image bPawn;
    private Image point;
    private Image selected;

    public ImageLoader() throws SlickException { init(); }

    public Image getBoard() { return board; }

    public Image getwRook() {
        return wRook;
    }

    public Image getwKnight() {
        return wKnight;
    }

    public Image getwBishop() {
        return wBishop;
    }

    public Image getwKing() {
        return wKing;
    }

    public Image getwQueen() {
        return wQueen;
    }

    public Image getwPawn() {
        return wPawn;
    }

    public Image getbRook() {
        return bRook;
    }

    public Image getbKnight() {
        return bKnight;
    }

    public Image getbBishop() {
        return bBishop;
    }

    public Image getbKing() {
        return bKing;
    }

    public Image getbQueen() {
        return bQueen;
    }

    public Image getbPawn() {
        return bPawn;
    }

    public Image getPoint() {
        return point;
    }

    public Image getSelected() {
        return selected;
    }

    private void init() throws SlickException {
        board = new Image("images/board.png");
        wRook = new Image("images/TourB.bmp" , new Color(195,195,195));
        wKnight = new Image("images/CavalierB.bmp" , new Color(195,195,195));
        wBishop = new Image("images/FouB.bmp" , new Color(195,195,195));
        wKing = new Image("images/RoiB.bmp" , new Color(195,195,195));
        wQueen = new Image("images/DameB.bmp" , new Color(195,195,195));
        wPawn = new Image("images/PionB.bmp" , new Color(195,195,195));
        bRook = new Image("images/TourN.bmp" , new Color(195,195,195));
        bKnight = new Image("images/CavalierN.bmp" , new Color(195,195,195));
        bBishop = new Image("images/FouN.bmp" , new Color(195,195,195));
        bKing = new Image("images/RoiN.bmp" , new Color(195,195,195));
        bQueen = new Image("images/DameN.bmp" , new Color(195,195,195));
        bPawn = new Image("images/PionN.bmp" , new Color(195,195,195));
        point = new Image("images/PointVert.bmp" , new Color(195,195,195));
        selected = new Image("images/selected.bmp" , new Color(195,195,195));
    }
}
