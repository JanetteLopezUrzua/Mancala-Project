package com.example.views;

import com.example.views.concrete.EllipticStyle;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public abstract class Hole extends View implements ChangeListener {

    private ArrayList<Stone> stones;
    char player;
    boolean isPit;
    int numOfStones;

    int coils = 3;
    int radius = 50;

    double thetaMax = coils * 2 * Math.PI;

    // How far to step away from center for each side.
    double awayStep = radius / thetaMax;

    // distance between points to plot
    double chord = 10;

    double rotation = 5;

    public Hole(char newPlayer, boolean _isPit, Style newStyle) {
        super(newStyle);
        player = newPlayer;
        isPit = _isPit;
    }

    public Hole(char newPlayer, boolean _isPit, Style newStyle, int _numOfStones) {
        super(newStyle);
        player = newPlayer;
        isPit = _isPit;
        numOfStones = _numOfStones;
//        initStones(numOfStones);
    }

    public void initStones2(Graphics2D g2) {

        Stone stone;

        int x = getWidth() / 2;


        int y = getHeight() / 2;


        int radiusStep = 10;


//        int diameter = 0; // diameter of the arc


        int arc = 180; // amount and direction of arc to sweep


        for ( int i = 0; i < numOfStones; i++ ) {

            if (i % 2 == 1) // move the x position every other repetition
                x -= 2 * radiusStep;


            y -= radiusStep; //

//            stone = new Stone(x, y, new EllipticStyle(Color.RED, 10, 10));
//
//            add(stone);
//            repaint();

            stone = new Stone(x, y, new EllipticStyle(Color.RED, 10, 10));
//            add(stone);

            g2.draw(new EllipticStyle(Color.RED, 10, 10).makeshape(x, y, 5, 5));
           // add(stone);
            repaint();
//            g2.fill(stone.getStyle().makeshape(x, y, 5, 5));

//            diameter += 2 * radiusStep; //
//
//            g2.drawArc(x, y, diameter, diameter, 0, arc);
// draw the arc


            arc = -arc; // reverse the direction of the arc
        }

    }

//    public void initStones(Graphics2D g2) {
//
//        int centerX = getWidth() / 2;
//        int centerY = getHeight() / 2;
//
//        Stone stone;
//
//        for ( double theta = chord / awayStep; theta <= numOfStones; ) {
//
//
//            // How far away from center
//            double away = awayStep * theta;
//            //
//            // How far around the center.
//            double around = theta + rotation;
//            //
//            // Convert 'around' and 'away' to X and Y.
//            double x = centerX + Math.cos ( around ) * away;
//            double y = centerY + Math.sin ( around ) * away;
//            //
//            // Now that you know it, do it.
//
//            // to a first approximation, the points are on a circle
//            // so the angle between them is chord/radius
//            theta += chord / away;
//
//            stone = new Stone( (int) x, (int) y, new EllipticStyle(Color.RED, 10, 10));
////            Shape shape = new EllipticStyle(Color.RED, 10, 10).makeshape((int) x, (int) y, 10, 10);
//            Shape shape = new EllipticStyle(Color.RED, 10, 10).getShape();
////            add(stone);
//            g2.setColor(Color.RED);
//            g2.fill(shape);
////            g2.draw(shape);
//        }
//    }

    //when the state is changed by the model, redraw
    @Override
    public void stateChanged(ChangeEvent e) {

    }

    //using a spiral function, locate points and use them to draw stones
    public void drawStone(){

    }

    public void addStone() {
//        stones.add(new Stone());
    }

    public void removeStone() {
        stones.remove(0);
    }
}
