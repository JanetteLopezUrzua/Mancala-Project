package com.example;


import com.example.model.Hole;
import com.example.model.State;
import com.example.views.*;
import com.example.views.concrete.EllipticStyle;
import com.example.views.concrete.RectangularStyle;
import com.example.views.concrete.RoundedRectangularStyle;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MancalaTester {

    private static final int BOARD_WIDTH = 1200;
    private static final int BOARD_HEIGHT = 450;
/*    //variable to hold answer for number of stones per pit
    private static int numberOfStones;*/
    private static final int MANCALA_WIDTH = BOARD_WIDTH/15;
    private static final int MANCALA_HEIGHT = BOARD_HEIGHT - 190;

    private static final int PIT_WIDTH = BOARD_WIDTH/12;

    public static void main(String[] args) {

        //Create Menu
        JFrame menu = new JFrame();
        menu.setLayout(new BorderLayout());
        menu.setSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        menu.setLocationRelativeTo(null);

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
        button1.setBackground(new Color(0,0,204));
        button2.setBackground(new Color(0,0,204));
        button3.setBackground(new Color(0,0,204));

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

        //set 3 different styles
        //Style 1
        Style boardStyle1  = new RoundedRectangularStyle(Color.BLACK, BOARD_WIDTH, BOARD_HEIGHT+50);
        Style pitStyle1 = new EllipticStyle(new Color(204,0,0), PIT_WIDTH, PIT_WIDTH);
        Style mancalaStyle1 = new RoundedRectangularStyle(new Color(0,0,204), MANCALA_WIDTH, MANCALA_HEIGHT);

        //Style 2
        Style boardStyle2  = new RectangularStyle(Color.GRAY, BOARD_WIDTH, BOARD_HEIGHT);
        Style pitStyle2 = new RoundedRectangularStyle(new Color(255,102,95), PIT_WIDTH+25, PIT_WIDTH-5);
        Style mancalaStyle2 = new RectangularStyle(new Color(102,0,120), MANCALA_WIDTH, MANCALA_HEIGHT);

        //Style 3
        Style boardStyle3  = new RoundedRectangularStyle(Color.BLACK, BOARD_WIDTH, BOARD_HEIGHT);
        Style pitStyle3 = new RectangularStyle(new Color(0,153,0), PIT_WIDTH, PIT_WIDTH-5);
        Style mancalaStyle3 = new EllipticStyle(new Color(255,204,51), MANCALA_WIDTH, MANCALA_HEIGHT);

        menu.setVisible(true);

        //add events to the buttons
        button1.addActionListener(event -> {
                    menu.dispatchEvent(new WindowEvent(menu, WindowEvent.WINDOW_CLOSING));
                    displayBoard(menu, boardStyle1, pitStyle1, mancalaStyle1);
        });


        button2.addActionListener(event -> {
            menu.dispatchEvent(new WindowEvent(menu, WindowEvent.WINDOW_CLOSING));
            displayBoard(menu, boardStyle2, pitStyle2, mancalaStyle2);
        });

        button3.addActionListener(event -> {
            menu.dispatchEvent(new WindowEvent(menu, WindowEvent.WINDOW_CLOSING));
            displayBoard(menu, boardStyle3, pitStyle3, mancalaStyle3);
        });
    }

    /* static ActionListener displayQuestionForStones(JFrame menu, Style boardStyle, Style pitStyle, Style mancalaStyle){

    }*/

    static void displayBoard(JFrame menu, Style boardStyle, Style pitStyle, Style mancalaStyle){


        ShapedBoard frame = new ShapedBoard(boardStyle, BOARD_WIDTH, BOARD_HEIGHT + 90);
//        JFrame frame = new JFrame(); //new RoundedRectangularStyle(Color.BLACK, BOARD_WIDTH, BOARD_HEIGHT), BOARD_WIDTH, BOARD_HEIGHT);


        State state = new State();
        ArrayList<com.example.views.Hole> holes = new ArrayList<>();

        for (int c = 0; c < 12; c++) {
//            pit = new Pit('A', true, pitStyle, _numOfStones);
            com.example.model.Hole hole;
            if (c < 6)
                hole = new com.example.model.Hole('A', true);
            else
                hole = new com.example.model.Hole('B', true);
            Pit pit = new Pit(pitStyle, hole);
            hole.attach(pit);
            holes.add(pit); //belongs in Board
            state.addHole(hole);

            Pit finalPit = pit;

            pit.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (finalPit.contains(e.getX(), e.getY())) {
                        int index = holes.indexOf(pit);
//                        com.example.model.Hole hole = this.state.getHoles().get(index);
                        System.out.println("Player " + state.getPlayerTurn() + " clicked " + hole.getPlayer() + index);
                        if (hole.getStones() > 0)
//                            turn(index);
                            state.turn(index);
                    }
                }
                @Override
                public void mousePressed(MouseEvent e) {}
                @Override
                public void mouseReleased(MouseEvent e) {}
                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
            });
        }
        //adding Mancalas
        Hole mancalaHoleA = new Hole('A', false);
        Hole mancalaHoleB = new Hole('B', false);
        Mancala mancalaA = new Mancala(mancalaStyle, mancalaHoleA);
        Mancala mancalaB = new Mancala(mancalaStyle, mancalaHoleB);
        mancalaHoleA.attach(mancalaA);
        mancalaHoleB.attach(mancalaB);
        holes.add(6, mancalaB);
        holes.add(0, mancalaA);
        state.addHole(mancalaHoleA);
        state.addHole(mancalaHoleB);
        //Pop up button options
        Object[] options = { "3", "4"};

        int result = JOptionPane.showOptionDialog(menu, "How many stones per pit?", "Enter Number Of Stones",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

        if(result == JOptionPane.YES_OPTION)
        {
            state.setNumberOfStones(3);
        }
        else if (result == JOptionPane.NO_OPTION)
        {
            state.setNumberOfStones(4);
        }

        View board = new Board(boardStyle, pitStyle, mancalaStyle, state, holes);

        FrameDragListener frameDragListener = new FrameDragListener(frame);

        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);

        frame.add(board, BorderLayout.CENTER);

        frame.setResizable(true);
        frame.setVisible(true);

        //Close frame and exit application
        ((Board) board).getCloseButton().addActionListener(e -> frame.dispose());


//        Hand hand = new Hand(new RoundedRectangularStyle(Color.GRAY,BOARD_WIDTH/2,BOARD_HEIGHT/8));
//        frame.add(hand, BorderLayout.SOUTH);

        //Close frame
        ((Board) board).getCloseButton().addActionListener(e -> frame.dispose());

//        ((Board) board).getUndoButton().addActionListener(e-> )
    }

}
