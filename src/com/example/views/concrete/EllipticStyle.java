package com.example.views.concrete;

import com.example.views.Style;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipticStyle extends Style {

    public EllipticStyle(Color newColor) {
        super(newColor);
    }

    @Override
    public void makeshape(double x, double y, double width, double height) {
        this.setShape(new Ellipse2D.Double(x, y, width, height));
    }
}
