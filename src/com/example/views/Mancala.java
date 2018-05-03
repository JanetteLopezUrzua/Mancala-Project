package com.example.views;

import java.awt.*;

public class Mancala extends Hole {

    //draw the Mancala as a rounded rectangle

    public Mancala(char newPlayer, boolean isPit, Style newStyle) {
        super(newPlayer, isPit, newStyle);
    }

//    @Override
//    public void draw(Graphics2D g2) {
//        this.setSize(new Dimension(getStyle().getWidth(), getStyle().getHeight()));
//        Shape shape = getStyle().getShape();
//        g2.setColor(getStyle().getColor());
//        g2.draw(shape);
//        initStones2(g2);
//    }
}
