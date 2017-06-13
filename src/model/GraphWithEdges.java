package model;

import java.util.List;

/**
 * Specifies a graph that uses edges to determine travelling.
 */
public interface GraphWithEdges extends TravelGraph {
  void addNode(GraphNode node, List<String> destinations);

  void addNodeAtPosition(int index, GraphNode node, List<String> destinations);

  void addNodeBefore(String name, GraphNode node, List<String> destinations);

  void addNodeAfter(String name, GraphNode node, List<String> destinations);
}
