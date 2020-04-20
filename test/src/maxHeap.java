import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class maxHeap {
	public static void main(String[] args) {
		System.out.println("Part A:");
		System.out.println("Enter a positive integer: ");
		Scanner in = new Scanner(System.in);
		int integer = in.nextInt();
		
		Random rand = new Random();
		int a[] = new int[integer];
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt((100 - (-100)) + 1) + (-100);
		}
		
		
		System.out.println("Array: " + Arrays.toString(a));
		heap_sort(a);
		System.out.println("Sorted Array: " + Arrays.toString(a));
		
		long begin, stop;
//        double heapSortTime = 0;
//        begin = System.nanoTime();
//        heap_sort(a);
//        stop = System.nanoTime();
//        heapSortTime += (stop - begin);
//        System.out.println();
//
//        System.out.println("The running time average for the heap sort when n = 1000 is: " + heapSortTime/100);
		
		double selectionSortTime = 0;
		begin = System.nanoTime();
		selectionSort(a);
		stop = System.nanoTime();
		selectionSortTime += (stop - begin);
		System.out.println();
		
		System.out.println("The running time average for the selection sort is: " + selectionSortTime/100);
//
//
//        System.out.println("Part B:");
//        int array[] = new int[10];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = rand.nextInt((100 - (-100)) + 1) + (-100);
//        }
//        System.out.println("Array: " + Arrays.toString(array));
//        heap_sort(array);
//        System.out.println("Sorted Array: " + Arrays.toString(array));
	}
	
	public static void heap_sort(int[] array) {
		build_Maxheap(array);
		int n = array.length;
//        for (int i = n/2 - 1; i >= 0; i--)
//            max_heapify(array, i , n);
		for (int i = n - 1; i >= 0; i--) {
			swap(array, 0, i);
			max_heapify(array, 0, i);
		}
	}
	
	public static void build_Maxheap(int[] array) {
		int n = array.length;
		for (int i = n/2; i >= 0; i--) {
//            swap(array, 0, i);
			max_heapify(array, i , n);
		}
	}
	

	
	public static void max_heapify(int[] array, int i, int length) {
		int left = 2*i + 1;
		int right = 2*i + 2;
		int max = i;
		if (left < length && array[left] > array[max]) {
			max = left;
		}
		if (right < length && array[right] > array[max]) {
			max = right;
		}
		if (max != i) {
			swap(array, i, max);
			max_heapify(array, max, length);
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void selectionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
					swap(array, 0, i);
				}
			}
		}
		
	}
}
