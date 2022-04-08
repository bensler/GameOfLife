package com.bensler.gol;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class GridDeSerializerTest {

  @Test
  public void testDeSerialize() {
    final GridDeSerializer deSerializer = new GridDeSerializer();
    final String[] stringRepresentation = Main.PULSATOR;
    final Grid grid = deSerializer.gridFromString(stringRepresentation);

    assertEquals(List.of(stringRepresentation), deSerializer.gridToString(grid));
  }

}
