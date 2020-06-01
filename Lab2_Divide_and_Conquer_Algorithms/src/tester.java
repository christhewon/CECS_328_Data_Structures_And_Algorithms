import java.util.Scanner;

public class tester {
	public static void main(String[] args) {
		SquareRoot square = new SquareRoot();
		Scanner scan = new Scanner(System.in);
		int input;
		
		//Testing squareRootMethos
		for (int i = 0; i < 3; i++) {
			System.out.println("Please enter an integer");
			input = scan.nextInt();
			System.out.println("The square root is: " + square.squareRoots(input));
		}
		
		//Testing missingNumber method
		int[] arr = new int[]{0,1,2,3,4,5,6,7,10};
		System.out.println(missingNumber(arr, 10));
		
		
	}
	
	
	/**
	 * Takes a sorted array and uses the idea of quickSelect to find the smallest missing number from 0 to m.
	 * @param n - The array that is being searched
	 * @param m - The max value a number in the array can be
	 * @return - The first missing number from the array
	 */
	public static int missingNumber(int[] n, int m) {
		int left = 0;
		int right = n.length-1;
		int middle = 0;
		while (left <= right) {
			middle = (left + right)/2;
			if (n[middle] == middle) {
				left = middle + 1;
			}
			if (n[middle] > middle) {
				right = middle - 1;
			}
		}
		return middle;
	}
	
}
