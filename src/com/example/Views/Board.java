package com.example.Views;

import com.example.Model.State;

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
