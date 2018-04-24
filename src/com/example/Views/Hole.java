package com.example.Views;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public abstract class Hole extends View implements ChangeListener {


    char player; // "A" or "B"
    boolean isPit; // true for A, false for B
    ArrayList<String> stones;

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
}
