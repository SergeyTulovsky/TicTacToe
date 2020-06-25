package tictactoe20200618;

import tictactoe20200618.controller.GameController;
import tictactoe20200618.model.Game;
import tictactoe20200618.view.GameWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameWindow gameWindow = new GameWindow();
                GameController gameController = new GameController(gameWindow);
                gameWindow.init();
            }
        });

        Game game = new Game();
        game.start();
    }
}
