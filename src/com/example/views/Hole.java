package com.example.views;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public abstract class Hole extends View implements ChangeListener {


    char player; // "A" or "B"
    boolean isPit; // true for pit, false for mancala
    ArrayList<Stone> stones;

    public Hole(char newPlayer, boolean newType) {
        player = newPlayer;
        isPit = newType;
    }

    //when the state is changed by the model, redraw
    @Override
    public void stateChanged(ChangeEvent e) {

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
