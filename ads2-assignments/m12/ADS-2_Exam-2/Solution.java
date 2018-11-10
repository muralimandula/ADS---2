import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {

  /**
   * Constructs the object.
   */
  private Solution() {
    /**
     * Unused.
     */
  }

  /**
   * Main method.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {

    Scanner scan = new Scanner(System.in);
    int vertices = Integer.parseInt(scan.nextLine());
    int edges = Integer.parseInt(scan.nextLine());

    EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(vertices);

    for (int i = 0; i < edges; i++) {

      String[] routeInfo = scan.nextLine().split(" ");

      //Creates edge objects.
      Edge edge = new Edge(Integer.parseInt(routeInfo[0]),
                            Integer.parseInt(routeInfo[1]),
                                Integer.parseInt(routeInfo[2]));

      ewgraph.addEdge(edge); // adding edges to weighted graph.
    }


    String caseToGo = scan.nextLine();

    switch (caseToGo) {
    case "Graph":

      System.out.println(ewgraph);
      break;

    case "DirectedPaths":

      String[] dpQuery = scan.nextLine().split(" ");
      DijkstraUndirectedSP djsp = new DijkstraUndirectedSP(ewgraph,
                                                     Integer.parseInt(dpQuery[0]));
      if (djsp.hasPathTo(Integer.parseInt(dpQuery[1]))) {
        System.out.println(djsp.distTo(Integer.parseInt(dpQuery[1])));
      } else {
        System.out.println("No Path Found.");
      }
      break;

    case "ViaPaths":

      String[] viaQuery = scan.nextLine().split(" ");

      DijkstraUndirectedSP sp1 = new DijkstraUndirectedSP(ewgraph,
                                                     Integer.parseInt(viaQuery[0]));
      DijkstraUndirectedSP sp2 = new DijkstraUndirectedSP(ewgraph,
                                                     Integer.parseInt(viaQuery[1]));
      String string = "";

      if (!(sp1.hasPathTo(Integer.parseInt(viaQuery[2])))) {

        System.out.println("No Path Found.");
      } else {

        int i = 0;
        System.out.println(sp1.distTo(Integer.parseInt(viaQuery[1])) +
                                 sp2.distTo(Integer.parseInt(viaQuery[2])));

        //printing vertices of the shortest path.
        for (Integer vertex : sp1.pathTo(Integer.parseInt(viaQuery[1]))) {
          string += vertex;
        }

        for (Integer vertex : sp2.pathTo(Integer.parseInt(viaQuery[2]))) {
          if (i != 0) {
            string += vertex;
          }
          i += 1;
        }
        System.out.println(string);
      }
      break;

    default:
      break;
    }

  }
}