package com.example.views;

//import com.sun.deploy.security.WinDeployNTLMAuthCallback;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShapedBoard extends JFrame {

    Style style;
    Shape shape;


    public ShapedBoard(Style newStyle, int width, int height) {
        super("ShapedWindow");

        style = newStyle;
        shape = style.getShape();


        setLayout(new BorderLayout());

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(shape);
            }
        });


        setTitle("Mancala");
        setUndecorated(true);
        setSize(width, height);

        setResizable(true);
//        set;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
