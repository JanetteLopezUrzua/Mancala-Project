package com.example.Views;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipticStyle extends AbstractGameStyle {

    public EllipticStyle(Color newColor, double newWidth, double newHeight) {
        super(newColor, newWidth, newHeight);
    }

    @Override
    public Shape makeshape(double x, double y, double width, double height) {
        return new Ellipse2D.Double(x, y, width, height);
    }
}
