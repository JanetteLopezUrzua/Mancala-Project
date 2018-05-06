package com.example.views;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Pit extends Hole {

//    public Pit(char newPlayer, boolean _isPit, Style style) {
//        super(newPlayer, _isPit, style);
//    }
//
//    public Pit(char newPlayer, boolean _isPit, Style style, int _numOfStones) {
//        super(newPlayer, _isPit, style, _numOfStones);
//    }
//
//    public Hole(char newPlayer, boolean _isPit, Style newStyle) {
//        super(newStyle);
//        player = newPlayer;
//        isPit = _isPit;
//    }

    public Pit(Style newStyle, com.example.model.Hole hole) {
        super(newStyle, hole);
    }

//    public Hole(Style newStyle, int _numOfStones) {
//        super(newStyle);
//        numOfStones = _numOfStones;
//    }

//    @Override
//    public void draw(Graphics2D g2) {
//        this.setSize(new Dimension(getStyle().getWidth(), getStyle().getHeight()));
//        Shape shape = getStyle().getShape();
//        g2.setColor(getStyle().getColor());
//        g2.draw(shape);
//        initStones2(g2);
//    }
}
