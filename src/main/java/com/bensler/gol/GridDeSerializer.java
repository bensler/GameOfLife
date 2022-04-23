package com.bensler.gol;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Deserializes a {@link Grid} from and serializes it into a String representation.
 * <p>
 * Living cells are represented by a <code>X</code> (case insensitive), dead cells by
 * a <code>.</code> (or any other character when reading).
 */
public class GridDeSerializer {

  public final static char LIVING_CELL = 'X';
  public final static char DEAD_CELL   = '.';

  public Grid gridFromString(String[] stringRepresentation) {
    final List<BitSet> rows = new ArrayList<>();
    int columnCount = 0;

    for (String rowStr : stringRepresentation) {
      final BitSet row = new BitSet();
      final int rowLength = rowStr.length();

      rowStr = rowStr.toUpperCase();
      columnCount = Math.max(columnCount, rowLength);
      for (int col = 0; col < rowLength; col++) {
        row.set(col, rowStr.charAt(col) == LIVING_CELL);
      }
      rows.add(row);
    }
    return new Grid(columnCount, rows);
  }

  public List<String> gridToString(Grid grid) {
    final StringBuilder rowBuilder = new StringBuilder(grid.getColumnCount());
    final List<String> rows = new ArrayList<>();

    for (int row = 0; row < grid.getRowCount(); row++) {
      rowBuilder.setLength(0);
      for (int col = 0; col < grid.getColumnCount(); col++) {
        rowBuilder.append(grid.isSet(row, col) ? LIVING_CELL : DEAD_CELL);
      }
      rows.add(rowBuilder.toString());
    }
    return rows;
  }

}
