public class SquareRoot {
	/**
	 * Takes a number n and finds the square root of that number
	 * If it is not a perfect square, it finds the square root of the closest perfect square under n
	 * @param n - The number of which the square root is trying to be found
	 * @return - The square root or the smaller closest square root
	 */
	public static int squareRoots(int n) {
		int left = 0;
		int right = n;
		int middle = 0;
		boolean wentRight = false;
		while (left <= right) {
			middle = (left + right)/2;
			if (Math.pow(middle,2) == n) {
				return middle;
			}
			if (Math.pow(middle,2) < n) {
				left = middle + 1;
				wentRight = false;
			}
			else {
				right = middle - 1;
				wentRight = true;
				
			}
			
		}
		if (wentRight) {
			return middle - 1;
		}
		return middle;
		
	}
}
