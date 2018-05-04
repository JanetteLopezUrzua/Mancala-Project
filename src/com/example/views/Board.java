package com.example.views;

import com.example.model.State;
import com.example.views.concrete.EllipticStyle;
import com.example.views.concrete.RectangularStyle;
import com.example.views.concrete.RoundedRectangularStyle;
import org.omg.PortableInterceptor.HOLDING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Board extends View {
    private State currentState;
    private State previousState;

    private int LABEL_HEIGHT;
    private int _numOfStones;
    private Style pitStyle;
    private Style mancalaStyle;


    public Board(Style boardStyle,  Style pitStyle, Style mancalaStyle) {
        super(boardStyle);
        setSize(boardStyle.getWidth(), boardStyle.getHeight());
        setLayout(new BorderLayout());
        this.pitStyle = pitStyle;
        this.mancalaStyle = mancalaStyle;
        _numOfStones = 3;
        initialize();
    }

    @Override
    public void setSize(int width, int height){
        super.setSize(width, height);
        LABEL_HEIGHT = this.getHeight() / 8;
    }

    private void createUpperLowerPanels() {

        JPanel upperPanel = new JPanel(new GridLayout(0, 6, 30 , 0));
        JPanel lowerPanel = new JPanel(new GridLayout(0, 6, 30 , 0));

        upperPanel.setPreferredSize(new Dimension(getStyle().getWidth(), LABEL_HEIGHT));
        lowerPanel.setPreferredSize(new Dimension(getStyle().getWidth(), LABEL_HEIGHT));

        JLabel label;
        int s = 1;
        for(int k = 1; k<=12; k++)
        {
            if(k <= 6){
                label = new JLabel("A" + k);
                lowerPanel.add(label);
            }
            else{
                label = new JLabel("B" + (k-s));
                upperPanel.add(label);
                s+=2;
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

    public void turn(int startingPit) {
        if(currentState.getPlayerTurn() != currentState.getHoles().get(startingPit).getPlayer() || startingPit > currentState.getHoles().size())
            return;

        int moveResult = 0;
        while (startingPit != -1) {

            startingPit = move(startingPit);
//            System.out.println("Now it's " + currentState.getPlayerTurn() + "'s turn!");
            repaint();
        }


        currentState.changeTurn();
        System.out.println("Now it's " + currentState.getPlayerTurn() + "'s turn!");
    }

    public int move(int selectedPit) {

        selectedPit %= 14;
        ArrayList<Hole> holes = currentState.getHoles();
//        if(selectedPit > holes.size() )
//            return;

        char player = holes.get(selectedPit).getPlayer();
        int numOfStones = holes.get(selectedPit).takeStones();
        while(numOfStones > 0) {
            selectedPit++;
            selectedPit %= (holes.size() - 1);
            Hole hole = holes.get(selectedPit);
            if( ( (hole.getPlayer() == player && !hole.isPit()) ) || hole.isPit() ) {
                holes.get(selectedPit).addStone();
                numOfStones--;
            }
        }

        // Calculate opposite pit formula n + (7 - n) * 2 = k
        int oppositePit = selectedPit + (7 - selectedPit) * 2;

        if( holes.get(selectedPit).getPlayer() == player && holes.get(oppositePit).getStones() >= 1 && holes.get(selectedPit).getStones() == 1) {
            System.out.println("Transfer opposite stones to your mancala");
            return -1;

        } else if(holes.get(selectedPit).getStones() > 1) {
            System.out.println("Still " + currentState.getPlayerTurn() + "'s turn!");
            return selectedPit;

        } else {
//            currentState.changeTurn();
            System.out.println("Now it's " + currentState.getPlayerTurn() + "'s turn!");
        }
        repaint();

        return -1;
    }


    /**
     * Initialize the board view
     */
    private void initialize() {

        createUpperLowerPanels();
//        State state;
        ArrayList<Hole> holes = new ArrayList<>();

        //Add mancala B to the array of holes = holes[0]
        Mancala mancalaB = new Mancala('B', false, mancalaStyle);
        holes.add(mancalaB);

        //Add Pits to the array of holes
        Pit pit;
        JLabel label;
        for(int c = 0; c < 12; c++) {
            if(c < 6)
                pit = new Pit('A', true, pitStyle, _numOfStones);
            else
                pit = new Pit('B', true, pitStyle, _numOfStones);
            holes.add(pit);
            //
            Pit finalPit = pit;
            pit.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(finalPit.contains(e.getX(), e.getY())) {
                        int index = currentState.getHoles().indexOf(finalPit);
                        Hole hole = currentState.getHoles().get(index);
                        System.out.println("Player " + currentState.getPlayerTurn() + " clicked " + hole.getPlayer() + index) ;
                        if(hole.getStones() > 0)
                            turn(index);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        //Add mancala A to the array of holes = holes[13]


         //Set a Border on the JPanel to fit the mancalas in the board
         setBorder(BorderFactory.createEmptyBorder(25,100,55,150));

         //Add mancalas to the Board JPanel
         add(mancalaB, BorderLayout.WEST);


         //JPanel with GridLayout to hold the pits
         JPanel holdPits = new JPanel(new GridLayout(2,6));

         //Add pits to the holdPits JPanel
//         for(int i =1; i<=12; i++){
//             holdPits.add(holes.get(i));
//         }

        for(int i = 12; i > 6; i--){
            holdPits.add(holes.get(i));
        }

        for(int i = 1; i <= 6; i++){
            holdPits.add(holes.get(i));
        }

        Mancala mancalaA = new Mancala('A', false, mancalaStyle);
        holes.add(7, mancalaA);

        add(mancalaA, BorderLayout.EAST);

        currentState =  new State(holes);

        //Set a border on the holdPits JPanel to fit the pits in the middle of the board
        holdPits.setBorder(BorderFactory.createEmptyBorder(20,90,0,0));

        //Add holdPits JPanel to the Board JPanel
        add(holdPits, BorderLayout.CENTER);
    }

    public void setNumOfStones(int answer){
        _numOfStones = answer;
        currentState.setNumberOfStones(_numOfStones);
//        repaint();
    }

    void displayTurnPopUp(){

        if(currentState.getPlayerTurn() == 'A') {
            JOptionPane pane = new JOptionPane("Player A", JOptionPane.INFORMATION_MESSAGE,JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null );
            JDialog dialog = pane.createDialog(null, "Turn");
            dialog.setModal(false);
            dialog.setVisible(true);
            dialog.setLocation(800, 700);
            new Timer(5000, e -> dialog.setVisible(false)).start();
        }
        else if(currentState.getPlayerTurn() == 'B') {
            JOptionPane pane = new JOptionPane("Player B", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
            JDialog dialog = pane.createDialog(null, "Turn");
            dialog.setModal(false);
            dialog.setVisible(true);
            dialog.setLocation(800, 180);
            new Timer(5000, e -> dialog.setVisible(false)).start();
        }
    }
}