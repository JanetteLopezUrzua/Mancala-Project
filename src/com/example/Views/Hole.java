package com.example.Views;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public abstract class Hole extends View implements ChangeListener{

    //when the state is changed by the model, redraw
    @Override
    public void stateChanged(ChangeEvent e) {

    }

    //using a spiral function, locate points and use them to draw stones
    public void drawStone(){

    }
}
