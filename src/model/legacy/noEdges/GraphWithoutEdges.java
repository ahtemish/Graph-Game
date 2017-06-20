package model.legacy.noEdges;

import java.util.List;

import model.GraphNode;

/**
 *
 * Specifies a graph that does not have set edges to deal with.
 */
interface GraphWithoutEdges {
  boolean canMoveTo(String name);

  GraphNode getCurrentNode();

  List<GraphNode> getGraph();

  void moveToNode(String name);

  void removeNode(String name);

  void removeNode(int index);

  List<String> getCurrentDestinations();

  void addNode(GraphNode node);

  void addNodeAtPosition(int index, GraphNode node);

  void addNodeBefore(String name, GraphNode node);

  void addNodeAfter(String name, GraphNode node);
}
