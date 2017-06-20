package controller;

import java.io.IOException;
import java.util.Scanner;

import model.GraphWithEdges;

/**
 * Controls how a player interacts with graphs.
 */
public class GraphController {
  private GraphWithEdges graph;
  private Readable read;
  private Appendable app;

  public GraphController(GraphWithEdges graph, Readable read, Appendable app) {
    this.graph = graph;
    this.read = read;
    this.app = app;
  }


  public void startGame() {
    String message;

    try {
      Scanner scan = new Scanner(read);
      boolean exit = false;

      app.append("\nType 'help' for commands.\n");

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
          case "help":
            app.append("quit - stop the game.\ngoto (city name) - move to the named city.\n" +
                    "help - brings up this page.\nwhere - lists the cities visitable from the" +
                    " current city.\nconnect (from) (to) - make a connection from the first city" +
                    " to the second one.\n");
            break;
          case "where":
            message = graph.getCurrentDestinations().toString() + "\n";
            app.append(message);
            break;
          case "connect":
            if (!scan.hasNext()) {
              app.append("Please enter the city you want to connect from.");
            }
            String first = scan.next();

            if (!scan.hasNext()) {
              app.append("Please enter the city you want to connect to.");
            }
            String second = scan.next();

            try {
              graph.addConnection(first, second);
              message = "\nConnected " + first + " to " + second + "!\n";
              app.append(message);
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
