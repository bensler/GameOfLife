package com.bensler.gol;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/** Container for this Apps whole UI. */
public class AppPanel extends JPanel {

  AppPanel() {
    super(new FormLayout(
      "5dlu, f:p:g, 5dlu, p, 5dlu", // columns
      "5dlu, f:p:g, 5dlu"           // row
    ));
    final GridPanel gridPanel = new GridPanel(20, 20, new GridDeSerializer().gridFromString(Main.GLIDER));
    final CellConstraints cc = new CellConstraints();

    add(new JScrollPane(gridPanel),    cc.rc(2, 2));
    add(createControlPanel(gridPanel), cc.rc(2, 4));
  }

  private JPanel createControlPanel(GridPanel gridPanel) {
    final JPanel controlPanel = new JPanel(new FormLayout(
      "p, 5dlu, f:p:g", // columns
      "p"               // row
    ));
    final CellConstraints cc = new CellConstraints();
    final JButton stepForwardButton = new JButton("Step");

    stepForwardButton.addActionListener(actionEvent -> gridPanel.stepForward());
    controlPanel.add(stepForwardButton, cc.rcw(1, 1, 3));
    return controlPanel;
  }

}