//package com.example.model;
//
//import com.example.views.Hole;
//import com.example.views.View;
//import com.sun.org.apache.xpath.internal.operations.Mod;
//
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import java.util.ArrayList;
//
////the model
//public class Model {
////    private State currentState;
//    private State previousState;
//    private ArrayList<View> views;
//
//    private int undoCount;
//
//    public Model(State state) {
//        currentState = state;
//        previousState = (State) currentState.clone();
//    }
//
//    //attach a view to the model
//    public void attach(View view){
//        views.add(view);
//    }
//
//    //update all of the view attached to the model
//    public void update(){
//        for(ChangeListener c: views){
//            c.stateChanged(new ChangeEvent(this));      //pass the state as the changeEvent
//        }
//    }
//
//    public void setNumberOfStones(int numOfStones) {
//        currentState.setNumberOfStones(numOfStones);
//    }
//
//    public ArrayList<Hole> getHoles() {
//        return currentState.getHoles();
//    }
//
//    public void changeTurn() {
//        currentState.changeTurn();
//    }
//
//    public char getPlayerTurn() {
//        return currentState.getPlayerTurn();
//    }
//
//    public int getUndoCount(){
//        return undoCount;
//    }
//
//    public void increaseUndoCount() {undoCount++;}
//    public void decreaseUndoCount() {undoCount--;}
//
//    public void setUndoCount(int undoCount){
//        this.undoCount = undoCount;
//    }
//
//    public void incrementUndoCount(){
//        this.undoCount++;
//    }
//}
