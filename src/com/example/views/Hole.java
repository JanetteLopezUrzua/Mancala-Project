package com.example.views;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public abstract class Hole extends View implements ChangeListener {

    private ArrayList<Stone> stones;
    char player;
    boolean isPit;

    public Hole(char newPlayer, boolean _isPit, Style newStyle) {
        super(newStyle);
        player = newPlayer;
        isPit = _isPit;
    }

    //when the state is changed by the model, redraw
    @Override
    public void stateChanged(ChangeEvent e) {

    }

    //using a spiral function, locate points and use them to draw stones
    public void drawStone(){

    }

    public void addStone() {
//        stones.add(new Stone());
    }

    public void removeStone() {
        stones.remove(0);
    }
}
