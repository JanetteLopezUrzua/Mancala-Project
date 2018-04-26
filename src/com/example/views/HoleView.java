package com.example.views;

import com.example.model.Model;
import com.example.model.State;
import com.example.views.concrete.EllipticStyle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//A particular set of views that can hold stones and can serve as controllers
public abstract class HoleView extends View implements MouseListener {

    //We don't need these. All is handled by the way Holes are indexed
//    char player; // "A" or "B"
//    boolean isPit; // true for A, false for B
    ArrayList<Stone> stones;
    Model model;

    public HoleView(Style style) {
        super(style);

//        player = newPlayer;
//        isPit = newType;
    }

    //using a spiral function, locate points and use them to draw stones
    public void drawStone(){

    }

    //use some strategy to render a stone
    public void addStone() {
        //run algorith to determine new position of stone
        stones.add(new Stone(0,0,10,10, new EllipticStyle(Color.BLACK)));
    }

    public void removeStone() {
        stones.remove(0);
    }


    //holes register all mouse events that click on the HoleView view
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
//        if(getStyle().getShape().contains(e.getX(), e.getY()))  model.performTurn();          //perform a turn
    }
}
