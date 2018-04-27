package com.example.views.concrete;

import com.example.views.Style;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipticStyle extends Style {

    public EllipticStyle(Color newColor, int newWidth, int newHeight) {
        super(newColor, newWidth, newHeight);
    }

    @Override
    public Shape makeshape(int x, int y, int width, int height) {
        return new Ellipse2D.Double(x, y, width, height);
    }
}
