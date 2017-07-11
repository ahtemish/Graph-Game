package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A graph that allows travel between specific nodes.
 */
public class SetEdgeGraph extends TravellingWithEdges {


  public SetEdgeGraph() {
    this.graph = new HashMap<>();
    this.currentCity = null;
    this.edges = new ArrayList<>();
    this.color = Color.cyan;
  }

  public SetEdgeGraph(Map<String, City> graph, City startCity, List<GraphEdge> edges) {
    this.graph = graph;
    this.currentCity = startCity;
    this.edges = edges;
    this.color = Color.cyan;
  }
}
