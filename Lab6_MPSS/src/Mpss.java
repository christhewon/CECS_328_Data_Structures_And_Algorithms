import java.util.Arrays;

public class Mpss {
	/**
	 * takes an array and find the minimum positive subsequent sum
	 * @param arr the array being used to find the sum
	 * @param l the left bound index of the array
	 * @param r the right bound index of the array
	 * @return the minimum positive subsequent sum
	 */
	public static int minimumPositiveSubsequenceSum(int[] arr, int l, int r) {
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
			mpssl = minimumPositiveSubsequenceSum(arr, l, mid);
			mpssr = minimumPositiveSubsequenceSum(arr, mid + 1, r);
			mpssm = findMPSSm(arr, l, r);
			min = Math.min(mpssl,mpssr);
			return Math.min(min, mpssm);
		}
	}
	
	/**
	 * Finds the minimum positive subsequent sum that may cross the left and right half of the array
	 * @param arr the array being used to find the sum
	 * @param l the left bound index of the array
	 * @param r the right bound index of the array
	 * @return the minimum positive subsequent sum of the middle(crossing the left or right half of the array)
	 */
	public static int findMPSSm(int[] arr, int l, int r) {
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
		/*
		System.out.println("This is the left arr");
		for(int i = 0; i < sL.length; i++) {
			System.out.print(sL[i] + ", ");
		}
		System.out.println();
		
		System.out.println("This is the right arr");
		for(int i = 0; i < sR.length; i++) {
			System.out.print(sR[i] + ", ");
		}
		*/
		
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
	

	
}
