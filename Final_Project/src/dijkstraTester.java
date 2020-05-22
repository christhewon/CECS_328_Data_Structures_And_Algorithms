import java.util.ArrayList;
import java.util.Scanner;

public class dijkstraTester {
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
		
		int small = Integer.MIN_VALUE;
		String adjIn = "";
		int adjNum = small;
		char letter = '-';
		Node curAdj;
		int ascii = small;
		int key = small;
		
		//input.nextLine();
		//Asks the user to enter the adj nodes and weights
		for(int i = 0; i < nodes.length; i++) {
			//Entering adj nodes
			curAdj = nodes[i];
			System.out.println("Please enter all the nodes adjacent to '" + curAdj.getName()
			 + "' seperated by commas");
			adjIn = input.nextLine();
			for(int j = 0; j < adjIn.length(); j++) {
				String sub = adjIn.substring(j,j + 1);
				if(!(sub.equals(","))) {
					//key = small;
					ascii = (int)adjIn.charAt(j);
					key = binaryAscii(nodes, ascii);
					if(key != -1) {
						curAdj.getAdjList().add(nodes[key]);
					}
				}
				
			}
			
			//Entering Adj weights
			for(int j = 0; j < curAdj.getAdjList().size(); j++) {  
				System.out.println("Please enter the weight for the edge from " + curAdj.getName() + " to " + curAdj.getAdjList().get(j).getName());
				adjNum = input.nextInt();
				input.nextLine();
				curAdj.getAdjCost().add(adjNum);
			}
		}
		
		Dijkstra.Dijkstras(nodes[0]);
		for(int i = 0; i < nodes.length; i++) {
			System.out.println("distance to " + nodes[i].getName() + " is: " + nodes[i].getDistance());
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
