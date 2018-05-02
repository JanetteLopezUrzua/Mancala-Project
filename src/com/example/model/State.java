package com.example.model;

import com.example.views.Hole;

import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class State {
    private ArrayList<ChangeListener> views;
    protected ArrayList<Hole> holes;


    public State(ArrayList<Hole> _holes) {
        holes = _holes;
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }
}