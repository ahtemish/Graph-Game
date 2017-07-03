package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of nodes that represents the edges between the node and those in the list.
 */
public class GraphEdge {
  private GraphNode node1;
  private GraphNode node2;

  GraphEdge(GraphNode node1, GraphNode node2) {
    this.node1 = node1;
    this.node2 = node2;
  }

  List<GraphNode> getNodes() {
    List<GraphNode> nodes = new ArrayList<>();
    nodes.add(node1);
    nodes.add(node2);
    return nodes;
  }

  public List<String> getNames() {
    List<String> names = new ArrayList<>();
    names.add(node1.getName());
    names.add(node2.getName());
    return names;
  }
}
