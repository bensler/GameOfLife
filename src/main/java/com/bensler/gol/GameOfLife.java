package com.bensler.gol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameOfLife extends JPanel {

  public final static int CELL_SIZE = 40;
  public final static int GAP_SIZE = 5;
  public final static int GRID_SIZE = CELL_SIZE + GAP_SIZE;

  private final int rowCount;
  private final int colCount;

	private Grid state;

  public GameOfLife(int rows, int cols, Grid grid) {
    rowCount = rows;
    colCount = cols;
    state = grid;
    setBackground(Color.white);
    setOpaque(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    for (int row = 0; row < colCount; row += 1) {
      for (int col = 0; col < rowCount; col += 1) {
        drawRectangle(graphics, col, row);
      }
    }
  }

  private void drawRectangle(Graphics graphics, int column, int row) {
    final int x = (column * GRID_SIZE) + GAP_SIZE;
    final int y = (row    * GRID_SIZE) + GAP_SIZE;

    if (state.isSet(row, column)) {
      graphics.fillRect(x, y, CELL_SIZE, CELL_SIZE);
    } else {
      graphics.drawRect(x, y, CELL_SIZE, CELL_SIZE);
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(
      (colCount * GRID_SIZE) + GAP_SIZE,
      (rowCount * GRID_SIZE) + GAP_SIZE
    );
  }

  public void stepForward() {
    state = state.createNextGeneration();
    repaint();
  }

}