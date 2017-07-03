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
    List<String> dest = new ArrayList<>();

    for (GraphEdge e : edges) {
      if (e.getNodes().get(0).equals(currentNode)) {
        dest.add(e.getNodes().get(1).getName());
      } else if (e.getNodes().get(1).equals(currentNode)) {
        dest.add(e.getNodes().get(0).getName());
      }
    }
    return dest;
  }

  public List<GraphEdge> getEdges() {
    return edges;
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
          throw new IllegalArgumentException("Cannot travel to " + name + " from " + currentNode.getName() + ".");
        }
      }
    } else {
      throw new IllegalArgumentException(name + " does not exist in this graph.");
    }
  }

  public boolean canMoveTo(String name) throws IllegalArgumentException {
    return (getCurrentDestinations().contains(name));
  }

  public void addEdge(String name1, String name2) {
    GraphNode node1 = new GraphNode(name1);
    GraphNode node2 = new GraphNode(name2);
    if (graph.size() == 0) {
      currentNode = node1;
      graph.add(node1);
      graph.add(node2);
      edges.add(new GraphEdge(node1, node2));
    } else {
      if (!nodeInGraph(name1) && !nodeInGraph(name2)) {
        throw new IllegalArgumentException("Neither node is in the graph, cannot add this edge.");
      } else {
        if (!nodeInGraph(name1)) {
          graph.add(node1);
        }
        if (!nodeInGraph(name2)) {
          graph.add(node2);
        }
      }
      edges.add(new GraphEdge(node1, node2));
    }
  }

  public void removeEdge(String name1, String name2) throws IllegalArgumentException {
    int remIndex = 0;
    boolean remove = false;

    if (nodeInGraph(name1) && nodeInGraph(name2)) {
      for (GraphEdge e : edges) {
        if (e.getNodes().contains(new GraphNode(name1)) &&
                e.getNodes().contains(new GraphNode(name2))) {
          remove = true;
          remIndex = edges.indexOf(e);
        }
      }
      if (remove) {
        edges.remove(remIndex);
      } else {
        throw new IllegalArgumentException("No edge exists between these two cities.");
      }
    } else {
      throw new IllegalArgumentException("One of the cities does not exist in this graph.");
    }
  }
}
