package com.example.Model;

import com.example.Views.Hole;
import com.example.Views.Mancala;
import com.example.Views.Pit;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class State {
    private ArrayList<ChangeListener> views;
    protected ArrayList<Hole> holes;

    public void State(){
        Hole mancala = new Mancala('A', false);
        holes.add(mancala);
        for(int c = 0; c < 12; c++) {
            Hole pit;
            if(c < 6)
                pit = new Pit('A', true);
            else
                pit = new Pit('B', true);

            holes.add(pit);
        }

        mancala = new Mancala('B', false);

        holes.add(mancala);
    }

    public void attach(){

    }

    public void update(){
        for(ChangeListener c: views){
            c.stateChanged(new ChangeEvent(this));      //pass the state as the changeEvent
        }
    }
}
