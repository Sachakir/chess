package view;

import controller.ClickManager;
import model.Square;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import java.util.List;

public class FrontWindow {
    private WindowGame windowGame = null;
    private AppGameContainer agc;

    public FrontWindow() throws SlickException {
        windowGame = new WindowGame();
        agc = new AppGameContainer(windowGame, WindowGame.WINDOW_SIZE, WindowGame.WINDOW_SIZE, false);
        agc.setTargetFrameRate(30);
    }

    public void start() throws SlickException { agc.start(); }

    public void setSelected(Square selectedSquare)
    {
        windowGame.setSelectedSquare(selectedSquare);
    }

    public void makeMove(Square from, Square to) { windowGame.makeMove(from, to); }

    public void setPossibleMoves(List<Square> possibleMoves) { windowGame.setPossiblesMoves(possibleMoves); }

    public void setController(ClickManager clickManager) { windowGame.setController(clickManager); }

}
