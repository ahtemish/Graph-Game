package model;

/**
 *
 * Specifies a graph that does not have set edges to deal with.
 */
public interface GraphWithoutEdges extends TravelGraph {
  void addNode(GraphNode node);

  void addNodeAtPosition(int index, GraphNode node);

  void addNodeBefore(String name, GraphNode node);

  void addNodeAfter(String name, GraphNode node);
}
