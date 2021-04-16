package view;

import controller.LeftClickManager;
import controller.RightClickManager;
import model.Position;
import model.Square;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class FrontWindow {
    private Position position = new Position();
    private WindowGame windowGame = null;
    private  AppGameContainer agc;

    public FrontWindow() throws SlickException {
        windowGame = new WindowGame(position);
        agc = new AppGameContainer(windowGame, WindowGame.WINDOW_SIZE, WindowGame.WINDOW_SIZE, false);
        agc.setTargetFrameRate(30);
    }

    public void start() throws SlickException {
        agc.start();
    }

    public void setSelected(Square selectedSquare)
    {
        windowGame.setSelectedSquare(selectedSquare);
    }

    public void setPossibleMoves(ArrayList<Square> possibleMoves)
    {
        windowGame.setPossiblesMoves(possibleMoves);
    }

    public void setController(LeftClickManager leftClickManager) {
        windowGame.setController(leftClickManager);
    }
    public void setController(RightClickManager rightClickManager) {
        windowGame.setController(rightClickManager);
    }

}
