package view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

/**
 * A panel that shows the map.
 */
 class MapPanel extends JPanel {
  private List<City> cities;

  MapPanel() {
    super();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
  }

  public String checkPoint(Point mouse) {
    return "Nothing found.";
  }

  void initialize(List<City> cities) {
    this.cities = cities;
  }
}
