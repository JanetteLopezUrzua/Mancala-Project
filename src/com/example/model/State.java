package com.example.model;

import com.example.views.Hole;
import com.example.views.Pit;

import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class State {
    private ArrayList<ChangeListener> views;
    private ArrayList<Hole> holes;
    private char playerTurn;
    private int undoCount;

    public State(ArrayList<Hole> _holes) {
        holes = _holes;
        playerTurn = 'A';
    }

    public ArrayList<Hole> getHoles(){
        return holes;
    }

    public char getPlayerTurn() {
        return playerTurn;
    }

    public void changeTurn() {
        if(playerTurn == 'A')
            playerTurn = 'B';
        else
            playerTurn = 'A';
    }

    public void setNumberOfStones(int numOfStones) {
        for(Hole hole: holes) {
            if(hole instanceof Pit) {
                hole.setNumberOfStones(numOfStones);
            }
        }
    }

    public int getUndoCount(){
        return undoCount;
    }

    public void setUndoCount(int undoCount){
        this.undoCount = undoCount;
    }

    public void incrementUndoCount(){
        this.undoCount++;
    }
}