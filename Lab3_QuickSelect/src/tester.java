import java.util.Scanner;

public class tester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter an integer: ");
		int n = input.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int rand = (int)(Math.random()*200) - 100;
			arr[i] = rand;
			System.out.print(rand + ", ");
		}
		System.out.println();
		QuickSelect quickSelect = new QuickSelect();
		
		//QuickSelect Test
		System.out.println("Please enter an integer from 1 to the integer you entered earlier");
		int num = input.nextInt();
		num -= 1;
		int quickAnswer = quickSelect.QuickSelect(arr,0,n - 1,num);
		System.out.println(quickAnswer);
		
		//QuickSelectMax Test
		System.out.println("Please enter an integer from 1 to the integer you entered earlier");
		num = input.nextInt();
		int[] maxArr = quickSelect.QuickSelectMaxNums(arr,0,n - 1,num);
		
		for (int i = 0; i < num; i++) {
			System.out.print(maxArr[i] + ", ");
		}
		
		
		/*int[] arr = new int[5];
		arr[0] = -23;
		arr[1] = 5;
		arr[2] = -20;
		arr[3] = 6;
		arr[4] = 40;
		
		QuickSelect quickSelect = new QuickSelect();
		int quickAnswer = quickSelect.QuickSelect(arr,0,arr.length-1, 2);
		*/
		
		/*
		Scanner input = new Scanner(System.in);
		int[] arr = new int[] {5,6,214,32,53,2,78,43243,213,531};
		QuickSelect quick = new QuickSelect();
		System.out.println("Enter a number from 1 to the length of the array: ");
		int userNum = input.nextInt();
		/*userNum -= 1;
		
		
		
		
		int ans = quick.QuickSelect(arr, 0, arr.length - 1, userNum);
		System.out.println("The answer is: " + ans);
		
		int[] ans = quick.QuickSelectMaxNums(arr,0,arr.length - 1, userNum);
		System.out.println("ans length is: " + ans.length);
		for (int i = 0; i < ans.length; i++) {
			System.out.println("ans is: " + ans[i]);
		}
		*/
	}
}
