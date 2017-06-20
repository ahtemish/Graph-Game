package model;

import java.util.List;

/**
 * Specifies a graph that uses edges to determine travelling.
 */
public interface GraphWithEdges {
  boolean canMoveTo(String name);

  GraphNode getCurrentNode();

  List<GraphNode> getGraph();

  void moveToNode(String name);

  void removeNode(String name);

  void removeNode(int index);

  List<String> getCurrentDestinations();

  void addConnection(String from, String to);

  void addNode(GraphNode node, List<String> destinations);

  void addNodeAtPosition(int index, GraphNode node, List<String> destinations);

  void addNodeBefore(String name, GraphNode node, List<String> destinations);

  void addNodeAfter(String name, GraphNode node, List<String> destinations);
}
