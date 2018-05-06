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

    public abstract Shape makeshape(int x, int y, int width, int height);

    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }
}
