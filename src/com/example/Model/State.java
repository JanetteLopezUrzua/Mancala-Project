package com.example.Model;

import com.example.Views.Mancala;
import com.example.Views.Pit;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class State {
    private ArrayList<ChangeListener> views;
    protected ArrayList<Pit> pits;
    protected ArrayList<Mancala> mancalas;

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
