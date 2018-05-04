package com.example.views;

import com.example.model.Model;
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

    Model model;

//    private State currentState;
//    private State previousState;
    private JButton close;
    private JButton undo;
    private JLabel scoreA;
    private JLabel scoreB;
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
        _numOfStones = 0;
        initialize();
    }

    @Override
    public void setSize(int width, int height){
        super.setSize(width, height);
        LABEL_HEIGHT = this.getHeight() / 8;
    }

    private void createUndoButton() {
        //Create button to undo
        undo = new JButton("Undo");
        undo.setBackground(Color.BLUE);
        undo.setForeground(Color.WHITE);

        undo.addActionListener(e -> {
            model.undo();
        });
    }

    private void createUpperLowerPanels() {

        JPanel upperPanel = new JPanel(new GridLayout(0, 6, 40 , 0));
        JPanel lowerPanel = new JPanel(new GridLayout(0, 6, 90 , 0));

        //Create button to close board and put it with upperPanel
        close = new JButton("X");
        close.setBackground(Color.RED);
        close.setOpaque(true);
//        close.setForeground(Color.WHITE);
        close.setBorderPainted(false);


        createUndoButton();

        //Create score labels
        scoreA = new JLabel("Score A: " + 0);
        scoreB = new JLabel("Score B: " + 0);

        //panel to hold upper panel and close button
        JPanel upperPanelAndCloseAndUndo = new JPanel(new BorderLayout(30, 0 ));

        //panel to hold lower panel and scores
        JPanel lowerPanelAndScores = new JPanel(new BorderLayout(20, 0));

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

        upperPanelAndCloseAndUndo.setBorder((BorderFactory.createEmptyBorder(0,40,0,0)));
        lowerPanelAndScores.setBorder((BorderFactory.createEmptyBorder(0,20,0,0)));
        lowerPanel.setBorder((BorderFactory.createEmptyBorder(0,10,0,0)));

        scoreA.setHorizontalAlignment(JLabel.RIGHT);
        scoreB.setHorizontalAlignment(JLabel.LEFT);
        scoreA.setFont(new Font("Mosk Typeface", Font.BOLD, 18));
        scoreB.setFont(new Font("Mosk Typeface", Font.BOLD, 18));
        scoreA.setForeground(Color.RED);
        scoreB.setForeground(Color.RED);

        upperPanelAndCloseAndUndo.add(upperPanel, BorderLayout.CENTER);
        upperPanelAndCloseAndUndo.add(close, BorderLayout.EAST);
        upperPanelAndCloseAndUndo.add(undo, BorderLayout.WEST);

        lowerPanelAndScores.add(lowerPanel, BorderLayout.CENTER);
        lowerPanelAndScores.add(scoreA, BorderLayout.EAST);
        lowerPanelAndScores.add(scoreB, BorderLayout.WEST);

        add(upperPanelAndCloseAndUndo, BorderLayout.NORTH);
        add(lowerPanelAndScores, BorderLayout.SOUTH);

    }

    //Keep score
    public void scoreCount(){
        if(model.getPlayerTurn() == 'A')
             scoreA.setText("Score A: " + Integer.toString(model.getHoles().get(7).getStones()));
        else if (model.getPlayerTurn() == 'B')
             scoreB.setText("Score B: " + Integer.toString(model.getHoles().get(0).getStones()));
    }

    public void draw(Graphics2D g2){
        super.draw(g2);
    }

    public void turn(int startingPit) {

        if(model.getPlayerTurn() != model.getHoles().get(startingPit).getPlayer() ||
                startingPit > model.getHoles().size())
            return;

        while (startingPit > -1) {

            startingPit = move(startingPit);
            repaint();
        }

        scoreCount();

        if(startingPit == -1) {
            model.changeTurn();
            displayTurnPopUp();
            System.out.println("Now it's " + model.getPlayerTurn() + "'s turn!");
        }

    }

    public int move(int selectedPit) {

        selectedPit %= 14;
        ArrayList<Hole> holes = model.getHoles();

        long start;

        char player = model.getPlayerTurn();
        int numOfStones = holes.get(selectedPit).takeStones();
        while(numOfStones > 0) {
            selectedPit++;
            selectedPit %= holes.size();
            Hole hole = holes.get(selectedPit);
            if( ( (hole.getPlayer() == player && !hole.isPit()) ) || hole.isPit() ) {
                holes.get(selectedPit).addStone();
                numOfStones--;
//                repaint();
//                start = System.currentTimeMillis();
//                while( start + 300 >  System.currentTimeMillis() );
            }
//            repaint();
        }

        // Calculate opposite pit formula n + (7 - n) * 2 = k
        int oppositePit = selectedPit + (7 - selectedPit) * 2;

        if((player == 'A' && selectedPit == 7) || (player == 'B' && selectedPit == 0))
            return -2;

        if( holes.get(selectedPit).getPlayer() == player && holes.get(oppositePit).getStones() >= 1 &&
                holes.get(selectedPit).getStones() == 1) {
            System.out.println("Transfer opposite stones to your mancala");
            return -1;

        } else if(holes.get(selectedPit).getStones() > 1) {
            System.out.println("Still " + model.getPlayerTurn() + "'s turn!");
            return selectedPit;
        }
        else{
            System.out.println("Player " +  player + ", please select your pits");
        }

        repaint();
        return -1;
    }


    /**
     * Initialize the board view
     */
    private void initialize() {

        createUpperLowerPanels();
        State state;
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
                        int index = model.getHoles().indexOf(finalPit);
                        Hole hole = model.getHoles().get(index);
                        System.out.println("Player " + model.getPlayerTurn() + " clicked " + hole.getPlayer() + index);
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

         //Set a Border on the JPanel to fit the mancalas in the board
         setBorder(BorderFactory.createEmptyBorder(25,120,145,150));

         //JPanel with GridLayout to hold the pits
         JPanel holdPits = new JPanel(new GridLayout(2,6));

         //Add pits to the holdPits JPanel
        for(int i = 12; i > 6; i--){
            holdPits.add(holes.get(i));
        }

        for(int i = 1; i <= 6; i++){
            holdPits.add(holes.get(i));
        }

        //Add mancala A to the array of holes = holes[13]
        Mancala mancalaA = new Mancala('A', false, mancalaStyle);
        holes.add(7, mancalaA);

        //Panel to hold pits and mancalas
        JPanel holdPitsAndMancalas = new JPanel(new BorderLayout());

        //Add mancalas to the holdPitsAndMancalas JPanel
        holdPitsAndMancalas.add(mancalaB, BorderLayout.WEST);
        holdPitsAndMancalas.add(mancalaA, BorderLayout.EAST);

        state =  new State(holes);
        model = new Model(state);
        displayTurnPopUp();
        //Set a border on the holdPits JPanel to fit the pits in the middle of the board
        holdPits.setBorder(BorderFactory.createEmptyBorder(20,90,0,0));

        //Add holdPits JPanel to the holdPitsAndMancalas JPanel
        holdPitsAndMancalas.add(holdPits, BorderLayout.CENTER);
        holdPitsAndMancalas.setBorder(BorderFactory.createEmptyBorder(0,0,0,70));

        //Letters to create labels for mancalas
        JLabel M = new JLabel("M");
        JLabel A1 = new JLabel("A");
        JLabel N = new JLabel("N");
        JLabel C = new JLabel("C");
        JLabel A2 = new JLabel("A");
        JLabel L = new JLabel("L");
        JLabel A3 = new JLabel("A");
        JLabel blank = new JLabel("");
        JLabel A4 = new JLabel("A");

        JLabel M2 = new JLabel("M");
        JLabel A5 = new JLabel("A");
        JLabel N2 = new JLabel("N");
        JLabel C2 = new JLabel("C");
        JLabel A6 = new JLabel("A");
        JLabel L2 = new JLabel("L");
        JLabel A7 = new JLabel("A");
        JLabel B = new JLabel("B");
        JLabel blank2 = new JLabel("");

        //create panels to hold mancala labels
        JPanel labelMancalaA = new JPanel(new GridLayout(0, 1));
        JPanel labelMancalaB = new JPanel(new GridLayout(0, 1));

        //add letters to label panel A
        labelMancalaA.add(M);
        labelMancalaA.add(A1);
        labelMancalaA.add(N);
        labelMancalaA.add(C);
        labelMancalaA.add(A2);
        labelMancalaA.add(L);
        labelMancalaA.add(A3);
        labelMancalaA.add(blank);
        labelMancalaA.add(A4);

        //add letters to label panel B
        labelMancalaB.add(M2);
        labelMancalaB.add(A5);
        labelMancalaB.add(N2);
        labelMancalaB.add(C2);
        labelMancalaB.add(A6);
        labelMancalaB.add(L2);
        labelMancalaB.add(A7);
        labelMancalaB.add(blank2);
        labelMancalaB.add(B);

        //Add holdPitsAndMancalas and mancala labels to board
        add(holdPitsAndMancalas, BorderLayout.CENTER);
        add(labelMancalaB, BorderLayout.WEST);
        add(labelMancalaA, BorderLayout.EAST);
    }

    public void setNumOfStones(int answer){
        _numOfStones = answer;
        model.setNumberOfStones(_numOfStones);
//        repaint();
    }

    void displayTurnPopUp(){

        if(model.getPlayerTurn() == 'A') {
            JOptionPane pane = new JOptionPane("Player A", JOptionPane.INFORMATION_MESSAGE,JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null );
            JDialog dialog = pane.createDialog(null, "Turn");
            dialog.setModal(false);
            dialog.setVisible(true);
            dialog.setLocation(800, 700);
            new Timer(800, e -> dialog.setVisible(false)).start();
        }
        else if(model.getPlayerTurn() == 'B') {
            JOptionPane pane = new JOptionPane("Player B", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
            JDialog dialog = pane.createDialog(null, "Turn");
            dialog.setModal(false);
            dialog.setVisible(true);
            dialog.setLocation(800, 180);
            new Timer(800, e -> dialog.setVisible(false)).start();
        }
    }


    public JButton getCloseButton(){
        return close;
    }

    public JButton getUndoButton(){
        return undo;
    }
}