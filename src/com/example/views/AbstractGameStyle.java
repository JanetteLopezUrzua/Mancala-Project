package com.example.views;

import java.awt.*;

public abstract class AbstractGameStyle {

    protected Color color;
    protected Shape shape;

    protected static double WIDTH;
    protected static double HEIGHT;

    public AbstractGameStyle(Color newColor, double newWidth, double newHeight) {
        color = newColor;
        WIDTH = newWidth;
        HEIGHT = newHeight;
    }

    public void draw(Graphics2D g2) {
        shape = makeshape(WIDTH * 0.05, HEIGHT * 0.1, WIDTH * 0.9, HEIGHT * 0.9);
        g2.setColor(color);
//        g2.
        g2.draw(shape);
    }

    public abstract Shape makeshape(double x, double y, double width, double height);
}
