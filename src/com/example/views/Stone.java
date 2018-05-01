package com.example.views;

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
        this.setSize(new Dimension(getStyle().getWidth(), getStyle().getHeight()));
        Shape shape = getStyle().makeshape(x, y, getStyle().getWidth(), getStyle().getHeight());
        g2.setColor(getStyle().getColor());
        g2.draw(shape);
//        initStones(g2);
    }

}
