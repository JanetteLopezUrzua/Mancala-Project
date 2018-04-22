package com.example.Views;

import java.awt.*;
import java.awt.geom.GeneralPath;

public abstract class Style {

    Color color;
    GeneralPath shape;

    public void draw(Graphics2D g2) {
        makeshape();
        g2.setColor(color);
        g2.draw(shape);
    }

    public abstract void makeshape();
}
