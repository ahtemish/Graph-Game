package model;

import java.util.List;

/**
 * A list of nodes that represents the edges between the node and those in the list.
 */
class GraphEdge {
  private GraphNode node;
  private List<String> visitable;

  GraphEdge(GraphNode node, List<String> visitable) {
    this.node = node;
    this.visitable = visitable;
  }

  GraphNode getNode() {
    return node;
  }

  boolean isVisitable(String destination) {
    return visitable.contains(destination);
  }

  List<String> getVisitable() {
    return visitable;
  }

  void addVisitable(String city) {
    if(!visitable.contains(city)) {
      visitable.add(city);
    }
  }

  void removeVisitable(String city) {
    if(visitable.contains(city)) {
      visitable.remove(city);
    }
  }
}
