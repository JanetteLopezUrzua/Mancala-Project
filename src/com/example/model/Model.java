package com.example.model;

import com.example.views.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

//the model
public class Model {
    private State currentState;
    private State previousState;
    private ArrayList<View> views;

    //attach a view to the model
    public void attach(View view){
        views.add(view);
    }

    //update all of the view attached to the model
    public void update(){
        for(ChangeListener c: views){
            c.stateChanged(new ChangeEvent(this));      //pass the state as the changeEvent
        }
    }

    public void setNumberOfStones(int numOfStones) {
        currentState.setNumberOfStones(numOfStones);
    }
}
