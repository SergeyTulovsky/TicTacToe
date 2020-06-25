package tictactoe20200618.model;

import tictactoe20200618.controller.GameController;

public class Field {
    public static final int SIZE = 3;

    public Type[][] cells = new Type[SIZE][SIZE];
    Computer computer;

    public Field(int size) {
    }

    public Field() {

    }

    GameController gameController;

    public enum Type {
        X, O, NONE;

        @Override
        public String toString() {
            if (this.equals(NONE)) {
                return "";
            }
            if (this.equals(X)) {
                return "X";
            }
            return "O";
        }
    }

    public void init() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = Type.NONE;
            }
        }
    }

    public void showField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (cells[i][j]) {
                    case NONE:
                        System.out.print(" . ");
                        break;
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void shoot(Point point, Type who) {

        gameController = new GameController();
        if (!checkPoint(point)) {
            System.out.println("ходы закончились");
        }
        if (checkPoint(point)) {
            cells[point.getX()][point.getY()] = who;
            gameController.showField(cells);
        }
    }

    public boolean checkPoint(Point point) { //проверка точки выстрела

        boolean yes = false;

        if (cells[point.getX()][point.getY()].equals(Type.NONE)) {
            yes = true;
        }
        return yes;
    }

    public Type whoIsWinner() {
        if (checkWin(Type.X)) {
            return Type.X;
        }
        if (checkWin(Type.O)) {
            return Type.O;
        }
        return Type.NONE;
    }

    private boolean checkWin(Type t) {

        if (cells[0][0] == t && cells[1][0] == t && cells[2][0] == t) {
            return true;
        }
        if (cells[0][1] == t && cells[1][1] == t && cells[2][1] == t) {
            return true;
        }
        if (cells[0][2] == t && cells[1][2] == t && cells[2][2] == t) {
            return true;
        }
        if (cells[0][0] == t && cells[0][1] == t && cells[0][2] == t) {
            return true;
        }
        if (cells[1][0] == t && cells[1][1] == t && cells[1][2] == t) {
            return true;
        }
        if (cells[2][0] == t && cells[2][1] == t && cells[2][2] == t) {
            return true;
        }
        if (cells[0][0] == t && cells[1][1] == t && cells[2][2] == t) {
            return true;
        }
        if (cells[0][2] == t && cells[1][1] == t && cells[2][0] == t) {
            return true;
        }
        return false;
    }
}
