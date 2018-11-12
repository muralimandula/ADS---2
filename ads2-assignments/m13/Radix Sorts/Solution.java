import java.util.Scanner;
import java.util.Arrays;

/**
 * SOlution class.
 */
public final class Solution {

	/**
	 * Constructs the object.
	 */
	private Solution() {
		//Dummy
	}

	/**
	 * Main Method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);

		Quick3string obj = new Quick3string();

		int nStrings = Integer.parseInt(scan.nextLine());
		String[] strArray = new String[nStrings];

		for (int i = 0; i < nStrings; i++) {
			strArray[i] = scan.nextLine();
		}
		obj.sort(strArray);
		System.out.println(Arrays.toString(strArray));
	}
}
