package view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import model.City;
import model.GraphEdge;

/**
 * A panel that shows the map.
 */
 class MapPanel extends JPanel {
  private List<City> cities;
  private List<GraphEdge> edges;

  MapPanel() {
    super();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
    for (City c : cities) {
      g2.setColor(c.getColor());
      g2.fillOval(c.getLocation().x, c.getLocation().y, 12, 12);
      g2.drawString(c.getName(), c.getLocation().x, c.getLocation().y-6);
    }
    for (GraphEdge e : edges) {
      Point city1 = null;
      Point city2 = null;
      for (City c : cities) {
        if(e.getNames().contains(c.getName())) {
          if(city1 == null) {
            city1 = c.getLocation();
          } else {
            city2 = c.getLocation();
          }
        }
      }
      g2.drawLine(city1.x+6, city1.y+6, city2.x+6, (int)city2.y+6);
    }
  }

  public String checkPoint(Point mouse) {
    return "Nothing found.";
  }

  void initialize(List<City> cities, List<GraphEdge> edges) {
    this.cities = cities;
    this.edges = edges;
  }
}
