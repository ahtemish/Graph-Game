package controller;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.GraphWithEdges;
import view.City;
import view.ViewFrame;

/**
 * Controls how a player interacts with graphs.
 */
public class GraphController {
  private GraphWithEdges graph;
  private Readable read;
  private FileWriter app;
  private MouseHandler mHandler;
  private ViewFrame view;

  public GraphController(GraphWithEdges graph, Readable read, FileWriter app) {
    this.graph = graph;
    this.read = read;
    this.app = app;
    this.view = new ViewFrame();
  }


  public void startGame() {
    String message;

    try {
      List<City> cities = new ArrayList<>();
      Random rand = new Random();
      cities.addAll(graph.getGraph().stream().map(g -> new City(g.getName(),
              new Point(rand.nextInt(900), rand.nextInt(675)))).collect(Collectors.toList()));

      view.initialize(cities, graph.getEdges());
      mHandler = new MouseHandler();
      view.addMouseListener(mHandler);
      Scanner scan = new Scanner(read);
      boolean exit = false;

      app.append("\nType 'help' for commands.\n");

      while (!exit) {
        message = "\nCurrently in " + graph.getCurrentNode().getName() + ".\n" +
                graph.getGraph().toString() + "\n";
        app.append(message);
        app.flush();

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
            app.append("\nquit - stop the game.\ngoto (city name) - move to the named city.\n" +
                    "help - brings up this page.\nwhere - lists the cities visitable from the" +
                    " current city.\nconnect (from) (to) - make a connection from the first city" +
                    " to the second one.\n");
            break;
          case "where":
            message = "\n" + graph.getCurrentDestinations().toString() + "\n";
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
              graph.addEdge(first, second);
              message = "\nConnected " + first + " to " + second + "!\n";
              app.append(message);
            } catch (IllegalArgumentException e) {
              message = "\n" + e.getLocalizedMessage() + "\n";
              app.append(message);
            }
            break;
          case "disconnect":
            if (!scan.hasNext()) {
              app.append("Please enter the city you want to disconnect from.");
            }
            String firstDis = scan.next();

            if (!scan.hasNext()) {
              app.append("Please enter the city you want to disconnect to.");
            }
            String secondDis = scan.next();

            try {
              graph.removeEdge(firstDis, secondDis);
              message = "\nDisconnected " + firstDis + " and " + secondDis + ".\n";
              app.append(message);
            } catch (IllegalArgumentException e) {
              message = "\n" + e.getLocalizedMessage() + "\n";
              app.append(message);
            }
            break;
          default:
            app.append("\nCommand not recognized.\n");
        }
        app.flush();
      }
    } catch (IOException e) {
      // Hopefully won't happen.
    }
  }


}
