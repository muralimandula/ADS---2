import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {

  /**
   * Constructs the object.
   */

  private Solution() {
    /**
     * Unused.
     */
  }
  /**
   * Main Function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    String search = scan.nextLine();
    String[] words = loadWords();

    TST ternaryTrie = new TST();

    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        ternaryTrie.put(words[i].substring(j), i);
      }
    }

    //uses iterable string, since unknown length before search.
    Iterable<String> searchResult = ternaryTrie.keysWithPrefix(search);
    for (String str : searchResult) {
      System.out.println(str);
    }
  }
  /*
   * Loads words.
   *
   * @return     { description_of_the_return_value }
   */
  public static String[] loadWords() {
    In in = new In("/Files/dictionary-algs4.txt");
    String[] words = in.readAllStrings();
    return words;
  }
}
