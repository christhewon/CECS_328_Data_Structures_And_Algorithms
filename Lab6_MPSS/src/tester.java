import java.util.Scanner;

public class tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 0;
		System.out.println("Please enter a number greater than 1");
		n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = (int)(Math.random()*40) - 20;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		
		System.out.println();
		System.out.println("The mpss is: " + Mpss.minimumPositiveSubSequence(arr,0, arr.length - 1));
		
	}
	

	
			/*
		System.out.println("left: ");
		for(int i = mid; i >= 0; i--) {
			System.out.print(sL[i]);
		}
		System.out.println();
		System.out.print("right: ");
		for(int i = mid; i >= 0; i--) {
			System.out.print(sR[i]);
		}
	
		*/
}
