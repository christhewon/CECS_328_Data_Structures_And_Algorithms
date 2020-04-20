public class QuickSelect {
	/**
	 * 
	 * @param arr
	 * @param min
	 * @param max
	 * @param k
	 * @return
	 */
	public int QuickSelect(int[] arr, int min, int max,int k) {
		int pivIndex = partitions(arr, min, max);
		
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
	
	/**
	 *
	 * @param arr
	 * @param min
	 * @param max
	 * @param k
	 * @return
	 */
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
		
		
		
		//******Failed Attempts at QuickSelectMax********
		
		//METHOD 2
		/*if (k == pivIndex) {
			if (k == half) {
			
			}
			else if (k < half) {
			
			}
			else {
			
			}
		}
		else {
			if (k == arr.length) {
				return arr;
			}
			if (k > pivIndex) {
				return QuickSelectMaxNums(arr, pivIndex + 1, max, k);
			}
			else {
				return QuickSelectMaxNums(arr, min, pivIndex - 1, k);
			}
		}*/
		
		
		//METHOD 1
		/*if (k == pivIndex) {
			for (int i = 0; i < k; i++) {
				maxNums[i] = arr[pivIndex];
				pivIndex++;
			}
			return maxNums;
		}
		else {
			if (k == arr.length) {
				return arr;
			}
			if (k > pivIndex) {
				return QuickSelectMaxNums(arr, pivIndex + 1, max, k);
			}
			else {
				return QuickSelectMaxNums(arr, min, pivIndex - 1, k);
			}
		}*/
	}
	
	
	/**
	 *
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	
	private int partition(int[] arr, int start, int end) {
		//CORRECT
		int pivot = arr[end];
		int length = arr.length;
		int j = 0;      //This is gonna be the location that switched with the pivot
		int k = end - 1;
		int temp = 0;
		for (int i = 0; i < length - 1; i++) {
			if (arr[j] < pivot) { //basically if the number is smaller than the pivot, we dont car and move to next index
				j++;
			}
			else {
				while (k > j) {              //Now that we have a number greater than the pivot, we want to find a
					if (arr[k] < pivot) {      //number on the other side of the array that is smaller than the pivot
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
	
	private int partitions(int[] arr, int start, int end) {
		//CORRECT
		int pivot = arr[end];
		int length = arr.length;
		int j = 0;      //This is gonna be the location that switched with the pivot
		int k = end - 1;
		int temp = 0;
		while (j < k) { // change to while loop to until j and k cross
			while (arr[j] < pivot && j < length) { //basically if the number is smaller than the pivot, we dont car and move to next index change to while
				j++;
			}
			
			while (arr[k] > pivot && k > 0) {              //Now that we have a number greater than the pivot, we want to find a
				k--;
			}
			if (j < k) {      //number on the other side of the array that is smaller than the pivot
				temp = arr[k];         //and swap them
				arr[k] = arr[j];
				arr[j] = temp;
			}
			
		}
		temp = arr[end];                //All the values to the left of j are less than the pivot, so the pivot goes
		arr[end] = arr[j];               //at j
		arr[j] = temp;
		return j;
		
		
		//*********************************Starting here are my failed attempts at partition***************************
		
		
		//ATTEMPT 4
		/*int i = start;
		int j = end - 1;
		int pivot = arr[end];
		int temp = 0;
		
		while(i < j) {
			if(arr[i] <= pivot) {
				i++;
			}
			else {
				while(i<j) {
					if(arr[j] >= pivot) {
						j--;
					}
					else {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;
		return i + 1;
		*//*
		
		
		
		
		//ATTEMPT 1
		*//*int length = arr.length;
		int pivot = arr[length];
		int temp = 0;
		while (start < end) {
			if(arr[start] > pivot) {
				if(arr[end] < pivot) {
					temp = arr[start];
					arr[start] = arr[end];
					arr[end] = temp;
				}
				else {
					end--;
				}
			}
			else {
				start++;
			}
		}*//*
		
		//ATTEMPT 2
		*//*int length = arr.length;
		int pivot = arr[end];
		int temp = 0;
		while (start < end) {
			if (arr[start] < pivot) {
				start++;
				if(start == end) {
					return start;
				}
			}
			else {
				while(arr[end] > pivot) {
					end--;
				}
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		temp = arr[start + 1];
		arr[start + 1] = arr[end];
		arr[end] = temp;
		return start + 1;
		
		 *//*
		
		//ATTEMPT 3
		*//*int pivot = arr[end];
		int temp = 0;
		int length = arr.length;
		while(start < end) {
			if(arr[start] <= pivot) {
				start++;
				if(start == end) {
					return end;
				}
			}
			else {
				while (arr[end] >= pivot && start < end) {
					end--;
				}
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		temp = arr[start];
		arr[start] = arr[length-1];
		arr[length-1] = temp;
		return start;
		
		 *//*
		
		
		
		
		
		
	}*/
	}
}
