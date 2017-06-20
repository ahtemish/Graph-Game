package model.legacy.noEdges;

import java.util.ArrayList;
import java.util.List;

import model.GraphNode;

/**
 * A graph that allows travel in only one direction.
 */
public class OneWayGraph extends TravellingWithoutEdges {
  private Direction direction;

  public OneWayGraph() {
    this.graph = new ArrayList<>();
    this.currentNode = null;
    this.direction = Direction.forward;
  }

  public OneWayGraph(Direction direction) {
    this.graph = new ArrayList<>();
    this.currentNode = null;
    this.direction = direction;
  }

  public OneWayGraph(List<GraphNode> graph, GraphNode startNode, Direction direction) {
    this.graph = graph;
    this.currentNode = startNode;
    this.direction = direction;

  }

  @Override
  public boolean canMoveTo(String name) {
    if(direction == Direction.forward) {
      if (graph.indexOf(currentNode) == graph.size() - 1) {
        return graph.get(0).getName().equals(name);
      } else {
        return graph.get(graph.indexOf(currentNode) + 1).getName().equals(name);
      }
    } else if (direction == Direction.backward) {
      if (graph.indexOf(currentNode) == 0) {
        return graph.get(graph.size() - 1).getName().equals(name);
      } else {
        return graph.get(graph.indexOf(currentNode) - 1).getName().equals(name);
      }
    } else {
      return false;
    }
  }
}
