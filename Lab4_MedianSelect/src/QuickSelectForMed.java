public class QuickSelectForMed {
	
	public int QuickSelect(int[] arr, int min, int max,int k) {
		int pivIndex = partition(arr, min, max);
		
		if (k == pivIndex) {
			return arr[pivIndex];
		}
		else {
			if (k == arr.length) {
				return arr[max];
			}
			else if (k > pivIndex) {
				return QuickSelect(arr, pivIndex + 1, max, k);
			}
			else {
				return QuickSelect(arr, min, pivIndex - 1, k);
			}
		}
	}
	
	public int[] QuickSelectMaxNums(int[] arr, int min, int max,int k) {
		double half = arr.length/2.00;
		int pivIndex = partition(arr, min, max);
		int[] maxNums = new int[k];
		int len = arr.length;
		int loc = len - k;
		
		
		if (pivIndex == loc) {
			for (int i = 0; i < k; i++) {
				maxNums[i] = arr[loc];
				loc++;
			}
			return maxNums;
		}
		else {
			if (pivIndex < loc) { //pivIndex < loc
				return QuickSelectMaxNums(arr, pivIndex + 1, max, k);
			}
			else {
				return QuickSelectMaxNums(arr, min, pivIndex - 1, k);
			}
		}
	}
	
	
	
	
	private int partition(int[] arr, int start, int end) {
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
}
