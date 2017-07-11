package view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import model.City;
import model.GraphEdge;

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

  public void initialize(List<City> cities, List<GraphEdge> edges) {
    panel.initialize(cities, edges);
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
