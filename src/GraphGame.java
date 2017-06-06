import java.io.InputStreamReader;

import controller.GraphController;
import model.BasicTravelGraph;
import model.Direction;
import model.NodeLocation;
import model.OneWayGraph;
import model.TravelGraph;

/**
 * Runs the game.
 */
public class GraphGame {
  public static void main(String[] args) {
    TravelGraph graph = new BasicTravelGraph();
    graph.addNode(new NodeLocation("Boston"));
    graph.addNode(new NodeLocation("NYC"));
    graph.addNode(new NodeLocation("Providence"));
    graph.addNodeAtPosition(2, new NodeLocation("Baltimore"));
    graph.addNodeBefore("Boston", new NodeLocation("Chicago"));

    //  <- Chicago <-> /|Boston|\ <-> NYC <-> Baltimore <-> Providence ->

    InputStreamReader input = new InputStreamReader(System.in);
    GraphController controller = new GraphController(graph, input,
            System.out);

    controller.startGame();
  }
}
