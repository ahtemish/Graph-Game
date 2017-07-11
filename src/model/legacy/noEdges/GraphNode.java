package model.legacy.noEdges;

/**
 * A node for visitable locations.
 */
public class GraphNode {
  private String name;

  public GraphNode(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof GraphNode && ((GraphNode) o).getName().equals(name);
  }
}
