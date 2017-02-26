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

  void addNode(GraphNode node);

  void addNodeAtPosition(int index, GraphNode node);

  void addNodeBefore(String name, GraphNode node);

  void removeNode(String name);

  void removeNode(int index);
}
