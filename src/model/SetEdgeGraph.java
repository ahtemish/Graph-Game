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
  }
}
