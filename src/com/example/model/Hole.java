package com.example.model;

import javafx.scene.control.TextFormatter;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Mancala Game Project
 * @author Janette Lopez Urzua, Omar Riaz, Nikita Voloshenko
 */

public class Hole {
    private char player;
    private boolean isPit;
    protected int numOfStones;
    private ChangeListener changeListener;

    public Hole(char player, boolean isPit) {
        this.player = player;
        this.isPit = isPit;
    }

    public void addStone() {
//        stones.add(new Stone());
        numOfStones++;
    }

    public void removeStone() {
//        stones.remove(0);
        numOfStones--;
    }

    public char getPlayer() {
        return player;
    }

    public boolean isPit() {
        return isPit;
    }

    public int getStones() {
        return numOfStones;
    }

    public int takeStones() {

        int temp = numOfStones;
        numOfStones = 0;
        return temp;
    }

    public void setNumberOfStones(int _numOfStones) {

        numOfStones = _numOfStones;
//        repaint();
    }

    public void appendStones(int stones) {
        numOfStones += stones;
    }

    //attaching one view to this model object. Overwrites previous one
    public void attach(ChangeListener c){
        changeListener = c;
    }

    public void update(){
        changeListener.stateChanged(new ChangeEvent(this));
    }

}
