package model;

import java.util.List;

/**
 * Abstract class containing methods shared between TravelGraphs.
 */
public abstract class Travelling implements TravelGraph {
  List<GraphNode> graph;
  GraphNode currentNode;

  private int findNodeIndex(String name) {
    if (nodeInGraph(name)) {
      for (GraphNode g : graph) {
        if (g.getName().equals(name)) {
          return graph.indexOf(g);
        }
      }
      return 0; // This shouldn't happen due to the check on the node being in this graph.
    } else {
      throw new IllegalArgumentException("Named node does not exist in this graph.");
    }
  }

  private boolean nodeInGraph(String name) {
    for (GraphNode g : graph) {
      if (g.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public GraphNode getCurrentNode() {
    return currentNode;
  }

  public List<GraphNode> getGraph() {
    return graph;
  }

  public void moveToNode(String name) {
    boolean moved = false;

    if (nodeInGraph(name)) {
      if (canMoveTo(name)) {
        currentNode = graph.get(findNodeIndex(name));
        moved = true;
      }
      if (!moved) {
        if (currentNode.getName().equals(name)) {
          throw new IllegalArgumentException("Already at name node.");
        } else {
          throw new IllegalArgumentException("Cannot travel to destination node from current node.");
        }
      }
    } else {
      throw new IllegalArgumentException("Named node does not exist in this graph.");
    }
  }

  public void addNode(GraphNode node) {
    if (graph.size() == 0) {
      currentNode = node;
    }
    graph.add(node);
  }

  public void addNodeAtPosition(int index, GraphNode node) {
    if (index >= 0 || index < graph.size()) {
      if (graph.size() == 0) {
        currentNode = node;
      }
      graph.add(index, node);
    } else {
      throw new IllegalArgumentException("Index out of bounds.");
    }
  }

  public void addNodeBefore(String name, GraphNode node) {
    graph.add(findNodeIndex(name), node);
  }

  public void removeNode(String name) {
    graph.remove(findNodeIndex(name));
  }

  public void removeNode(int index) {
    graph.remove(index);
  }
}
