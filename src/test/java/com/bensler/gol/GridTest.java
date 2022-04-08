package com.bensler.gol;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class GridTest {

  private final GridDeSerializer deSerializer;

  public GridTest() {
    deSerializer = new GridDeSerializer();
  }

  @Test
  public void testBlinker() {
    testGridSequence(List.of(
      deSerializer.gridFromString(Main.BLINKER),
      deSerializer.gridFromString(new String[] {
        ".....",
        "..X..",
        "..X..",
        "..X..",
        ".....",
      })
    ));
  }

  @Test
  public void testClock() {
    testGridSequence(List.of(
      deSerializer.gridFromString(Main.CLOCK),
      deSerializer.gridFromString(new String[] {
        "......",
        "..X...",
        "..X.X.",
        ".X.X..",
        "...X..",
        "......",
      })
    ));
  }

  @Test
  public void testToad() {
    testGridSequence(List.of(
      deSerializer.gridFromString(Main.TOAD),
      deSerializer.gridFromString(new String[] {
        "......",
        "..X...",
        "..XX..",
        "..XX..",
        "...X..",
        "......",
      })
    ));
  }

  @Test
  public void testBipole() {
    testGridSequence(List.of(
      deSerializer.gridFromString(Main.BIPOLE),
      deSerializer.gridFromString(new String[] {
        "......",
        ".XX...",
        ".XX...",
        "...XX.",
        "...XX.",
        "......",
      })
    ));
  }

  @Test
  public void testTripole() {
    testGridSequence(List.of(
      deSerializer.gridFromString(Main.TRIPOLE),
      deSerializer.gridFromString(new String[] {
        ".......",
        ".XX....",
        ".X.X...",
        ".......",
        "...X.X.",
        "....XX.",
        ".......",
      })
    ));
  }

  // @Test TODO
  public void testPulsator() {
    testGridSequence(List.of(
      deSerializer.gridFromString(Main.PULSATOR),
      deSerializer.gridFromString(new String[] {
        "..................",
        "..................",
        "..................",
        "..................",
        "..X..XX....XX..X..",
        ".X...XXX..XXX...X.",
        "..X..XX....XX..X..",
        "..................",
        "..................",
        "..................",
        "..................",
      })
    ));
  }

  // @Test TODO
  public void testFountain() {
    testGridSequence(List.of(
      deSerializer.gridFromString(Main.FOUNTAIN),
      deSerializer.gridFromString(new String[] {
        "...........",
        "..X.....X..",
        ".X.X...X.X.",
        "...XX.XX...",
        "..XX...XX..",
        "...XX.XX...",
        "..XX...XX..",
        "...........",
        "...........",
        "...........",
      })
    ));
  }

  // @Test TODO
  public void testOctagon() {
    testGridSequence(List.of(
      deSerializer.gridFromString(Main.OCTAGON),
      deSerializer.gridFromString(new String[] {
        "..........",
        "..........",
        "....XX....",
        "..........",
        "..X....X..",
        "..X....X..",
        "..........",
        "....XX....",
        "..........",
        "..........",
      })
    ));
  }

  private void testGridSequence(List<Grid> grids) {
    int step = 0;

    Grid previous = grids.get(step++);
    while (step < grids.size()) {
      final Grid next = grids.get(step++);
      final Grid calculatedNext = new Grid(previous).createNextGeneration();

      try {
        assertEquals(calculatedNext, next);
      } catch (AssertionError ae) {
        throw new AssertionError(String.format(
          "step %s -> %s\nprevious:\n%s\nexpected:\n%s\ngot:\n%s",
          (step - 1), step,
          String.join("\n", deSerializer.gridToString(previous)),
          String.join("\n", deSerializer.gridToString(next)),
          String.join("\n", deSerializer.gridToString(calculatedNext))
        ));
      }
      previous = next;
    }
  }

  @Test
  public void testStatic1() {
    testStatic(deSerializer.gridFromString(Main.STATIC_1));
  }

  @Test
  public void testStatic2() {
    testStatic(deSerializer.gridFromString(Main.STATIC_2));
  }

  @Test
  public void testStatic3() {
    testStatic(deSerializer.gridFromString(Main.STATIC_3));
  }

  @Test
  public void testStatic4() {
    testStatic(deSerializer.gridFromString(Main.STATIC_4));
  }

  @Test
  public void testStatic5() {
    testStatic(deSerializer.gridFromString(Main.STATIC_5));
  }

  @Test
  public void testStatic6() {
    testStatic(deSerializer.gridFromString(Main.STATIC_6));
  }

  private void testStatic(Grid grid) {
    final Grid calculatedNext = grid.createNextGeneration();

    assertEquals(calculatedNext, grid);
  }

}
