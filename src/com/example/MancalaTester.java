package com.example;


import com.example.views.Board;
import com.example.views.FrameDragListener;
import com.example.views.ShapedBoard;
import com.example.views.View;
import com.example.views.concrete.EllipticStyle;
import com.example.views.concrete.RectangularStyle;
import com.example.views.concrete.RoundedRectangularStyle;

import javax.swing.*;
import java.awt.*;

public class MancalaTester {

    private static final int BOARD_WIDTH = 1200;
    private static final int BOARD_HEIGHT = 400;

    public static void main(String[] args) {
/*
        //Create Menu
        JFrame menu = new JFrame();
        menu.setLayout(new BorderLayout());

        //Create panel for title and prompt
        JPanel titleAndPrompt = new JPanel(new BorderLayout());

        //Create centered and colored labels for title and prompt
        JLabel title = new JLabel("MANCALA GAME");
        JLabel prompt = new JLabel("Choose a style");

        //Center labels
        title.setHorizontalAlignment(JLabel.CENTER);
        prompt.setHorizontalAlignment(JLabel.CENTER);

        //Set Color to title label
        title.setForeground(Color.RED);

        //Set font for labels
        title.setFont(new Font("Mosk Typeface", Font.BOLD, 70));
        prompt.setFont(new Font("Mosk Typeface", Font.PLAIN, 30));

        //add labels to titleAndPrompt panel
        titleAndPrompt.add(title, BorderLayout.NORTH);
        titleAndPrompt.add(prompt, BorderLayout.CENTER);

        //add titleAndPrompt panel to Menu JFrame
        menu.add(titleAndPrompt, BorderLayout.NORTH);

        //Create panel for buttons
        JPanel holdButtons = new JPanel(new GridLayout(0,3, 50, 0));
        holdButtons.setBorder(BorderFactory.createEmptyBorder(70,90,70,90));

        //Create buttons
        JButton button1 = new JButton("Style One");
        JButton button2 = new JButton("Style Two");
        JButton button3 = new JButton("Style Three");

        //Set color of buttons
        button1.setBackground(Color.GRAY);
        button2.setBackground(Color.GRAY);
        button3.setBackground(Color.GRAY);

        //set color and font of buttons text
        button1.setForeground(Color.WHITE);
        button2.setForeground(Color.WHITE);
        button3.setForeground(Color.WHITE);

        button1.setFont(new Font("Mosk Typeface", Font.BOLD, 20));
        button2.setFont(new Font("Mosk Typeface", Font.BOLD, 20));
        button3.setFont(new Font("Mosk Typeface", Font.BOLD, 20));

        //add buttons to holdButtons panel
        holdButtons.add(button1);
        holdButtons.add(button2);
        holdButtons.add(button3);

        //add holdButtons panel to Menu JFrame
        menu.add(holdButtons, BorderLayout.CENTER);

        menu.setSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.setVisible(true);
        */


        ShapedBoard frame = new ShapedBoard(new RectangularStyle(Color.BLACK, BOARD_WIDTH, BOARD_HEIGHT), BOARD_WIDTH, BOARD_HEIGHT);
//        JFrame frame = new JFrame(); //new RoundedRectangularStyle(Color.BLACK, BOARD_WIDTH, BOARD_HEIGHT), BOARD_WIDTH, BOARD_HEIGHT);

        View board = new Board(new RectangularStyle(Color.BLACK, BOARD_WIDTH, BOARD_HEIGHT));

        FrameDragListener frameDragListener = new FrameDragListener(frame);

        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);


        frame.setLayout(new BorderLayout());

        frame.add(board, BorderLayout.CENTER);
        frame.setResizable(true);

        frame.setSize( new Dimension(BOARD_WIDTH , BOARD_HEIGHT + 50));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
