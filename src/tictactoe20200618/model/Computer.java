package tictactoe20200618.model;

public class Computer {
    private Point point;

    public Point getShootPoint() {
        point = Point.getRandomPoint();
        return point;
    }
}
