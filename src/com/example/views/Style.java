package com.example.views;

import java.awt.*;

public abstract class Style {

    private Color color;
    private Shape shape;

    private int WIDTH;
    private int HEIGHT;

    public Style(Color newColor, int newWidth, int newHeight) {

        color = newColor;
        WIDTH = newWidth;
        HEIGHT = newHeight;

        shape = makeshape((int) (WIDTH * 0.05),  (int) (HEIGHT * 0.05), (int) (WIDTH * 0.90), (int) (HEIGHT * 0.95));
    }

    public void draw(Graphics2D g2) {

        g2.setColor(color);
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(2));
//        g2.
        g2.draw(shape);
        g2.setStroke(oldStroke);
    }

    public abstract Shape makeshape(int x, int y, int width, int height);

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }
}
