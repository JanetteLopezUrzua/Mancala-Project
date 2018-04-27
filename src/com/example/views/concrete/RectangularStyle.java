package com.example.views.concrete;

import com.example.views.Style;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangularStyle extends Style {

    public RectangularStyle(Color newColor) {
        super(newColor);
    }

    @Override
    public void makeshape(double x, double y, double width, double height) {
        this.setShape(new Rectangle2D.Double(x, y, width, height));
    }
}
