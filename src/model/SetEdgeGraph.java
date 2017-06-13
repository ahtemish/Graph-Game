package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A graph that allows travel between specific nodes.
 */
public class SetEdgeGraph extends TravellingWithEdges {


  public SetEdgeGraph() {
    this.graph = new ArrayList<>();
    this.currentNode = null;
    this.edges = new ArrayList<>();
  }

  public SetEdgeGraph(List<GraphNode> graph, GraphNode startNode, List<GraphEdge> edges) {
    this.graph = graph;
    this.currentNode = startNode;
    this.edges = edges;

    if (!checkNodesAndEdges()) {
      throw new IllegalArgumentException("Graph node list and edge list do not contain the same nodes.");
    }
  }

  private boolean checkNodesAndEdges() {
    List<GraphNode> edgeNodes = new ArrayList<>();
    for (GraphEdge e : edges) {
      edgeNodes.add(e.getNode());
    }
    return graph.containsAll(edgeNodes) && edgeNodes.containsAll(graph);
  }
}
