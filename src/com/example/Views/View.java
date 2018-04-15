package com.example.Views;

import java.awt.*;

public abstract class View {

    private Color color;

    //choose a color for the view
    View(){
        this.color = Color.BLACK;
    }

    void setColor(Color color){
        this.color = color;
    }

    //every view has its own way of being drawn
    abstract public void draw(Graphics2D g2);
}
