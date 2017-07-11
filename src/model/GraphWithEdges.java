package model;

import java.util.List;

/**
 * Specifies a graph that uses edges to determine travelling.
 */
public interface GraphWithEdges {
  boolean canMoveTo(String name);

  City getCurrentCity();

  List<City> getGraph();

  List<GraphEdge> getEdges();

  void moveToCity(String name);

  void removeEdge(String name1, String name2);

  List<String> getCurrentDestinations();

  void addEdge(String name1, String name2);
}
