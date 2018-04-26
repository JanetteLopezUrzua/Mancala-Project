package com.example.views;

import java.awt.*;

public abstract class Style {

    private Color color;
    private Shape shape;
    private boolean fill;

    public Style(Color newColor) {
        color = newColor;
    }

    public abstract Shape makeshape(double x, double y, double width, double height);

    public Shape getShape(){
        return shape;
    }

    public Color getColor(){
        return color;
    }

    public void fillColor(boolean fill){
        this.fill = fill;
    }
}
