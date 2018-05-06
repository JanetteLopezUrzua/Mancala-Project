package com.example.views;

import com.example.model.State;
import com.example.views.concrete.RectangularStyle;
import com.example.views.concrete.RoundedRectangularStyle;
import com.example.views.Hole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Board extends View {


    private State state;

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
    private Hand hand;
    private ArrayList<Hole> holes;

    public Board(Style boardStyle, Style pitStyle, Style mancalaStyle, State state, ArrayList<Hole> holes) {
        super(boardStyle);
        setSize(boardStyle.getWidth(), boardStyle.getHeight());
        setLayout(new BorderLayout(30,0));
        this.pitStyle = pitStyle;
        this.mancalaStyle = mancalaStyle;
        _numOfStones = 0;
        hand = new Hand(new RectangularStyle(Color.BLACK, getWidth()/3, 10));
        this.state = state;
        this.holes = holes;
        initialize();
    }

    @Override
    public void stateChanged(ChangeEvent c){
        state = (State) c.getSource();

        //update scores
        scoreA.setText(String.valueOf(state.getScoreA()));
        scoreB.setText(String.valueOf(state.getScoreB()));

        displayTurnPopUp(state.getPlayerTurn());
        if(state.isGameOver())    displayGameOver();
//        initialize();
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        LABEL_HEIGHT = this.getHeight() / 8;
    }

    private void createUndoButton() {
        //Create button to undo
        undo = new JButton("Undo");
        undo.setBackground(Color.BLUE);
        undo.setForeground(Color.WHITE);

        undo.addActionListener(e -> {
            state.undo();
            repaint();
        });
    }

    private void createUpperLowerPanels() {

        JPanel upperPanel = new JPanel(new GridLayout(0, 6, 40, 0));
        JPanel lowerPanel = new JPanel(new GridLayout(0, 6, 90, 0));

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
        JPanel upperPanelAndCloseAndUndo = new JPanel(new BorderLayout(30, 0));

        //panel to hold lower panel and scores
        JPanel lowerPanelAndScores = new JPanel(new BorderLayout(20, 0));

        upperPanel.setPreferredSize(new Dimension(getStyle().getWidth(), LABEL_HEIGHT));
        lowerPanel.setPreferredSize(new Dimension(getStyle().getWidth(), LABEL_HEIGHT));

        JLabel label;
        int s = 1;
        for (int k = 1; k <= 12; k++) {
            if (k <= 6) {
                label = new JLabel("A" + k);
                lowerPanel.add(label);
            } else {
                label = new JLabel("B" + (k - s));
                upperPanel.add(label);
                s += 2;
            }
        }

        upperPanelAndCloseAndUndo.setBorder((BorderFactory.createEmptyBorder(0, 40, 0, 0)));
        lowerPanelAndScores.setBorder((BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        lowerPanel.setBorder((BorderFactory.createEmptyBorder(0, 10, 0, 0)));

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
        lowerPanelAndScores.add(hand, BorderLayout.SOUTH);

        add(upperPanelAndCloseAndUndo, BorderLayout.NORTH);
        add(lowerPanelAndScores, BorderLayout.SOUTH);
    }

//    public boolean checkPits(boolean first) {
//
//        int c = 1;
//
//        if(!first) {
//            c += 7;
//        }
//
//        int limit = c + 6;
//
//        ArrayList<Hole> holes = state.getHoles();
//        for(; c < limit; c++) {
//            if( holes.get(c).getStones() != 0 )
//                return false;
//        }
//
//        return true;
//    }

//    //Keep score
//    public void scoreCount(){
//        if(state.getPlayerTurn() == 'A')
//             scoreA.setText("Score A: " + Integer.toString(state.getHoles().get(7).getStones()));
//        else if (state.getPlayerTurn() == 'B')
//             scoreB.setText("Score B: " + Integer.toString(state.getHoles().get(0).getStones()));
//    }

    public void draw(Graphics2D g2) {
        super.draw(g2);
    }

//    private void turn(int startingPit) {
//
//
//        if (state.getPlayerTurn() != state.getHoles().get(startingPit).getPlayer() ||
//                startingPit > state.getHoles().size())
//            return;
//        hand.addToHand(state.getHoles().get(startingPit).getStones());
//
//        startingPit = move(startingPit);
//        repaint();
//
//        scoreCount();
//
//        if(checkPits(true) || checkPits(false)) {
//
//            System.out.println("Game over");
//            System.out.println("Winner is player " + state.getWinningPlayer() + " with score of " + state.getMaxScore());
//        }
//
//        if (startingPit == -1) {
//            state.changeTurn();
//            displayTurnPopUp(state.getPlayerTurn());
//            state.resetUndoCounter();
////            displayTurnPopUp(state.getPlayerTurn());
//            System.out.println("Now it's " + state.getPlayerTurn() + "'s turn!");
//        }
//
//    }

//    public int move(int selectedPit) {
//
//        selectedPit %= 14;
//        ArrayList<Hole> holes = state.getHoles();
//
////<<<<<<< HEAD
////        long start;
////
////        char player = state.getPlayerTurn();
////=======
//        char player = state.getPlayerTurn();
//        int numOfStones = holes.get(selectedPit).takeStones();
//        while (numOfStones > 0) {
//            selectedPit++;
//            selectedPit %= holes.size();
//            Hole hole = holes.get(selectedPit);
//            if (((hole.getPlayer() == player && !hole.isPit())) || hole.isPit()) {
//                holes.get(selectedPit).addStone();
//                numOfStones--;
//                hand.takeFromHand();
////                repaint();
////                start = System.currentTimeMillis();
////                while( start + 300 >  System.currentTimeMillis() );
//            }
//        }
//
//        // Calculate opposite pit formula n + (7 - n) * 2 = k
//        int oppositePit = selectedPit + (7 - selectedPit) * 2;
//
//        if ((player == 'A' && selectedPit == 7) || (player == 'B' && selectedPit == 0))
//            return -2;
//
//        if (holes.get(selectedPit).getPlayer() == player && holes.get(oppositePit).getStones() >= 1 &&
//                holes.get(selectedPit).getStones() == 1) {
//            int stones = holes.get(oppositePit).takeStones();
//            stones += holes.get(selectedPit).takeStones();
//            state.moveToMancala(stones, player);
//            System.out.println("Transfer opposite stones to your mancala");
//            return -1;
////<<<<<<< HEAD
////
////        } else if(holes.get(selectedPit).getStones() > 1) {
////            System.out.println("Still " + state.getPlayerTurn() + "'s turn!");
////            return selectedPit;
////        }
////        else{
////            System.out.println("Player " +  player + ", please select your pits");
////=======
////>>>>>>> 61dae2aa5008e0d9813c3f3c32c745dde8fa7624
//        }
//
//        repaint();
//        return -1;
//    }


    /**
     * Initialize the board view
     */
    private void initialize() {

        createUpperLowerPanels();
//        ArrayList<Hole> holes = ;

        //Add mancala B to the array of holes = holes[0]
//        Mancala mancalaB = new Mancala('B', false, mancalaStyle);
//        Mancala mancalaB = new Mancala(mancalaStyle, state.getHoles().get(7));
//
//        holes.add(mancalaB);

        //Add Pits to the array of holes
        Pit pit;
        JLabel label;
//        for (int c = 0; c < 12; c++) {
//            if (c < 6)
//                pit = new Pit('A', true, pitStyle, _numOfStones);
//            else
//                pit = new Pit('B', true, pitStyle, _numOfStones);
//            holes.add(pit);
//            //
//            Pit finalPit = pit;
//
//            pit.addMouseListener(new MouseListener() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    if (finalPit.contains(e.getX(), e.getY())) {
//                        int index = Board.this.state.getHoles().indexOf(finalPit);
//                        Hole hole = Board.this.state.getHoles().get(index);
//                        System.out.println("Player " + Board.this.state.getPlayerTurn() + " clicked " + hole.getPlayer() + index);
//                        if (hole.getStones() > 0)
//                            turn(index);
//                    }
//                }
//
//                @Override
//                public void mousePressed(MouseEvent e) {
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                }
//            });
//        }
//        for (int c = 0; c < 12; c++) {
////            pit = new Pit('A', true, pitStyle, _numOfStones);
//            pit = new Pit(pitStyle);
//            com.example.model.Hole hole;
//            if (c < 6)
//                hole = new com.example.model.Hole('A', true);
//            else
//                hole = new com.example.model.Hole('B', true);
//            hole.attach(pit);
//
//            holes.add(pit); //belongs in Board
//
//            Pit finalPit = pit;
//
//            pit.addMouseListener(new MouseListener() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    if (finalPit.contains(e.getX(), e.getY())) {
//                        int index = Board.this.state.getHoles().indexOf(finalPit);
//                        com.example.model.Hole hole = Board.this.state.getHoles().get(index);
//                        System.out.println("Player " + Board.this.state.getPlayerTurn() + " clicked " + hole.getPlayer() + index);
//                        if (hole.getStones() > 0)
//                            turn(index);
//                    }
//                }
//
//                @Override
//                public void mousePressed(MouseEvent e) {
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                }
//            });
//        }

        //Set a Border on the JPanel to fit the mancalas in the board
        setBorder(BorderFactory.createEmptyBorder(25,120,120,150));

        //JPanel with GridLayout to hold the pits
        JPanel holdPits = new JPanel(new GridLayout(2, 6));

        //Add pits to the holdPits JPanel
        for (int i = 13; i > 7; i--) {
            holdPits.add(holes.get(i));
        }

        for (int i = 1; i <= 6; i++) {
            holdPits.add(holes.get(i));
        }

        //Add mancala A to the array of holes = holes[13]
//        Mancala mancalaA = new Mancala('A', false, mancalaStyle);
//        Mancala mancalaA = new Mancala(mancalaStyle, state.getHoles().get(0));
//        holes.add(7, mancalaA);

        //Panel to hold pits and mancalas
        JPanel holdPitsAndMancalas = new JPanel(new BorderLayout());

        //Add mancalas to the holdPitsAndMancalas JPanel
        holdPitsAndMancalas.add(holes.get(0), BorderLayout.WEST);
        holdPitsAndMancalas.add(holes.get(7), BorderLayout.EAST);

//        state = new State(holes);           //create State  --> should NOT be creating a state! we should be using a created state
//        state = new Model(state);
        //Set a border on the holdPits JPanel to fit the pits in the middle of the board
        holdPits.setBorder(BorderFactory.createEmptyBorder(20, 70, 0, 0));

        //Add holdPits JPanel to the holdPitsAndMancalas JPanel
        holdPitsAndMancalas.add(holdPits, BorderLayout.CENTER);
        holdPitsAndMancalas.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));

        //create panels to hold mancala labels
        JPanel labelMancalaA = new JPanel(new GridLayout(0, 1));
        JPanel labelMancalaB = new JPanel(new GridLayout(0, 1));

        //Letters to create labels for mancalas
        String m1 = "MANCALA A";
        String m2 = "MANCALA B";

        for(int l = 0; l < m1.length(); l++)
        {
            char a_char = m1.charAt(l);
            JLabel letter = new JLabel(Character.toString(a_char));
            letter.setFont(new Font("Mosk Typeface", Font.BOLD, 14));
            labelMancalaA.add(letter);
        }

        for(int n = 0; n < m2.length(); n++)
        {
            char a_char = m2.charAt(n);
            JLabel letter = new JLabel(Character.toString(a_char));
            letter.setFont(new Font("Mosk Typeface", Font.BOLD, 14));
            labelMancalaB.add(letter);
        }

        //Add holdPitsAndMancalas and mancala labels to board
        add(holdPitsAndMancalas, BorderLayout.CENTER);
        add(labelMancalaB, BorderLayout.WEST);
        add(labelMancalaA, BorderLayout.EAST);
        Hand hand = new Hand(new RoundedRectangularStyle(Color.GRAY,getWidth()/3,getHeight()/12));
//        add(hand, BorderLayout.SOUTH);
    }

//    public void setNumOfStones(int answer) {
//        _numOfStones = answer;
//        state.setNumberOfStones(_numOfStones);
////        repaint();
//    }

    void displayTurnPopUp(char player){
        JFrame playerTurn = new JFrame();
        JLabel playerLabel = new JLabel("Turn: Player " + Character.toString(player));
        playerLabel.setFont(new Font("Mosk Typeface", Font.BOLD, 18));
        playerLabel.setHorizontalAlignment(JLabel.CENTER);
        playerTurn.setUndecorated(true);
        playerTurn.add(playerLabel);
        //playerTurn.setBackground(new Color(0, 0, 0, 0));
        playerTurn.pack();
        playerTurn.setLocationRelativeTo(this);
        playerTurn.setVisible(true);
        playerTurn.setOpacity(0.75f);
        Timer timer = new Timer(900, e -> playerTurn.dispose());
        timer.start();
    }

    void displayGameOver(){
        JFrame gameOver = new JFrame();
        gameOver.setLayout(new BorderLayout());
        JLabel gameOverLabel = new JLabel(" Game Over ");
        gameOverLabel.setFont(new Font("Mosk Typeface", Font.BOLD, 90));
        gameOverLabel.setForeground(Color.RED);
        gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel winnerLabel = new JLabel("Winner is player " + state.getWinningPlayer() + " with score of " + state.getMaxScore());
        winnerLabel.setFont(new Font("Mosk Typeface", Font.BOLD, 25));
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);
        gameOver.add(gameOverLabel, BorderLayout.NORTH);
        gameOver.add(winnerLabel, BorderLayout.CENTER);
        gameOver.pack();
        gameOver.setLocationRelativeTo(this);
        gameOver.setVisible(true);
    }


    public JButton getCloseButton() {
        return close;
    }

    public JButton getUndoButton(){
        return undo;
    }
}