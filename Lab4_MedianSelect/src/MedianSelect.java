public class MedianSelect {
	public int[] select(int[] arr, int k) {
		int len = arr.length;
		int[] diff = new int[len];
		//int[] abs = new int[len];
		//int[] neg = new int[len];
		int[] ans;
		boolean medianCheck = true;
		
		int medianIndex; //index of where the median will be
		if (len % 2 == 0) { // for arrays of even length
			medianIndex = QuickSelectForMed.QuickSelect(arr, 0, len - 1, len/2 - 1);
		}
		else { //for arrays of odd length
			medianIndex = QuickSelectForMed.QuickSelect(arr, 0, len - 1, len/2);
		}
		
		int median = arr[medianIndex];
		
		System.out.println("median is " + median);
		
		System.out.println("arr after median Quick Select: ");
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("");
		System.out.println("diff arr is: ");
		for (int i = 0; i < len; i++) {
			diff[i] = arr[i] - median;
			System.out.print(diff[i] + " ");
		}
		System.out.println("");
		
		int index = QuickSelectForMed.QuickSelectAbs(diff, 0, len - 1, k); //This quick selects the diff arr and
																			// places all values with the least abs
																			 // value before the Kth index that the
																			  // user inputs and then returns that index
		ans = new int[index + 1]; // + 1 because the for loop in line 43, i goes to index 2

		/*
		System.out.println("Diff arr after quick select: "); // Just checking the diff arr after the quick select.
		for (int i = 0; i < diff.length; i++) {
			System.out.print(diff[i] + ", ");
		}
		*/
		System.out.println("");
		System.out.println("index from diff is: " + index);
		
		for (int i = 0; i < index + 1; i++) {
			//if (arr[i] == median && medianCheck) {
			if (diff[i] == 0 && medianCheck) { //checking if we are including the median, but allows any number after that
				medianCheck = false;            // is the same as median
			}
			else {
				ans[i] = diff[i] + median;      //returning back to original value
			}
			
		}
		return ans;
	}
}
