import java.util.ArrayList;

public class Heap {
	private static ArrayList<Node> arr;
	
	/**
	 * Constructor for Heap
	 */
	public Heap() {
		arr = new ArrayList<Node>();
	}
	
	/**
	 * takes an array and creates a maxHeap which is then sorted
	 * @param n the number of indexes of the array to be sorted from 0 to n
	 */
	public void heapSort(int n) {
		int flag = 0;                //flag will be used to "delete" the last elements of the array
		//int length = arr.length;     // Basically the for loop will not iterate through those elements
		int temp;
		buildMaxHeap(n);
		for(int i = n - 1; i >= 0; i--) { //MIGHT BE INDEX OUT OF BOUNDS
			swap(0, i);
			flag++;
			minHeapify(0, flag, n);   // flag is one of the parameters because we want to make sure the children are
			// still "in" the array
		}
		
	}
	
	/**
	 *  takes an array list and builds a max heap using max heapify
	 * @param n the number of indexes of the array to be built into a max heap from 0 to n
	 */
	public void buildMaxHeap(int n){
		for(int i = n/2; i >= 0; i--) { //arr.length/2 because that is index of last internal node.
			minHeapify(i, 0, n);                 //no need to maxheapify the leaves
		}
	}
	
	/**
	 * takes an array and compares the parent node to its children and sees if a swap is necessary to build a max tree
	 * @param i The node or index at which we are going to max heapify
	 * @param x The marker used to "delete" the ends of the array after
	 * @param n the number of indexes of the array to be max heapify from 0 to n
	 */
	public void minHeapify(int i, int x, int n) {
		int left = 2*i + 1;
		int right = 2*i + 2;
		int min = i;
		int length = n; //arr.length
		int temp;
		if(left < length - x && arr.get(left).getDistance() < arr.get(i).getDistance()) { // checking if a left child exist and if it is greater than the parent
			min = left;
		}
		if(right < length - x && arr.get(right).getDistance() < arr.get(min).getDistance()) { // checking if a left child exist and if it is greater than
			min = right;					          // the parent
		}
		if(min != i) { //Only if parent was less than the children
			swap(min, i);
			minHeapify(min, x, n);
		}
	}
	
	
	public static ArrayList<Node> getArr() {
		return arr;
	}
	
	public Node remove(int i) {
		return getArr().remove(i);
	}
	
	public void add(Node i) {
		getArr().add(i);
	}
	
	public Node get(int i) {
		return arr.get(i);
	}
	
	public int getIndex(Node n) {
		int counter = 0;
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) == n) {
				return counter;
			}
			counter++;
		}
		return -1;
	}
	
	/**
	 * takes elements of an array and swaps them
	 * @param a the first element being swapped
	 * @param b the second element being swapped
	 */
	public void swap(int a, int b) {
		Node temp = arr.get(a);
		arr.set(a,arr.get(b));
		arr.set(b, temp);
	}
	
}
