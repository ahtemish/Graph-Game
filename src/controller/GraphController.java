package controller;

import java.io.IOException;
import java.util.Scanner;

import model.TravelGraph;

/**
 * Controls how a player interacts with graphs.
 */
public class GraphController {
  private TravelGraph graph;
  private Readable read;
  private Appendable app;

  public GraphController(TravelGraph graph, Readable read, Appendable app) {
    this.graph = graph;
    this.read = read;
    this.app = app;
  }


  public void startGame() {
    String message;

    try {
      Scanner scan = new Scanner(read);
      boolean exit = false;

      while (!exit) {
        message = "\nCurrently in " + graph.getCurrentNode().getName() + ".\n" +
                graph.getGraph().toString() + "\n";
        app.append(message);

        String input;
        if (scan.hasNext()) {
          input = scan.next();
        } else {
          exit = true;
          app.append("\nGame quit prematurely.");
          continue;
        }


        switch (input) {
          case "exit":
          case "quit":
            exit = true;
            app.append("\nQuit game.\n");
            break;
          case "goto":
            if (!scan.hasNext()) {
              app.append("\nPlease enter the name of the destination.\n");
            }
            String dest = scan.next();

            try {
              graph.moveToNode(dest);
            } catch (IllegalArgumentException e) {
              message = "\n" + e.getLocalizedMessage() + "\n";
              app.append(message);
            }
            break;
          default:
            app.append("\nCommand not recognized.\n");
        }
      }
    } catch (IOException e) {
      // Hopefully won't happen.
    }
  }
}
