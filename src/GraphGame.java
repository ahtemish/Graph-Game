import java.io.InputStreamReader;
import java.util.ArrayList;

import controller.GraphController;
import model.BasicTravelGraph;
import model.GraphNode;
import model.GraphWithEdges;
import model.GraphWithoutEdges;
import model.OneWayGraph;
import model.SetEdgeGraph;
import model.TravelGraph;

/**
 * Runs the game.
 */
public class GraphGame {
  public static void main(String[] args) {
    GraphWithoutEdges graph = new OneWayGraph();
    graph.addNode(new GraphNode("Boston"));
    graph.addNode(new GraphNode("Providence"));
    graph.addNodeAtPosition(2, new GraphNode("Baltimore"));
    graph.addNodeBefore("Boston", new GraphNode("Chicago"));
    graph.addNodeAfter("Boston", new GraphNode("NYC"));

    //  <- Chicago <-> /|Boston|\ <-> NYC <-> Providence <-> Baltimore ->

    GraphWithEdges graph2 = new SetEdgeGraph();
    ArrayList<String> boston = new ArrayList<>();
    boston.add("Providence");
    graph2.addNode(new GraphNode("Boston"), boston);
    ArrayList<String> providence = new ArrayList<>();
    providence.add("Chicago");
    providence.add("Boston");
    providence.add("NYC");
    graph2.addNode(new GraphNode("Providence"), providence);
    ArrayList<String> baltimore = new ArrayList<>();
    baltimore.add("Providence");
    baltimore.add("NYC");
    graph2.addNodeAtPosition(2, new GraphNode("Baltimore"), baltimore);
    ArrayList<String> chicago = new ArrayList<>();
    chicago.add("Providence");
    chicago.add("Baltimore");
    chicago.add("NYC");
    graph2.addNodeBefore("Boston", new GraphNode("Chicago"), chicago);
    ArrayList<String> nyc = new ArrayList<>();
    nyc.add("Boston");
    graph2.addNodeAfter("Boston", new GraphNode("NYC"), nyc);

    InputStreamReader input = new InputStreamReader(System.in);
    GraphController controller = new GraphController(graph, input,
            System.out);

    controller.startGame();
  }
}
