package com.bensler.gol;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

/** World model. Immutable. */
public class Grid {

  private final int columnCount;

  protected final List<BitSet> rows;

  Grid(int aColumnCount, List<BitSet> rowsTemplate) {
    columnCount = aColumnCount;
    rows = new ArrayList<>(rowsTemplate);
  }

  public Grid(Grid template) {
    this(
      template.columnCount,
      template.rows.stream().map(bitSet -> BitSet.valueOf(bitSet.toByteArray())).collect(Collectors.toList())
    );
  }

  public Grid createNextGeneration() {
    final int rowCount = getRowCount();
    final List<BitSet> newRows = new ArrayList<>(rowCount);

    for (int row = 0; row < rowCount; row++) {
      final int aColumnCount = columnCount;
      final BitSet newRow = new BitSet(aColumnCount);

      for (int col = 0; col < aColumnCount; col++) {
        newRow.set(col, calculateFutureState(row, col));
      }
      newRows.add(newRow);
    }
    return new Grid(columnCount, newRows);
  }

  public int getColumnCount() {
    return columnCount;
  }

  public int getRowCount() {
    return rows.size();
  }

  public BitSet getRow(int row) {
    return (BitSet)rows.get(row).clone();
  }

  private boolean calculateFutureState(int row, int col) {
    final int livingNeighborCount = countLivingNeighbors(row, col);
    final boolean isSet = isSet(row, col);

    if (isSet) {
      return ((livingNeighborCount == 2) || (livingNeighborCount == 3));
    } else {
      return (livingNeighborCount == 3);
    }
  }

  private int countLivingNeighbors(int row, int col) {
    int livingNeighborCount = rows.get(row).get(col) ? -1 : 0;

    for (int probeRow = -1; probeRow <= 1; probeRow++) {
      for (int probeCol = -1; probeCol <= 1; probeCol++) {
        livingNeighborCount += (isSetUnrestricted(row + probeRow, col + probeCol) ? 1 : 0);
        if (livingNeighborCount > 3) {
          return livingNeighborCount;
        }
      }
    }
    return livingNeighborCount;
  }

  /**
   * Same like {@link #isSet(int, int)} but simply returns <code>false</code> for row/col combinations
   * being out of range.
   */
  private boolean isSetUnrestricted(int row, int col) {
    final boolean validCell = !((row < 0) || (row >= getRowCount()) || (col < 0) || (col >= columnCount));

    return validCell && rows.get(row).get(col);
  }

  public boolean isSet(int row, int col) {
    return (rows.size() > row) && rows.get(row).get(col);
  }

  @Override
  public int hashCode() {
    return rows.hashCode() + columnCount;
  }

  @Override
  public boolean equals(Object obj) {
    return ((obj != null) && obj.getClass().equals(getClass()) && equals((Grid)obj));
  }

  public boolean equals(Grid otherGrid) {
    return (otherGrid.columnCount == columnCount) && otherGrid.rows.equals(rows);
  }

}
