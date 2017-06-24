package view;

import java.awt.*;

/**
 * A city that will appear on the map panel.
 */
class City {
  private Point location;
  private String name;

  public City(String name, Point location) {
    this.name = name;
    this.location = location;
  }

  public Point getLocation() {
    return location;
  }

  public String getName() {
    return name;
  }
}
