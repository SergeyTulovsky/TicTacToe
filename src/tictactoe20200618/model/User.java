package tictactoe20200618.model;

public class User extends Thread {
    private static volatile Point point;
    private static volatile boolean isShoot;
    //private Object key1 = new Object() ;

    public static void setPoint(Point point) {
        User.point = point;
    }

    public Point getShootPoint() {
        isShoot = false;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isShoot) ;

            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return point;
    }

    public static void setIsShoot(boolean s) {
        isShoot = s;
    }
}
