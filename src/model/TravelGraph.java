package model;

import java.util.List;

/**
 * An interface for graphs.
 */
public interface TravelGraph {
  boolean canMoveTo(String name);

  GraphNode getCurrentNode();

  List<GraphNode> getGraph();

  void moveToNode(String name);

  void removeNode(String name);

  void removeNode(int index);

  List<String> getCurrentDestinations();
}
