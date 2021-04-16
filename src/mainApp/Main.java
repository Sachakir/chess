package mainApp;

import controller.ClickManager;
import model.ChessBoardManager;
import org.newdawn.slick.SlickException;
import view.FrontWindow;

public class Main {
    public static void main(String[] args) throws SlickException {
        ClickManager clickManager = new ClickManager();
        FrontWindow frontWindow = new FrontWindow();
        ChessBoardManager chessBoardManager = new ChessBoardManager();

        frontWindow.setController(clickManager);
        clickManager.setSquareManager(chessBoardManager);
        chessBoardManager.setWindowGame(frontWindow);

        frontWindow.start();

    }
}
