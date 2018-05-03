package com.example.views;

import java.awt.*;
import java.util.ArrayList;

public class Hand extends View {

    private ArrayList<Stone> stones;

    public Hand(Style style) {
        super(style);
        setLayout(new FlowLayout());
    }

    //add a collection of stones to the hand
    public void addToHand(ArrayList<Stone> stones){
        this.stones = stones;
    }
    //take a specified stone out of the hand
    public void takeFromHand(Stone stone){
        this.stones.remove(stone);
    }
}
