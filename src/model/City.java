package model;

import java.awt.*;

/**
 * A city that will appear on the map panel.
 */
public class City {
  private Point location;
  private String name;
  private Color color;
  private boolean current;

  public City(String name, Point location) {
    this.name = name;
    this.location = location;
    this.color = Color.cyan;
    this.current = false;
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

  public boolean isCurrent() {
    return current;
  }

  public void switchCurrent() {
    current = !current;
  }

  @Override
  public String toString() {
    return getName();
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof City && ((City) o).getName().equals(name);
  }
}
