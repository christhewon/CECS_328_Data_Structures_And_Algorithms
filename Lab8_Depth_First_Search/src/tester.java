import java.util.LinkedList;
import java.util.Scanner;

public class tester {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int length = 0;
		System.out.println("Please enter the number of vertices you want, 1 - 26");
		length = input.nextInt();
		input.nextLine();
		Node[] nodes = new Node[length];
		String str = "abcdefghijklmnopqrstuvwxyz";
		
		//Creates 26 nodes with names from a-z
		for(int i = 0; i < nodes.length; i++) {
			String s = str.substring(i,i+1);
			nodes[i] = new Node(s);
		}
		
		System.out.println("Nodes:");
		for(int i = 0; i < nodes.length; i++) {
			System.out.print(nodes[i].getName() + ", ");
		}
		System.out.println();
		
		String adjIn = "";
		char letter = '-';
		Node curAdj;
		int ascii = -1;
		int key = -1;
		
		//Asks the user to enter the adj nodes for each node in order to create a graph
		for(int i = 0; i < nodes.length; i++) {
			curAdj = nodes[i];
			System.out.println("Please enter all the nodes adjacent to '" + curAdj.getName()
			 + "' with no spaces or commas");
			adjIn = input.nextLine();
			for(int j = 0; j < adjIn.length(); j++) {
				key = -1;
				ascii = (int)adjIn.charAt(j);
				key = binaryAscii(nodes, ascii);
				if(key != -1) {
					curAdj.getAdjList().add(nodes[key]);
				}
			}
		}
		
		// Testing adj List
		/*
		for(int i = 0; i < nodes.length; i++) {
			Node cur = nodes[i];
			System.out.println();
			for(int j = 0; j < cur.getAdjList().size(); j++) {
				System.out.print(cur.getAdjList().get(j).getName() + ", ");
			}
		}
		
	    */
		
		//Running the DFS algorithm
		LinkedList<Node> topology = new LinkedList<Node>();
		DepthFirstSearch dfs = new DepthFirstSearch();
		topology = dfs.DFS(nodes);
		if(!dfs.getCycle()) {
			System.out.println("Topological order is: ");
			for(int i = topology.size() - 1; i >= 0; i--) {
				Node curTop = topology.get(i);
				System.out.println(curTop.getName() + " " + curTop.getStart() + "/" + curTop.getEnd() + ", ");
			}
		}
	}
	
	/**
	 * Uses the concept of the Binary Search to go through an array of Nodes to find a node
	 *  with the name whose character's ascii number is equal to key
	 * @param n the array of nodes being searched through
	 * @param key the character ascii value being looked for
	 * @return the index of the node with the name whose character's ascii number is equal to key
	 */
	public static int binaryAscii(Node[] n, int key) {
		int left = 0;
		int right = n.length;
		int middle = 0;
		boolean wentRight = false;
		while (left <= right) {
			middle = (left + right)/2;
			if (n[middle].getName().charAt(0) == key) {
				return middle;
			}
			if (n[middle].getName().charAt(0) < key) {
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
