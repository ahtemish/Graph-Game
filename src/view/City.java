package view;

import java.awt.*;

/**
 * A city that will appear on the map panel.
 */
public class City {
  private Point location;
  private String name;
  private Color color;

  public City(String name, Point location) {
    this.name = name;
    this.location = location;
    this.color = Color.cyan;
  }

  public Point getLocation() {
    return location;
  }

  public String getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }
}
