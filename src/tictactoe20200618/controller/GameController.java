package tictactoe20200618.controller;

import tictactoe20200618.model.Computer;
import tictactoe20200618.model.Field;
import tictactoe20200618.model.Point;
import tictactoe20200618.model.User;
import tictactoe20200618.view.GameWindow;

public class GameController {
    private static GameWindow gameWindow;
    public static boolean gameOver = false;
    public static Field.Type winner;

    public GameController(GameWindow gameWindow1) {
        gameWindow = gameWindow1;
    }

    public GameController() {

    }

    public static void doShoot(Point point, Field.Type type) {
        User user;
        user = new User();
        Field field;
        field = new Field();
        Computer computer;
        computer = new Computer();
        User.setPoint(point);
        User.setIsShoot(true);
    }

    public static boolean showNewWinner(Field.Type x) {
        if (x.equals(Field.Type.NONE)) {
            return false;
        }
        winner = x;
        return true;
    }

    public void showField(Field.Type[][] cells) {
        gameWindow.showNewField(cells);
    }

}
