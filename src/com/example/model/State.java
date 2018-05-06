package com.example.model;

import com.example.views.Hole;
import com.example.views.Pit;

import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class State implements Cloneable {
    private ArrayList<ChangeListener> views;
    private ArrayList<Hole> holes;
    private char playerTurn;


    public State(ArrayList<Hole> _holes) {
        holes = _holes;
        playerTurn = 'A';
    }

    public ArrayList<Hole> getHoles(){
        return holes;
    }

    public void moveToMancala(int stones, char player) {
        Hole hole;
        if(player == 'A') {
            hole = holes.get(7);
        } else {
            hole = holes.get(0);
        }

        while(stones > 0) {
            hole.addStone();
            stones--;
        }
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