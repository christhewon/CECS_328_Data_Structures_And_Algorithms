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
		double endTime;
		
		randomNums(a, n);
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
		
		n = 1000;
		
		//generating 1000 random numbers
		randomNums(a, n);
		startTime = System.nanoTime();
		MaxHeaps.heapSort(a, n);
		
		endTime = System.nanoTime() - startTime;
		
		for(int i = 0; i < n; i++) {
			System.out.println(a[i] + ", ");
		}
		
		System.out.println("The average running time for heap sort in nanoseconds for 1000 inputs was: " + endTime/1000);
		
		
	//Testing for average running tim of heap sort with an input size of 100
		
		n = 100;
		
		//generating 100 random numbers
		randomNums(a, n);
		startTime = System.nanoTime();
		MaxHeaps.heapSort(a, n);
		endTime = System.nanoTime() - startTime;
		
		for(int i = 0; i < n; i++) {
			System.out.println(a[i] + ", ");
		}
		System.out.println("The average running time for heap sort in nanoseconds for 100 inputs was: " + endTime/100);
		
		//PART B**************************************
		System.out.println("Part B: ");
		randomNums(a, 10);
		MaxHeaps.heapSort(a, 10);
		
		System.out.println("");
		for(int i = 0; i < 10; i++) {
			System.out.println(a[i] + ", ");
		}
		
		
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
}
