package com.bensler.gol;

import javax.swing.JScrollPane;

public class Main {

  public final static String[] STATIC_1 = new String[] {
    "....",
    ".XX.",
    ".XX.",
    "....",
  };

  public final static String[] STATIC_2 = new String[] {
    ".....",
    "..X..",
    ".X.X.",
    "..X..",
    ".....",
  };

  public final static String[] STATIC_3 = new String[] {
    ".....",
    "..X..",
    ".X.X.",
    ".X.X.",
    "..X..",
    ".....",
  };

  public final static String[] STATIC_4 = new String[] {
    "......",
    "..XX..",
    ".X..X.",
    ".X..X.",
    "..XX..",
    "......",
  };

  public final static String[] STATIC_5 = new String[] {
    "......",
    "..XX..",
    ".X..X.",
    "..X.X.",
    "...X..",
    "......",
  };

  public final static String[] STATIC_6 = new String[] {
    "......",
    "..X...",
    ".X.X..",
    "..X.X.",
    "...X..",
    "......",
  };

  public final static String[] BLINKER = new String[] {
    ".....",
    ".....",
    ".XXX.",
    ".....",
    ".....",
  };

  public final static String[] CLOCK = new String[] {
    "......",
    "...X..",
    ".XX...",
    "...XX.",
    "..X...",
    "......",
  };

  public final static String[] TOAD = new String[] {
    "......",
    "..XX..",
    ".X....",
    "....X.",
    "..XX..",
    "......",
  };

  public final static String[] BIPOLE = new String[] {
    "......",
    ".XX...",
    ".X....",
    "....X.",
    "...XX.",
    "......",
  };

  public final static String[] TRIPOLE = new String[] {
    ".......",
    ".XX...",
    ".X....",
    "..X.X.",
    ".....X.",
    "....XX.",
    ".......",
  };

  public final static String[] PULSATOR = new String[] {
    "..................",
    "..................",
    "..................",
    "..................",
    ".....X.X..X.X.....",
    ".XX.X..X..X..X.XX.",
    ".....X.X..X.X.....",
    "..................",
    "..................",
    "..................",
    "..................",
  };

  public final static String[] FOUNTAIN = new String[] {
    "...........",
    "..X.....X..",
    "...XX.XX...",
    "....X.X....",
    "..X.....X..",
    "..XXX.XXX..",
    "..XXX.XXX..",
    "...........",
    "...........",
    "...........",
  };

  public final static String[] OCTAGON = new String[] {
    "..........",
    "...X..X...",
    "...X..X...",
    ".XX.XX.XX.",
    "...X..X...",
    "...X..X...",
    ".XX.XX.XX.",
    "...X..X...",
    "...X..X...",
    "..........",
  };

  public static void main(String[] args) {
    new BaseApp("Game of Live", new JScrollPane(new GameOfLife(20, 20, new GridDeSerializer().gridFromString(BLINKER))));
  }

}
