package com.example.views;

import java.awt.*;

public abstract class AbstractGameStyle {

    private Color color;
    private Shape shape;

    private double WIDTH;
    private double HEIGHT;

    public AbstractGameStyle(Color newColor, double newWidth, double newHeight) {

        color = newColor;
        WIDTH = newWidth;
        HEIGHT = newHeight;

        shape = makeshape(WIDTH * 0.05, HEIGHT * 0.05, WIDTH * 0.90, HEIGHT * 0.95);
    }

    public void draw(Graphics2D g2) {

        g2.setColor(color);
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(2));
//        g2.
        g2.draw(shape);
        g2.setStroke(oldStroke);
    }

    public abstract Shape makeshape(double x, double y, double width, double height);

    public double getHEIGHT() {
        return HEIGHT;
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }
}
