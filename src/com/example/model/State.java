package com.example.model;

import com.example.views.Hole;
import com.example.views.Pit;
import com.example.views.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class State implements Cloneable {
//    private ArrayList<Hole> holes;
    private char playerTurn;
    private State previousState;
    private ArrayList<View> views;

    private int undoCount;


    public State() {
//        holes = _holes;
        playerTurn = 'A';
        views = new ArrayList<>();
        previousState = (State) this.clone();
    }

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

//    public ArrayList<Hole> getHoles(){
//        return holes;
//    }

    public char getPlayerTurn() {
        return playerTurn;
    }

    public void changeTurn() {
        if(playerTurn == 'A')
            playerTurn = 'B';
        else
            playerTurn = 'A';
    }

//    public void setNumberOfStones(int numOfStones) {
//        for(Hole hole: holes) {
//            if(hole instanceof Pit) {
//                hole.setNumberOfStones(numOfStones);
//            }
//        }
//    }

    public void increaseUndoCount() {undoCount++;}
    public void decreaseUndoCount() {undoCount--;}

    public void setUndoCount(int undoCount){
        this.undoCount = undoCount;
    }

    public void incrementUndoCount(){
        this.undoCount++;
    }

    public State getPreviousState(){
        return previousState;
    }

    public void setPreviousState(State state){
        previousState = state;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}