package com.example.views;

import com.example.model.State;

import java.awt.*;

public class Board extends View {

    AbstractGameStyle style;
    State currentState;
    State previousState;

    public Board() {
        State state = new State();
    }

    public Board(AbstractGameStyle newStyle) {
        State state = new State();
        style = newStyle;


    }

    @Override
    public void draw(Graphics2D g2) {
        style.draw(g2);
    }

    public void initialize() {
        Mancala mancala = new Mancala('A', false);

        Pit pit;

        for(int c = 0; c < 12; c++) {
            if(c < 6)
                pit = new Pit('A', true)
        }
    }
}
