package tictactoe20200618.view;

import tictactoe20200618.controller.GameController;
import tictactoe20200618.model.Field;
import tictactoe20200618.model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    public static boolean flag = false;
    public static final int SIZE = 3;
    JButton[][] buttons = new JButton[SIZE][SIZE];


    public void init() {
        setSize(400, 400);
        setTitle("XO Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(SIZE, SIZE));
        JPanel jPanelbatton = new JPanel();
        add(jPanelbatton, BorderLayout.NORTH);
        JButton jButtonExit = new JButton("Exit");
        jPanelbatton.add(jButtonExit);
        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton jButton = new JButton(/*j % 2 == 0 ? "X" : "O"*/);
                final int finalJ = j;
                final int finalI = i;
                disableBatons();
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (!flag) {
                            String buttonText = e.getActionCommand();
                            System.out.printf("Button: %s, x: %d, y: %d%n", buttonText, finalJ, finalI);
                            GameController.doShoot(new Point(finalI, finalJ), buttonText.equals("X") ? Field.Type.X : Field.Type.O);
                        }
                    }
                });
                buttons[i][j] = jButton;
                jPanel.add(jButton);
            }
        }
        add(jPanel);
        setVisible(true);
    }

    private void disableBatons() {
        if (flag) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    buttons[i][j].setEnabled(false);
                }
            }
        }
    }

    public void showWinner() {
        flag = GameController.gameOver;
        if (flag) {
            JOptionPane.showMessageDialog(this, "Победил " + GameController.winner);
        }
    }

    public void showNewField(Field.Type[][] cells) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (Field.Type.NONE) {
                    case NONE:
                        buttons[i][j].setText(cells[i][j].toString());
                        break;
                }
            }
        }
    }
}
