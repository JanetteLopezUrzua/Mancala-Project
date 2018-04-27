package com.example.views.concrete;

import com.example.views.Style;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedRectangularStyle extends Style {

    public RoundedRectangularStyle(Color newColor, double newWidth, double newHeight) {
        super(newColor, newWidth, newHeight);
    }

    @Override
    public Shape makeshape(double x, double y, double width, double height) {
        return new RoundRectangle2D.Double(x, y, width, height, 100, 100);
//        Shape shape = new RoundRectangle2D.Double();
    }
}
