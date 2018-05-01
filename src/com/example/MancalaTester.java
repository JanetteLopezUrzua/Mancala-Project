package com.example;


import com.example.views.Board;
import com.example.views.FrameDragListener;
import com.example.views.ShapedBoard;
import com.example.views.View;
import com.example.views.concrete.EllipticStyle;
import com.example.views.concrete.RoundedRectangularStyle;

import javax.swing.*;
import java.awt.*;

public class MancalaTester {

    private static final int BOARD_WIDTH = 1200;
    private static final int BOARD_HEIGHT = 400;

    public static void main(String[] args) {


        ShapedBoard frame = new ShapedBoard(new RoundedRectangularStyle(Color.BLACK, BOARD_WIDTH, BOARD_HEIGHT), BOARD_WIDTH, BOARD_HEIGHT);
//        JFrame frame = new JFrame(); //new RoundedRectangularStyle(Color.BLACK, BOARD_WIDTH, BOARD_HEIGHT), BOARD_WIDTH, BOARD_HEIGHT);

        View board = new Board(new RoundedRectangularStyle(Color.BLACK, BOARD_WIDTH, BOARD_HEIGHT));

        //JPanel panel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//
//                board.draw((Graphics2D) g);
//            }
        //};

        //panel.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));



        FrameDragListener frameDragListener = new FrameDragListener(frame);

        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);

        //frame.setLayout(new FlowLayout());
        frame.setLayout(new BorderLayout());
//        frame.add(panel, BorderLayout.CENTER);
        frame.add(board, BorderLayout.CENTER);
        frame.setResizable(true);
//        frame.pack();
        frame.setSize( new Dimension(BOARD_WIDTH , BOARD_HEIGHT + 50));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.pack();
        frame.setVisible(true);

        Timer t = new Timer(100, e -> {
            frame.repaint();
            board.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        });

        t.start();
    }
}
