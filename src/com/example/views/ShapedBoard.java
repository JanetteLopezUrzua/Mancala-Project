package com.example.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class ShapedBoard extends JFrame {

    Style style;
    Shape shape;


    public ShapedBoard(Style newStyle, int width, int height) {
        super("ShapedWindow");

        style = newStyle;
        shape = style.getShape();


        setLayout(new BorderLayout());

        // It is best practice to set the window's shape in
        // the componentResized method.  Then, if the window
        // changes size, the shape will be correctly recalculated.
        addComponentListener(new ComponentAdapter() {
            // Give the window an elliptical shape.
            // If the window is resized, the shape is recalculated here.
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(shape);
            }
        });

        setUndecorated(true);
        setSize(width,height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JButton("I am a Button"));
    }
}
