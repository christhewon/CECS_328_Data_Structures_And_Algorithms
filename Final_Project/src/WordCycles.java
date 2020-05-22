public class WordCycles {
	
	/**
	 * Given an array of string, It checks whether a cycle can be created or not
	 *  A cycle is created if string A comes right after String B and if the last character of B
	 *  is the same as the first character of A
	 * @param arr the array of strings
	 * @return true if there is a cycle, false otherwise
	 */
	public static boolean cycleCheck(String[] arr) {
		int length = arr.length;
		String first = "";
		String second = "";
		Node[] nodes = new Node[length];
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		for(int i = 0; i < length; i++) {
			nodes[i] = new Node(arr[i]);
		}
		for(int i = 0; i < length; i++) {
			first = getFirst(nodes[i].getName());
			for(int j = 0; j < length; j++) {
				second = getLast(nodes[j].getName());
				if(first.equals(second)) {
					nodes[j].getAdjList().add(nodes[i]);
				}
			}
		}
		depthFirstSearch.DFS(nodes);
		if(depthFirstSearch.getCycle()) {
			System.out.println("Yes!");
			return true;
		}
		else {
			System.out.println("No!");
			return false;
		}
	}
	
	/**
	 * Returns the last character of a string
	 * @param s the string which the last character is coming from
	 * @return the last character of the string
	 */
	public static String getLast(String s) {
		int length = s.length();
		return s.substring(length - 1, length);
	}
	
	/**
	 * Returns the first character of a string
	 * @param s the string which the first character is coming from
	 * @return the first character of the string
	 */
	public static String getFirst(String s) {
		return s.substring(0,1);
	}
}
