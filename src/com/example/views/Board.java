package com.example.views;

import com.example.model.State;
import com.example.views.concrete.EllipticStyle;

import java.awt.*;
import java.util.ArrayList;

public class Board extends View {

    private Style style;
    private State currentState;
    private State previousState;

    private double MANCALA_WIDTH;
    private double MANCALA_HEIGHT;

    private double PIT_WIDTH;
    private double PIT_HEIGHT;


    public Board(Style newStyle) {
        super(newStyle);
        style = newStyle;
        MANCALA_WIDTH = this.getWidth() / 9;
        MANCALA_HEIGHT = this.getHeight();
        PIT_WIDTH = this.getWidth() / 10;
        PIT_HEIGHT = this.getHeight() / 2;
//        initialize();

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
