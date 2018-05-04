package com.example.views;

import java.awt.*;

public class Stone {

    int x;
    int y;
    private Style style;
    private boolean moved;

    Stone(int _x, int _y, Style style) {
        this.style = style;
        x = _x;
        y = _y;
    }

    public Style getStyle(){
        return style;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return x;
    }

    public void setMoved(boolean moved){
        this.moved = moved;
    }

    public boolean isMoved(){
        return moved;
    }
//    //stones are circles
//    @Override
//    public void draw(Graphics2D g2) {
//        this.setSize(new Dimension(getStyle().getWidth(), getStyle().getHeight()));
//        Shape shape = getStyle().makeshape(x, y, getStyle().getWidth(), getStyle().getHeight());
//        g2.setColor(getStyle().getColor());
//        g2.draw(shape);
////        initStones(g2);
//    }

}
