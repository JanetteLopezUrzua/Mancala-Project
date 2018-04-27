package com.example.views.concrete;

import com.example.views.Style;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangularStyle extends Style {

    public RectangularStyle(Color newColor, double newWidth, double newHeight) {
        super(newColor, newWidth, newHeight);
    }

    @Override
    public Shape makeshape(double x, double y, double width, double height) {
        return new Rectangle2D.Double(x, y, width, height);
    }
}
