package view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

/**
 * A frame to hold the view.
 */
public class ViewFrame extends JFrame {
  private MapPanel panel;

  public ViewFrame() {
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    panel = new MapPanel();
    this.add(panel);
  }

  public void initialize(List<City> cities) {
    panel.initialize(cities);
    panel.setBackground(Color.BLACK);

    this.pack();
    this.setVisible(true);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1200, 900);
  }

  public void updateMap() {
    this.repaint();
  }
}
