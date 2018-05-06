package com.example.views;

import java.awt.*;
import java.util.ArrayList;

public class Hand extends View {

    private int numStones;

    public Hand(Style style) {
        super(style);
        setLayout(new FlowLayout());
    }

    //add a collection of stones to the hand
    public void addToHand(int numStones){
        this.numStones = numStones;
    }
    //take a specified stone out of the hand
    public void takeFromHand(){
        numStones--;
    }
}
