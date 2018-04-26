package com.example.views;

import com.example.model.State;
import com.example.views.concrete.EllipticStyle;

import java.awt.*;
import java.util.ArrayList;

public class Board extends View {

    AbstractGameStyle style;
    State currentState;
    State previousState;

    public Board() {
        State state = new State();
    }

    public Board(AbstractGameStyle newStyle) {
        style = newStyle;
//        initialize();

    }

    @Override
    public void draw(Graphics2D g2) {
        style.draw(g2);
    }

    public void initialize() {
        State state = new State();
        ArrayList<Hole> holes = new ArrayList<>();

        Mancala mancala = new Mancala('B', false, new EllipticStyle(Color.GRAY, style.getWIDTH(), style.getHEIGHT()));
        holes.add(mancala);

        Pit pit;

//        for(int c = 0; c < 12; c++) {
//            if(c < 6)
//                pit = new Pit('A', true);
//            else
//                pit = new Pit('B', true);
//
//            holes.add(pit);
//        }
//
//        mancala = new Mancala('A', false);
//        holes.add(mancala);
    }
}
