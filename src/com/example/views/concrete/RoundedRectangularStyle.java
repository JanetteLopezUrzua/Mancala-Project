package com.example.views.concrete;

import com.example.views.Style;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedRectangularStyle extends Style {

    public RoundedRectangularStyle(Color newColor) {
        super(newColor);
    }

    @Override
    public void makeshape(double x, double y, double width, double height) {
        this.setShape(new RoundRectangle2D.Double(x, y, width, height, 100, 100));
    }
}
