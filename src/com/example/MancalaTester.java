package com.example;

import com.example.Views.Board;
import com.example.Views.RectangularStyle;

import java.awt.*;

public class MancalaTester {

    public static final double BOARD_WIDTH = 800;
    public static final double BOARD_HEIGHT = 300;

    public static void main(String[] args) {
//        Color color = new Color(Color.AQUA);

        Board board = new Board(new RectangularStyle(Color.GRAY, BOARD_WIDTH, BOARD_HEIGHT));
    }
}
