package com.bensler.gol;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertYellow;

/** App entry point. */
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

  public final static String[] GLIDER = new String[] {
      ".....",
      "..X..",
      "...X.",
      ".XXX.",
      ".....",
  };

  public static void main(String[] args) throws UnsupportedLookAndFeelException {
    Plastic3DLookAndFeel.setCurrentTheme(new DesertYellow());
    UIManager.setLookAndFeel(new Plastic3DLookAndFeel());

    new BaseApp("Game of Live", new AppPanel());
  }

}
