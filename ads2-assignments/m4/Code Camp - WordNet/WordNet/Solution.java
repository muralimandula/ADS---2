import java.util.Scanner;
/**
 * class solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    	//dummy constructor.
    }
    /**
     * Main Method.
     *
     * @param      args  The arguments
     */
    // time complexity : 1.
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = "Files" + "\\" + scan.nextLine();
        String m = "Files" + "\\" + scan.nextLine();
        String word = scan.nextLine();
        try {
            WordNet wordnet = new WordNet(n, m);
            if (word.equals("Graph")) {
                wordnet.display();
            } else if (word.equals("Queries")) {
                while (scan.hasNextLine()) {
                    String[] tokens = scan.nextLine().split(" ");
                    String str = wordnet.sap(tokens[0], tokens[1]);
                    int id = wordnet.distance(tokens[0], tokens[1]);
                    System.out.println("distance = " + id
                        + ", ancestor = " + str);
                }
            }
        } catch (Exception e) {
            System.out.println("IllegalArgumentException");
        }
    }
}
