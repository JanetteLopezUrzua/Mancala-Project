package com.example.views;

import java.awt.*;

public abstract class Style {

    private Color color;
    private Shape shape;
    private boolean fill;

    public Style(Color newColor) {

        color = newColor;

        //the view will be responsible for making a shape
//        shape = makeshape(newWidth * 0.05, newHeight* 0.05, newWidth * 0.90, newHeight * 0.95);
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
