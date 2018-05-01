package com.example.views;

import com.example.model.State;
import com.example.views.concrete.EllipticStyle;
import com.example.views.concrete.RoundedRectangularStyle;
import org.omg.PortableInterceptor.HOLDING;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends View {
    private State currentState;
    private State previousState;

    private int MANCALA_WIDTH;
    private int MANCALA_HEIGHT;

    private int PIT_WIDTH;
    private int PIT_HEIGHT;

    private int LABEL_HEIGHT;


    public Board(Style newStyle) {
        super(newStyle);
        setSize(newStyle.getWidth(), getHeight());
//        MANCALA_WIDTH = this.getWidth() / 9;
//        MANCALA_HEIGHT = this.getHeight();
//        PIT_WIDTH = this.getWidth() / 10;
//        PIT_HEIGHT = this.getHeight() / 2;
          setLayout(new BorderLayout());
        initialize();

    }

    @Override
    public void setSize(int width, int height){
        super.setSize(width, height);
        MANCALA_WIDTH = this.getWidth() / 15;
        MANCALA_HEIGHT = this.getHeight() - 135;
        PIT_WIDTH = this.getWidth() / 12;
        PIT_HEIGHT = this.getHeight() / 3;
        LABEL_HEIGHT = this.getHeight() / 8;
//        initialize();

    }

    private void createUpperLowerPanels() {
        JPanel upperPanel = new JPanel(new GridLayout(0, 6, 30 , 0));
        JPanel lowerPanel = new JPanel(new GridLayout(0, 6, 30 , 0));

        upperPanel.setPreferredSize(new Dimension(getStyle().getWidth(),LABEL_HEIGHT));
        lowerPanel.setPreferredSize(new Dimension(getStyle().getWidth(), LABEL_HEIGHT));

        //upperPanel.setBackground(Color.PINK);
        //lowerPanel.setBackground(Color.pink);

        JLabel label;
        for(int k = 1; k<=12; k++)
        {
            if(k <= 6){
                label = new JLabel("A" + k);
                lowerPanel.add(label);
            }
            else{
                label = new JLabel("B" + (k));
                upperPanel.add(label);
            }
        }

        upperPanel.setBorder((BorderFactory.createEmptyBorder(0,140,0,0)));
        lowerPanel.setBorder((BorderFactory.createEmptyBorder(0,140,0,0)));

        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);
    }

    public void draw(Graphics2D g2){
        super.draw(g2);
    }


    /**
     * Initialize the board view
     */
    private void initialize() {

        createUpperLowerPanels();
        State state = new State();
        ArrayList<Hole> holes = new ArrayList<>();

        //Add mancala B to the array of holes = holes[0]
        Mancala mancalaB = new Mancala('B', false, new RoundedRectangularStyle(Color.BLUE, MANCALA_WIDTH, MANCALA_HEIGHT));
        holes.add(mancalaB);

        //Add Pits to the array of holes
        Pit pit;
        JLabel label;
        for(int c = 0; c < 12; c++) {
            if(c < 6)
                pit = new Pit('A', true, new EllipticStyle(Color.RED, PIT_WIDTH, PIT_WIDTH));
            else
                pit = new Pit('B', true, new EllipticStyle(Color.RED, PIT_WIDTH, PIT_WIDTH));

            holes.add(pit);
        }

        //Add mancala A to the array of holes = holes[13]
         Mancala mancalaA = new Mancala('A', false, new RoundedRectangularStyle(Color.BLUE, MANCALA_WIDTH, MANCALA_HEIGHT));
         holes.add(mancalaA);

         //Set a Border on the JPanel to fit the mancalas in the board
         setBorder(BorderFactory.createEmptyBorder(25,100,55,150));

         //Add mancalas to the Board JPanel
         add(mancalaB, BorderLayout.WEST);
         add(mancalaA, BorderLayout.EAST);

         //JPanel with GridLayout to hold the pits
         JPanel holdPits = new JPanel(new GridLayout(2,6));

         //Add pits to the holdPits JPanel
         for(int i =1; i<=12; i++){
             holdPits.add(holes.get(i));
         }

         //Set a border on the holdPits JPanel to fit the pits in the middle of the board
         holdPits.setBorder(BorderFactory.createEmptyBorder(20,90,0,0));

         //Add holdPits JPanel to the Board JPanel
         add(holdPits, BorderLayout.CENTER);



    }
}
