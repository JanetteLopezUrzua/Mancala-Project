package com.example.views;

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

}
