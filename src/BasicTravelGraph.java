import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A graph that allows travel forwards and backwards from a node.
 */
public class BasicTravelGraph {
  private List<GraphNode> graph;
  private GraphNode currentNode;

  BasicTravelGraph() {
    this.graph = new ArrayList<>();
    this.currentNode = null;
  }

  BasicTravelGraph(ArrayList<GraphNode> graph, GraphNode startNode) {
    this.graph = graph;
    this.currentNode = startNode;
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

  public void moveToNode(String name) {
    boolean moved = false;

    if (nodeInGraph(name)) {
        if (canMoveTo(name)) {
          currentNode = graph.get(findNodeIndex(name));
          moved = true;
      }
      if (!moved) {
        throw new IllegalArgumentException("Cannot travel to destination node from current node.");
      }
    } else {
      throw new IllegalArgumentException("Named node does not exist in this graph.");
    }
  }

  public GraphNode getCurrentNode() {
    return currentNode;
  }

  public List<GraphNode> getGraph() {
    return graph;
  }

  //-------------------------------------Private Functions------------------------------------------

  private boolean canMoveTo(String name) {
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
}
