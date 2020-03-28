import java.util.Scanner;
public class tester {
	public static void main(String[] args) {
		int n, rand, k;
		int[] arr;
		int[] ans;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a positive integer: ");
		n = input.nextInt();
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			rand = (int)(Math.random() * 200) - 100;
			arr[i] = rand;
			System.out.print(rand + ", ");
		}
		System.out.println("");
		
		
		System.out.println("Please enter a number from 1 to " + n);
		k = input.nextInt();
		ans = new int[k];
		MedianSelect medianSelect = new MedianSelect();
		ans = medianSelect.select(arr, k);
		System.out.println("");
		System.out.println("Ans is: ");
	
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + ", ");
		}
	}
}

