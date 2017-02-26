package model;

/**
 * A node for visitable locations.
 */
public class NodeLocation implements GraphNode {
  private String name;

  public NodeLocation(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name;
  }
}
