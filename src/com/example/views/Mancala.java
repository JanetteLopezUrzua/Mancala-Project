package com.example.views;

import java.awt.*;

public class Mancala extends Hole {

    //draw the Mancala as a rounded rectangle

    public Mancala(Style newStyle, com.example.model.Hole hole) {
        super(newStyle, hole);
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
