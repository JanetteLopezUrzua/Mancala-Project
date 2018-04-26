package com.example.views.concrete;

import com.example.views.Style;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipticStyle extends Style {

    public EllipticStyle(Color newColor) {
        super(newColor);
    }

    @Override
    public Shape makeshape(double x, double y, double width, double height) {
        return new Ellipse2D.Double(x, y, width, height);
    }
}
