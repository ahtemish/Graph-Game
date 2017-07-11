package model;

import java.awt.*;
import java.awt.geom.IllegalPathStateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Abstract class containing methods shared between TravelGraphs that deal with edges.
 */
abstract class TravellingWithEdges implements GraphWithEdges {
  Map<String, City> graph;
  City currentCity;
  List<GraphEdge> edges;
  Color color;

  private boolean cityInGraph(String name) {
    return graph.containsKey(name);
  }

  public City getCurrentCity() {
    return currentCity;
  }

  public List<City> getGraph() {
    return new ArrayList<>(graph.values());
  }

  public List<String> getCurrentDestinations() {
    List<String> dest = new ArrayList<>();

    for (GraphEdge e : edges) {
      if (e.getCities().get(0).equals(currentCity)) {
        dest.add(e.getCities().get(1).getName());
      } else if (e.getCities().get(1).equals(currentCity)) {
        dest.add(e.getCities().get(0).getName());
      }
    }
    return dest;
  }

  public List<GraphEdge> getEdges() {
    return edges;
  }

  public void moveToCity(String name) {

    if (cityInGraph(name)) {
      if (canMoveTo(name)) {
        currentCity.switchCurrent();
        currentCity = graph.get(name);
        currentCity.switchCurrent();
      } else {
        if (currentCity.getName().equals(name)) {
          throw new IllegalArgumentException("Already in " + name + ".");
        } else {
          throw new IllegalArgumentException("Cannot travel to " + name + " from " + currentCity.getName() + ".");
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
    City city1 = null;
    City city2 = null;
    Random rand = new Random();

    if (graph.isEmpty()) {
      city1 = new City(name1, new Point(rand.nextInt(900), rand.nextInt(675)));
      city2 = new City(name2, new Point(rand.nextInt(900), rand.nextInt(675)));
      currentCity = city1;
      graph.put(name1, city1);
      graph.put(name2, city2);
      edges.add(new GraphEdge(city1, city2));
    } else {
        city1 = graph.get(name1);
        city2 = graph.get(name2);
      if(city1 != null || city2 != null) {
        if (city1 == null) {
          city1 = new City(name1, new Point(rand.nextInt(900), rand.nextInt(675)));
          graph.put(name1, city1);
        }
        if (city2 == null) {
          city2 = new City(name2, new Point(rand.nextInt(900), rand.nextInt(675)));
          graph.put(name2, city2);
        }
      } else {
        throw new IllegalArgumentException("Neither city is in the graph, cannot add this edge.");
      }
      edges.add(new GraphEdge(city1, city2));
    }
  }

  public void removeEdge(String name1, String name2) throws IllegalArgumentException {
    int remIndex = 0;
    boolean remove = false;

    if (cityInGraph(name1) && cityInGraph(name2)) {
      for (GraphEdge e : edges) {
        if (e.getCities().contains(graph.get(name1)) &&
                e.getCities().contains(graph.get(name2))) {
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
