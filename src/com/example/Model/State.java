package com.example.Model;

import javafx.scene.control.TextFormatter;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class State {
    private ArrayList<ChangeListener> views;

    public void State(){

    }

    public void attach(){

    }

    public void update(){
        for(ChangeListener c: views){
            c.stateChanged(new ChangeEvent(this));      //pass the state as the changeEvent
        }
    }
}
