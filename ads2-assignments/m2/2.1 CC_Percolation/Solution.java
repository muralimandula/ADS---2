import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // Unused Constructor.
    }
    /**
     * Main Method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int gridSIze = Integer.parseInt(scan.nextLine());
        Percolation percolateObj = new Percolation(gridSIze);

        while (scan.hasNext()) {

            String[] tokens = scan.nextLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            percolateObj.open(x, y);
        }
        System.out.println(percolateObj.percolates()
            && percolateObj.numberOfOpenSites() != 0);
    }
}
