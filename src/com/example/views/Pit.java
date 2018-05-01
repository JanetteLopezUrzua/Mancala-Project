package com.example.views;

import java.awt.*;

public class Pit extends Hole {

    public Pit(char newPlayer, boolean _isPit, Style style) {
        super(newPlayer, _isPit, style);
    }

    public Pit(char newPlayer, boolean _isPit, Style style, int _numOfStones) {
        super(newPlayer, _isPit, style, _numOfStones);
    }

    @Override
    public void draw(Graphics2D g2) {
        this.setSize(new Dimension(getStyle().getWidth(), getStyle().getHeight()));
        Shape shape = getStyle().getShape();
        g2.setColor(getStyle().getColor());
        g2.draw(shape);
        initStones2(g2);
    }
}
