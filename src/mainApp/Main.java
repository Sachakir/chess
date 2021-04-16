package mainApp;

import controller.LeftClickManager;
import controller.RightClickManager;
import model.Position;
import model.SquareManager;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import view.FrontWindow;
import view.WindowGame;

public class Main {
    public static void main(String[] args) throws SlickException {
        LeftClickManager leftClickManager = new LeftClickManager();
        RightClickManager rightClickManager = new RightClickManager();
        FrontWindow frontWindow = new FrontWindow();
        SquareManager squareManager = new SquareManager();

        frontWindow.setController(leftClickManager);
        frontWindow.setController(rightClickManager);
        leftClickManager.setSquareManager(squareManager);
        rightClickManager.setSquareManager(squareManager);
        squareManager.setWindowGame(frontWindow);

        frontWindow.start();

    }
}
