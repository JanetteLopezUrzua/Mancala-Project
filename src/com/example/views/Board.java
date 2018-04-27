package com.example.views;

import com.example.model.State;
import com.example.views.concrete.EllipticStyle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends View {
    private State currentState;
    private State previousState;

    private int MANCALA_WIDTH;
    private int MANCALA_HEIGHT;

    private int PIT_WIDTH;
    private int PIT_HEIGHT;

    private int LABEL_HEIGHT;


    public Board(Style newStyle) {

        super(newStyle);
        MANCALA_WIDTH = this.getWidth() / 9;
        MANCALA_HEIGHT = this.getHeight();
        PIT_WIDTH = this.getWidth() / 10;
        PIT_HEIGHT = this.getHeight() / 2;
        LABEL_HEIGHT = this.getHeight() / 8;
//        initialize();

    }

    private void createUpperLowerPanels() {
        JPanel upperPanel = new JPanel(new BorderLayout());
        JPanel lowerPanel = new JPanel(new BorderLayout());

        upperPanel.setPreferredSize(new Dimension(getStyle().getWIDTH(), ));
        lowerPanel.setPreferredSize(new Dimension(getStyle().getWIDTH(), ));

        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);
    }

    public void draw(Graphics2D g2){
        super.draw(g2);
    }

//    public void initialize() {
//        State state = new State();
//        ArrayList<Hole> holes = new ArrayList<>();
//
//        Mancala mancala = new Mancala('B', false, new EllipticStyle(Color.GRAY, style.getWIDTH(), style.getHEIGHT()));
//        holes.add(mancala);
//
//        Pit pit;
//
////        for(int c = 0; c < 12; c++) {
////            if(c < 6)
////                pit = new Pit('A', true);
////            else
////                pit = new Pit('B', true);
////
////            holes.add(pit);
////        }
////
////        mancala = new Mancala('A', false);
////        holes.add(mancala);
//    }
}
