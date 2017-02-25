import java.util.ArrayList;
import java.util.Scanner;

/**
 * The actual game.
 */
public class GraphGame {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean exit = false;

    BasicTravelGraph graph = new BasicTravelGraph();
    graph.addNode(new NodeLocation("Boston"));
    graph.addNode(new NodeLocation("NYC"));
    graph.addNode(new NodeLocation("Providence"));
    graph.addNodeAtPosition(2, new NodeLocation("Baltimore"));
    graph.addNodeBefore("Boston", new NodeLocation("Chicago"));

    //  <- Chicago <-> /|Boston|\ <-> NYC <-> Baltimore <-> Providence ->

    while (!exit) {
      System.out.print("\nCurrently in " + graph.getCurrentNode().getName() + ".\n");
      System.out.print(graph.getGraph().toString() + "\n");

      String input;
      if (scan.hasNext()) {
        input = scan.next();
      } else {
        exit = true;
        System.out.print("Game quit prematurely.");
        continue;
      }



      switch(input) {
        case "exit":
          exit = true;
          System.out.println("Quit game.\n");
          break;
        case "goto":
          if (!scan.hasNext()) {
            System.out.print("Please enter the name of the destination.\n");
          }
          String dest = scan.next();

          try {
            graph.moveToNode(dest);
          } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
          }
      }
    }
  }
}
