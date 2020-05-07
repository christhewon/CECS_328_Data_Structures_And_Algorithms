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
		
		
		
		for(int i = 0; i < nodes.length; i++) {
			String s = str.substring(i,i+1);
			nodes[i] = new Node(s);
		}
		
		System.out.println("Nodes:");
		for(int i = 0; i < nodes.length; i++) {
			System.out.print(nodes[i].getName() + ", ");
		}
		System.out.println();
		
		////////////////Ask user for adj not comma or spaces
		String adjIn = "";
		char letter = '-';
		Node curAdj;
		int ascii = -1;
		int key = -1;
		
		for(int i = 0; i < nodes.length; i++) {
			curAdj = nodes[i];
			System.out.println("Please enter all the nodes adjacent to '" + curAdj.getName()
			 + "' with no spaces or commas");
			adjIn = input.nextLine();
			for(int j = 0; j < adjIn.length(); j++) {
				ascii = (int)adjIn.charAt(j);
				key = binaryAscii(nodes, ascii);
				if(key != -1) {
					curAdj.getAdjList().add(nodes[key]);
				}
			}
		}
		
		/*
		// Testing adj List
		for(int i = 0; i < nodes.length; i++) {
			Node cur = nodes[i];
			System.out.println();
			for(int j = 0; j < cur.getAdjList().size(); j++) {
				System.out.print(cur.getAdjList().get(j).getName() + ", ");
			}
		}
		
	 */
		
		//DFS
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
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Node nod = new Node("nod");
		Node nod2 = new Node("nod1");
		Node nod3 = new Node("nod2");
		
		nod.getAdjList().add(nod2);
		nod.getAdjList().add(nod3);
		
		 */
		


		
		
	}
	
	/**
	 *
	 * @param n
	 * @param key
	 * @return
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
