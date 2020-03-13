import java.util.Scanner;

public class tester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[] {5,6,214,32,53,2,78};
		System.out.println("Enter a number from 1 to the length of the array: ");
		int userNum = input.nextInt();
		
		
		QuickSelect quick = new QuickSelect();
		
		int ans = quick.QuickSelect(arr, 0, arr.length - 1, userNum);
		System.out.println("The answer is: " + ans);
	}
}
