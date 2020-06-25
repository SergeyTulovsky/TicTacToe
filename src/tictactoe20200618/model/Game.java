package tictactoe20200618.model;

import tictactoe20200618.controller.GameController;
import tictactoe20200618.view.GameWindow;

public class Game {
    Field field;
    User user;
    Computer computer;

    public void start() {
        field = new Field(Field.SIZE);
        user = new User();
        computer = new Computer();
        field.init();
        field.showField();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    System.out.println(Thread.currentThread());
                    field.shoot(user.getShootPoint(), Field.Type.X);
                    field.showField();
                    GameWindow gameWindow = new GameWindow();
                    if (field.whoIsWinner().equals(Field.Type.X)) {
                        GameController.gameOver = GameController.showNewWinner(Field.Type.X);
                        gameWindow.showWinner();
                    }
                    Point p;
                    while (true) {
                        p = computer.getShootPoint();
                        if (field.checkPoint(p)) {
                            break;
                        }
                    }
                    field.shoot(p, Field.Type.O);
                    field.showField();
                    if (field.whoIsWinner().equals(Field.Type.O)) {
                        GameController.gameOver = GameController.showNewWinner(Field.Type.O);
                        gameWindow.showWinner();
                    }
                }
            }
        });
        if (!GameController.gameOver) {
            thread.start();
        }
    }
}
