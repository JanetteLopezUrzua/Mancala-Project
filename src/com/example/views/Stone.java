package com.example.views;

import com.example.views.concrete.EllipticStyle;

import java.awt.*;

public class Stone extends View {

    int x;
    int y;
    Stone(int _x, int _y, Style style) {
        super(style);
        x = _x;
        y = _y;
    }

    //stones are circles
    @Override
    public void draw(Graphics2D g2) {
//        this.setSize(new Dimension(getStyle().getWidth(), getStyle().getHeight()));
        Shape shape = getStyle().makeshape(x, y, 5, 5);
        g2.setColor(getStyle().getColor());
        g2.draw(shape);
//        g2.draw(new EllipticStyle(Color.RED, 10, 10).makeshape(x, y, 5, 5));
//        initStones(g2);
    }

}
