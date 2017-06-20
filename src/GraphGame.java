import java.io.InputStreamReader;
import java.util.ArrayList;

import controller.GraphController;
import model.GraphNode;
import model.GraphWithEdges;
import model.SetEdgeGraph;

/**
 * Runs the game.
 */
public class GraphGame {
  public static void main(String[] args) {

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
    GraphController controller = new GraphController(graph2, input,
            System.out);

    controller.startGame();
  }
}
