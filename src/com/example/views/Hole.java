package com.example.views;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public abstract class Hole extends View implements ChangeListener {

    private ArrayList<Stone> stones;
    Style style;

    public Hole(Style newStyle) {
        super(newStyle);
        style = newStyle;
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
