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
        style = newStyle;
    }

    @Override
    public void draw(Graphics2D g2) {
        style.draw(g2);
    }

    public void initialize() {

    }
}
