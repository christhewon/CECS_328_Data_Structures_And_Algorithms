import java.util.Arrays;

public class Mpss {
	public static int minimumPositiveSubSequence(int[] arr, int l, int r) {
		int mpssl;
		int mpssr;
		int mpssm;
		int mid = (l + r)/2;
		int min = 0;
		
		if (l == r) { // if negative return inf
			if(arr[0] > 0)
				return arr[0];
			else {
				return Integer.MAX_VALUE;
			}
		}
		else {
			mpssl = minimumPositiveSubSequence(arr, l, mid);
			mpssr = minimumPositiveSubSequence(arr, mid + 1, r);
			mpssm = findMPSS(arr, l, r);
			min = Math.min(mpssl,mpssr);
			return Math.min(min, mpssm);
		}
		
					/*
		System.out.println("left: ");
		for(int i = mid; i >= 0; i--) {
			System.out.print(sL[i]);
		}
		System.out.println();
		System.out.print("right: ");
		for(int i = mid; i >= 0; i--) {
			System.out.print(sR[i]);
		}
	
		*/
		
		

		
	}
	
	public static int findMPSS(int[] arr, int l, int r) {
		int mid = (l + r)/2;
		int[] sL = new int[mid + 1];
		int[] sR = new int[mid + 1];
		int rightSum = 0;
		int leftSum = 0;
		int ans = 0;
		
		//left arr
		for(int i = mid; i >= l; i--) {
			leftSum += arr[i];
			sL[i] = leftSum;
		}
		
		
		//right arr
		for(int i = mid + 1; i <= r; i++) {
			rightSum += arr[i];
			sR[i - mid - 1] = rightSum;
		}
		
		
		//quickSort(sL);
		//quickSortDescend(sR);
		Arrays.sort(sL);
		Arrays.sort(sR);
		
		//changing SR to be descending
		int left = 0;
		int right = sR.length - 1;
		while(left < right) {
			int temp = sR[left];
			sR[left] = sR[right];
			sR[right] = temp;
			left++;
			right--;
		}
		
		//TEST
		System.out.println("This is the left arr");
		for(int i = 0; i < sL.length; i++) {
			System.out.print(sL[i] + ", ");
		}
		System.out.println();
		
		System.out.println("This is the right arr");
		for(int i = 0; i < sR.length; i++) {
			System.out.print(sR[i] + ", ");
		}
		
		int i = 0;
		int j = 0;
		int sMin = Integer.MAX_VALUE;
		
		while(i < sL.length && j < sR.length) {
			int s = sL[i] + sR[j];
			if(s <= 0) {
				i++;
			}
			else if(s < sMin) {
				sMin = s;
				j++;
			}
			else { //s > sMin
				j++;
			}
		}
		ans = sMin;
		return ans;
	}
	
	
	public static void quickSort(int[] arr, int start, int end) {
	
	}
	
	public static void quickSortDescend(int[] arr, int start, int end) {
	
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
	
		/*
	public static int[] quickSor(int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		int piv = arr.length - 1;
		int temper = 0;
		while(true) {
			if(arr[l] <= piv) {
				l++;
			}
			else {
				while(arr[r] >= piv) {
					r++;
				}
				temper = arr[l];
				arr[l] = arr[r];
				arr[r] = temper;
			}
			if(l > r) {
				return arr;
			}
		}
		
		 */
	}

	
}
