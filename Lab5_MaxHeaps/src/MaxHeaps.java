public class MaxHeaps {
	/**
	 *
	 * @param arr the array getting heap sorted
	 * @param n the number of indexes of the array to be sorted from 0 to n
	 */
	public static void heapSort(int[] arr, int n) {
		int flag = 0;                //flag will be used to "delete" the last elements of the array
		//int length = arr.length;     // Basically the for loop will not iterate through those elements
		int temp;
		buildMaxHeap(arr, n);
		for(int i = n - 1; i >= 0; i--) { //MIGHT BE INDEX OUT OF BOUNDS
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			//swap(arr, 0, i);
			flag++;
			maxHeapify(arr, 0, flag, n);   // flag is one of the parameters because we want to make sure the children are
										// still "in" the array
		}
		
	}
	
	/**
	 *
	 * @param arr the array that is getting built into a max heap
	 * @param n the number of indexes of the array to be built into a max heap from 0 to n
	 */
	public static void buildMaxHeap(int[] arr, int n){
		for(int i = n/2; i >= 0; i--) { //arr.length/2 because that is index of last internal node.
			maxHeapify(arr, i, 0, n);                 //no need to maxheapify the leaves
		}
	}
	
	/**
	 *
	 * @param arr The array that is being max heapified
	 * @param i The node or index at which we are going to max heapify
	 * @param x The marker used to "delete" the ends of the array after
	 * @param n the number of indexes of the array to be max heapify from 0 to n
	 */
	public static void maxHeapify(int[] arr, int i, int x, int n) {
		int left = 2*i + 1;
		int right = 2*i + 2;
		int max = i;
		int length = n; //arr.length
		int temp;
		if(left < length - x && arr[left] > arr[i]) { // checking if a left child exist and if it is greater than the parent
			max = left;
		}
		if(right < length - x && arr[right] > arr[max]) { // checking if a left child exist and if it is greater than
			max = right;					          // the parent
		}
		if(max != i) { //making sure the parent wasn't greater than the children
			temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
			//swap(arr, max, i);
			maxHeapify(arr, max, x, n);
		}
	}
	
	/**
	 *
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = b;
		arr[b] = temp;
	}
}
