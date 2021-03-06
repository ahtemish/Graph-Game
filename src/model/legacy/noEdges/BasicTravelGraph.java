package model.legacy.noEdges;

import java.util.ArrayList;
import java.util.List;

/**
 * A graph that allows travel forwards and backwards from a node.
 */
public class BasicTravelGraph extends TravellingWithoutEdges {


  public BasicTravelGraph() {
    this.graph = new ArrayList<>();
    this.currentNode = null;
  }

  public BasicTravelGraph(List<GraphNode> graph, GraphNode startNode) {
    this.graph = graph;
    this.currentNode = startNode;
  }

  @Override
  public boolean canMoveTo(String name) {
    if (graph.indexOf(currentNode) == 0) {
      return graph.get(graph.size() - 1).getName().equals(name)
              || graph.get(graph.indexOf(currentNode) + 1).getName().equals(name);
    } else if (graph.indexOf(currentNode) == graph.size() - 1) {
      return graph.get(graph.indexOf(currentNode) - 1).getName().equals(name)
              || graph.get(0).getName().equals(name);
    } else {
      return graph.get(graph.indexOf(currentNode) - 1).getName().equals(name)
              || graph.get(graph.indexOf(currentNode) + 1).getName().equals(name);
    }
  }
}
