package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class containing methods shared between TravelGraphs that deal with edges.
 */
abstract class TravellingWithEdges implements GraphWithEdges {
  List<GraphNode> graph;
  GraphNode currentNode;
  List<GraphEdge> edges;

  private int findNodeIndex(String name) {
    if (nodeInGraph(name)) {
      for (GraphNode g : graph) {
        if (g.getName().equals(name)) {
          return graph.indexOf(g);
        }
      }
      throw new IllegalArgumentException("Named node does not exist in this graph.");
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

  public List<String> getCurrentDestinations() {
    for (GraphEdge e : edges) {
      if(e.getNode().equals(currentNode)) {
        return e.getVisitable();
      }
    }
    return new ArrayList<>();
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
          throw new IllegalArgumentException("Already at " + name + ".");
        } else {
          throw new IllegalArgumentException("Cannot travel to "+ name + " from " + currentNode.getName() + ".");
        }
      }
    } else {
      throw new IllegalArgumentException(name + " does not exist in this graph.");
    }
  }

  public boolean canMoveTo(String name) throws IllegalArgumentException {
    GraphEdge check = null;
    for (GraphEdge e : edges) {
      if (e.getNode().equals(currentNode)) {
        check = e;
      }
    }
    if (check == null) {
      throw new IllegalArgumentException(currentNode.getName() + " has no known destinations.");
    }

    return check.isVisitable(name);
  }

  public void addNode(GraphNode node, List<String> destinations) {
    if (graph.size() == 0) {
      currentNode = node;
    }
    graph.add(node);
    edges.add(new GraphEdge(node, destinations));
  }

  public void addNodeAtPosition(int index, GraphNode node, List<String> destinations) {
    if (index >= 0 || index < graph.size()) {
      if (graph.size() == 0) {
        currentNode = node;
      }
      graph.add(index, node);
      edges.add(new GraphEdge(node, destinations));
    } else {
      throw new IllegalArgumentException("Index out of bounds.");
    }
  }

  public void addNodeBefore(String name, GraphNode node, List<String> destinations) {
    graph.add(findNodeIndex(name), node);
    edges.add(new GraphEdge(node, destinations));
  }

  public void addNodeAfter(String name, GraphNode node, List<String> destinations) {
    graph.add(findNodeIndex(name) + 1, node);
    edges.add(new GraphEdge(node, destinations));
  }

  public void removeNode(String name) {
    graph.remove(findNodeIndex(name));
  }

  public void removeNode(int index) {
    graph.remove(index);
  }

  public void addConnection(String from, String to) throws IllegalArgumentException {
    if(nodeInGraph(from) && nodeInGraph(to)) {
      for (GraphEdge e: edges) {
        if (e.getNode().equals(graph.get(findNodeIndex(from)))) {
          e.addVisitable(to);
        }
      }
    } else {
      throw new IllegalArgumentException("One of the cities does not exist in this graph.");
    }
  }
}
