import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		//PART A*********************************************
		System.out.println("Part A:");
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a positive integer");
		int n = in.nextInt();
		int[] a = new int[1000];    //Would put new int[n] but later in the code need to test a avg run time for input
		double startTime;           //size 1000 and we are not allowed to define new arrays
		double endTime;             //Changed methods to take in another parameter which was the length of the array
		randomNums(a, n);           //Now I use an array of size 1000 but use only up to the indexes I need
		MaxHeaps.heapSort(a, n);    
		
		
		MaxHeaps.maxHeapify(a, 0, 0, n);
		for(int i = 0; i < n; i++) {
			System.out.println(a[i] + ", ");
		}
		
		System.out.println("");
		//Printing our sorted array
		for(int i = 0; i < n; i++) {
			System.out.println(a[i] + ", ");
		}
		
		
	//Testing for average running time with an input size of 1000
		int totalTime = 0;
		int heapTime;
		int selectionTime;
		n = 1000;

		for(int i = 0; i < 100; i++) {
			randomNums(a, n);
			startTime = System.nanoTime();
			MaxHeaps.heapSort(a, n);
			endTime = System.nanoTime() - startTime;
			totalTime += endTime;
		}
		heapTime = totalTime/100;
		
		for(int i = 0; i < n; i++) {
			System.out.println(a[i] + ", ");
		}
		System.out.println("The average running time for heap sort in nanoseconds for 1000 inputs was: " + heapTime);
	
	//Testing Selection Sort
		totalTime = 0;
		for(int i = 0; i < 100; i++) {
			randomNums(a, n);
			startTime = System.nanoTime();
			Tester.selectionSortTime(a, n);
			endTime = System.nanoTime() - startTime;
			totalTime += endTime;
		}
		selectionTime = totalTime/100;
		System.out.println("");
		System.out.println("The average running time for selection sort in nanoseconds for 1000 inputs was: " + selectionTime);
		
		
		System.out.println("Heap time was faster by: " + (selectionTime - heapTime) + " nanoseconds");
	}
	
	/**
	 * Fills an array with random integers from -100 to 100
	 * @param a the array being filled
	 * @param n the number of indexes being filled
	 */
	public static void randomNums(int[] a, int n) { // maybe dont need n?
		int rand = 0;
		for(int i = 0; i < n; i++) {
			rand = (int)(Math.random() * 200) - 100;
			a[i] = rand;
			System.out.print(rand + ", ");
		}
	}
	
	public static void selectionSortTime(int[] arr, int n) {
		int length = n;
		for (int i = 0; i < length-1; i++)
		{
			int min = i;
			for (int j = i+1; j < length; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			MaxHeaps.swap(arr, min, i);
		}
	}
}
