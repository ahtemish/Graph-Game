package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of nodes that represents the edges between the node and those in the list.
 */
public class GraphEdge {
  private City city1;
  private City city2;

  GraphEdge(City city1, City city2) {
    this.city1 = city1;
    this.city2 = city2;
  }

  List<City> getCities() {
    List<City> cities = new ArrayList<>();
    cities.add(city1);
    cities.add(city2);
    return cities;
  }

  public List<String> getNames() {
    List<String> names = new ArrayList<>();
    names.add(city1.getName());
    names.add(city2.getName());
    return names;
  }
}
