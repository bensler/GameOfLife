package com.bensler.gol;

public class StateOfTheWorld {

  private Grid grid;

  public StateOfTheWorld(Grid aGrid) {
    grid = aGrid;
  }

  public boolean isSet(int row, int col) {
    return grid.isSet(row, col);
  }

}
