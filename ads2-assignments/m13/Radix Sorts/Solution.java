import java.util.Scanner;
import java.util.Arrays;

public final class Solution {

	private Solution() {
		//Dummy
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Quick3string obj = new Quick3string();

		int nStrings = Integer.parseInt(scan.nextLine());
		String[] strArray = new String[nStrings];

		for(int i = 0; i < nStrings; i++) {
			strArray[i] = scan.nextLine();
		}
		obj.sort(strArray);
		System.out.println(Arrays.toString(strArray));
	}
}