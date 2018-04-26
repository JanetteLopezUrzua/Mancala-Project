package com.example.views;

import java.awt.*;

public class Mancala extends Hole{

    //draw the Mancala as a rounded rectangle
    public Mancala(char newPlayer, boolean newType, AbstractGameStyle newStyle) {
        super(newPlayer, newType, newStyle);
    }

    @Override
    public void draw(Graphics2D g2) {
        style.draw(g2);
    }
}
