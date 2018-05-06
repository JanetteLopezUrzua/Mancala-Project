package com.example.views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

//we dont want views to be instantiated w/o extending, so the constructor is protected
//NOT a candidate for abstract class, because there's no templating/delegation of responsibility
public abstract class View extends JPanel implements ChangeListener {

//    private double x, y, w, h;
    private Style style;

    //choose a color for the view
    View(Style style){
        this.style = style;
        this.style.makeshape(this.getX(), this.getY(), style.getWidth(), style.getHeight());
        this.setSize(new Dimension(style.getWidth(), style.getHeight()));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw((Graphics2D) g);
    }

    //every view draws using the grahpics context
    public void draw(Graphics2D g2) {
        this.setSize(new Dimension(style.getWidth(), style.getHeight()));
        Shape shape = style.getShape();
        g2.setColor(style.getColor());
        g2.draw(shape);
//        g2.fill(style.getShape());
    }

    public void setStyle(Style style){
        this.style = style;
    }

    public Style getStyle(){
        return style;
    }

    //when the state is changed by the state, redraw the panel
    @Override
    public void stateChanged(ChangeEvent e) {
        repaint();
    }
}
