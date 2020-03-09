import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input;
		
		//Testing squareRootMethos
		for (int i = 0; i < 3; i++) {
			System.out.println("Please enter an integer");
			input = scan.nextInt();
			System.out.println("The square root is: " + squareRoots(input));
		}
		
		//Testing missingNumber method
		int[] arr = new int[]{0,1,2,3,4,5,6,7,10};
		System.out.println(missingNumber(arr, 10));
		
		
	}
	
	/*
	public static int squareRoot(int n) {
		int half = n/2;
		int quarter = n/4;
		if (n == 1) {
			return 1;
		}
		for (int i = 0; i < half; i++) {
			if (Math.pow(i ,2) > n) {
				return i - 1;
			}
		}
		return 0;
	}*/
	
	public static int squareRoots(int n) {
		int left = 0;
		int right = n;
		int middle = 0;
		boolean wentRight = false;
		while (left <= right) {
			middle = (left + right)/2;
			if (Math.pow(middle,2) == n) {
				return middle;
			}
			if (Math.pow(middle,2) < n) {
				left = middle + 1;
				wentRight = false;
			}
			else {
				right = middle - 1;
				wentRight = true;
				
			}
			
		}
		if (wentRight) {
			return middle - 1;
		}
		return middle;
		
	}
	
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
