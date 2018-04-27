package com.example.views;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public abstract class Hole extends View implements ChangeListener {


    private char player; // "A" or "B"
    private boolean isPit; // true for pit, false for mancala
    private ArrayList<Stone> stones;
    Style style;

    public Hole(char newPlayer, boolean newType, Style newStyle) {
        player = newPlayer;
        isPit = newType;
        style = newStyle;
    }

    //when the state is changed by the model, redraw
    @Override
    public void stateChanged(ChangeEvent e) {

    }

    public char getPlayer() {
        return player;
    }

    public boolean isPit() {
        return isPit;
    }

    //using a spiral function, locate points and use them to draw stones
    public void drawStone(){

    }

    public void addStone() {
        stones.add(new Stone());
    }

    public void removeStone() {
        stones.remove(0);
    }
}
