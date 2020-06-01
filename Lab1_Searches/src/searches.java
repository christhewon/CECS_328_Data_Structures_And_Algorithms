import java.util.Arrays;
import java.util.Scanner;

public class searches {
	public static void main(String[] args) {
		//Average Case Scenario
		int n, key, rand;
		int numbers;
		long start, end;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a positive integer");
		n = input.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0;  i < n; i++) {
			numbers = (int)(Math.random() * 2000) - 1000;
			arr[i] = numbers;
		}
		Arrays.sort(arr);
		
		//Linear Search Average Time
		start = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			rand = (int)(Math.random() * n);
			key = arr[rand];
			linearSearch(arr,key);
		}
		end = System.nanoTime() - start;
		System.out.println("The average running time for linear search in nanoseconds was: " + end/100);
		
		//Binary Search Average Time
		start = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			rand = (int)(Math.random() * n);
			key = arr[rand];
			binarySearch(arr,key);
		}
		end = System.nanoTime() - start;
		System.out.println("The average running time for binary search in nanoseconds was: " + end/100);
		
		
		//Worst Case Scenario
		input = new Scanner(System.in);
		System.out.println("Please enter a positive integer");
		n = input.nextInt();
		arr = new int[n];
		
		for (int i = 0;  i < n; i++) {
			numbers = (int)(Math.random() * 2000) - 1000;
			arr[i] = numbers;
		}
		Arrays.sort(arr);
		
		//Linear Search Worst Case Scenario
		start = System.nanoTime();
		linearSearch(arr, 5000);
		end = System.nanoTime() - start;
		System.out.println("The worst case running time for linear search in nanoseconds was: " + end + "ns");
		
		//Binary Search Worst Case Scenario
		start = System.nanoTime();
		binarySearch(arr, 5000);
		end = System.nanoTime() - start;
		System.out.println("The worst case running time for binary search in nanoseconds was: " + end + "ns");
		
		//Calculating time to run one line of code
		start = System.nanoTime();
		int[] arr2 = {1,2};
		binarySearch(arr2, 1);
		end = System.nanoTime() - start;
		

		double oneLine = end/(3 + (8 * (Math.log(arr2.length))));
		System.out.println("One line time equals: " + end + "ns");
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean linearSearch(int[] arr,int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length-1;
		int middle = 0;
		while (left <= right) {
			middle = (left + right)/2;
			if (arr[middle] == key) {
				return true;
			}
			if (arr[middle] < key) {
				left = middle + 1;
			}
			else {
				right = middle - 1;
			}
			
		}
		return false;
	}
	
	
}

/*
Part B
	#4
		n * t = total time
		12 * t = 1841
		t = 153
		
	#5
		10^15 * 153 = total time
 */
