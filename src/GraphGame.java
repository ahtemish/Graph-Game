import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.GraphController;
import model.GraphWithEdges;
import model.SetEdgeGraph;

/**
 * Runs the game.
 */
public class GraphGame {
  public static void main(String[] args) {

    GraphWithEdges graph = new SetEdgeGraph();
    graph.addEdge("Boston", "Providence");
    graph.addEdge("Providence", "Chicago");
    graph.addEdge("Providence", "NYC");
    graph.addEdge("Baltimore", "Providence");
    graph.addEdge("Baltimore", "NYC");
    graph.addEdge("Chicago", "Baltimore");
    graph.addEdge("Chicago", "NYC");
    graph.addEdge("NYC", "Boston");

    FileWriter log = null;
    try {
      log = new FileWriter("log.txt", true);
    } catch (IOException e) {
      System.out.print(e.getLocalizedMessage());
    }




    InputStreamReader input = new InputStreamReader(System.in);
    GraphController controller = new GraphController(graph, input, log);

    controller.startGame();
  }
}
