import java.util.Set;
import java.util.HashSet;
import edu.princeton.cs.algs4.In;


public class BoggleSolver {
  // Initializes the data structure using the given array of strings as the dictionary.
  // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)

  private TrieSET wordDict;

  public BoggleSolver(String[] dictionary) {
    wordDict = new TrieSET();

    for (String s : dictionary) {
      wordDict.add(s);
      // twoLetterDict.add(s.substring(0, 2));
    }
  }

  // Returns the set of all valid words in the given Boggle board, as an Iterable.
  public Iterable<String> getAllValidWords(BoggleBoard board) {
    Set<String> validWords = new HashSet<String>();
    if (board == null) {
      throw new NullPointerException("board is null");
    }
    for (int i = 0; i < board.rows(); i++) {
      for (int j = 0; j < board.cols(); j++) {
        boolean[][] marked = new boolean[board.rows()][board.cols()];
        collect(board, i, j, marked, "", validWords);
      }
    }

    return validWords;
  }

  private void collect(BoggleBoard board, int row, int col, boolean[][] marked, String prefix, Set<String> set) {
    if (marked[row][col]) {
      return;
    }

    char letter = board.getLetter(row, col);
    String word = prefix;

    if (letter == 'Q') {
      word += "QU";
    } else {
      word += letter;
    }

    if (!wordDict.hasPrefix(word)) {
      return;
    }

    if (word.length() > 2 && wordDict.contains(word)) {
      set.add(word);
    }

    marked[row][col] = true;

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (i == 0 && j == 0) {
          continue;
        }

        if ((row + i >= 0) && (row + i < board.rows()) && (col + j >= 0) && (col + j < board.cols())) {
          collect(board, row + i, col + j, marked, word, set);
        }
      }
    }

    marked[row][col] = false;
  }


  // Returns the score of the given word if it is in the dictionary, zero otherwise.
  // (You can assume the word contains only the uppercase letters A through Z.)
  public int scoreOf(String word) {
    if (wordDict.contains(word)) {
      switch (word.length()) {
      case 0:
      case 1:
      case 2:
        return 0;
      case 3:
      case 4:
        return 1;
      case 5:
        return 2;
      case 6:
        return 3;
      case 7:
        return 5;
      default:
        return 11;
      }
    } else {
      return 0;
    }
  }
}