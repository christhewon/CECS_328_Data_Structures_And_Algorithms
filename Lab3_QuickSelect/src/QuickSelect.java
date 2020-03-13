public class QuickSelect {
	
	public int QuickSelect(int[] arr, int min, int max,int k) {
		int pivIndex = partition(arr, min, max);
		
		if (k == pivIndex) {
			return arr[pivIndex];
		}
		else {
			if (k > pivIndex) {
				return QuickSelect(arr, pivIndex + 1, max, k);
			}
			else {
				return QuickSelect(arr, min, pivIndex - 1, k);
			}
		}
	}
	
	
	
	/*private int Partition(int[] arr) { //star and end are indexes
		int i = -1;
		int pivot = arr[arr.length - 1];
		for (int j = 0; j < arr.length - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				
				//swaping element i and j
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[arr.length - 1];
		arr[arr.length - 1] = temp;
		return i - 1;
	}*/
	
	
	private int partition(int[] arr, int start, int end) { //star and end are indexes
		int i = start - 1;
		int pivot = arr[end];
		for (int j = start; j < end; j++) {
			if (arr[j] < pivot) {
				i++;
				
				//swaping element i and j
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;
		return i + 1;
	}
	
}
