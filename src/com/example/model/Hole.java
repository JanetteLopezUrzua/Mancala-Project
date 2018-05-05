package com.example.model;

public class Hole {
    private char player;
    private boolean isPit;
    protected int numOfStones;

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
}
