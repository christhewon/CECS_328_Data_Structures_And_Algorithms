public class tester {
	public static void main(String[] args) {
		
		//Tester for prob 1
		int[] arr = new int[]{5,6,34,78,99,2};
		int ans = Methods.findMins2(arr);
		System.out.println(ans);
		
		
		
		
		//Tester for prob 2
		int[][] matrix = { {1,5,8,20},
		                   {2,7,23,28},
		                   {5,8,12,22} };
		int[] arr2 = Methods.convergeMatrixSort(matrix);
		int length = arr2.length;
		System.out.println();
		
		//Methods.heapSort(arr, length);
		System.out.println("After sorted");
		for(int i = 0; i < length; i++) {
			System.out.print(arr2[i] + ", ");
		}
		
		
		
		
		
	}
}
