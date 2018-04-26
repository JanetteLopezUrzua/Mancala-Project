package com.example.views;

import java.awt.*;

public class Pit extends Hole{

    public Pit(char newPlayer, boolean newType, AbstractGameStyle style) {
        super(newPlayer, newType, style);
    }

    //draw the Mancala as a circle
    @Override
    public void draw(Graphics2D g2) {
        style.draw(g2);
    }
}
