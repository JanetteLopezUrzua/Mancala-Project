package com.example;

import com.example.views.Board;
import com.example.views.concrete.RoundedRectangularStyle;
import com.example.views.View;

import javax.swing.*;
import java.awt.*;

public class MancalaTester {

    public static final int BOARD_WIDTH = 800;
    public static final int BOARD_HEIGHT = 300;

    public static void main(String[] args) {
//        Color color = new Color(Color.AQUA);
        JFrame frame = new JFrame();

        View board = new Board(0, 0, BOARD_WIDTH, BOARD_HEIGHT, new RoundedRectangularStyle(Color.BLACK));

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                board.draw((Graphics2D) g);
            }
        };

        panel.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
//        frame.pack();
        frame.setSize( new Dimension(BOARD_WIDTH , BOARD_HEIGHT + 50));
        frame.setVisible(true);

    }
}
