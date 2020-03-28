public class QuickSelectForMed {
	
	public static int QuickSelect(int[] arr, int min, int max,int k) { //MODIFIED to return index not value at index
		int pivIndex = partition(arr, min, max); // takes the last element in the arr and puts all values less than that
												// to the left, and values greater than to the right
		
		if (k == pivIndex) {
			return pivIndex; //changed from arr[pivIndex]
		}
		else {
			if (k == arr.length) {
				return arr[max];
			}
			else if (k > pivIndex) {                            // if the kth least element is greater than the pivIndex
				return QuickSelect(arr, pivIndex + 1, max, k);   // that means we do not have enough values to the left
			}                                                     // of the pivIndex
			else {
				return QuickSelect(arr, min, pivIndex - 1, k);
			}
		}
	}
	
	public static int QuickSelectAbs(int[] arr, int min, int max,int k) { //SAme thing as above but calls abs partition
		int pivIndex = partitionAbs(arr, min, max);
		
		if (k == pivIndex) {
			return pivIndex; //changed from arr[pivIndex]
		}
		else {
			if (k == arr.length) {
				return arr[max];
			}
			else if (k > pivIndex) {
				return QuickSelectAbs(arr, pivIndex + 1, max, k);
			}
			else {
				return QuickSelectAbs(arr, min, pivIndex - 1, k);
			}
		}
	}
	
	
	
	
	private static int partition(int[] arr, int start, int end) {
		//CORRECT
		int pivot = arr[end];
		int length = arr.length;
		int j = 0;      //This is gonna be the location that switched with the pivot
		int k = end-1;
		int temp = 0;
		for(int i = 0; i < length-1; i++ ) {
			if(arr[j] < pivot) { //basically if the number is smaller than the pivot, we dont car and move to next index
				j++;
			}
			else {
				while (k > j) {              //Now that we have a number greater than the pivot, we want to find a
					if(arr[k] < pivot) {      //number on the other side of the array that is smaller than the pivot
						temp = arr[k];         //and swap them
						arr[k] = arr[j];
						arr[j] = temp;
					}
					k--;
				}
			}
		}
		temp = arr[end];                //All the values to the left of j are less than the pivot, so the pivot goes
		arr[end] = arr[j];               //at j
		arr[j] = temp;
		return j;
	}

	
	private static int partitionAbs(int[] arr, int start, int end) {
		//CORRECT
		int pivot = arr[end];
		int length = arr.length;
		int j = 0;      //This is gonna be the location that switched with the pivot
		int k = end-1;
		int temp = 0;
		for(int i = 0; i < length-1; i++ ) {
			if(Math.abs(arr[j]) < Math.abs(pivot)) { //basically if the abs val of the number is smaller than the pivot, we dont care and move to next index
				j++;
			}
			else {
				while (k > j) {              //Now that we have a number greater than the pivot, we want to find a
					if(Math.abs(arr[k]) < Math.abs(pivot)) {      //number on the other side of the array that has an absolute value smaller than the pivot
						temp = arr[k];         //and swap them
						arr[k] = arr[j];
						arr[j] = temp;
					}
					k--;
				}
			}
		}
		temp = arr[end];                //All the values to the left of j are less than the pivot, so the pivot goes
		arr[end] = arr[j];               //at j
		arr[j] = temp;
		return j;
	}
}
